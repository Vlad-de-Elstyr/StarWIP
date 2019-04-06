package com.alkerth.game.Background;

import com.alkerth.game.Interfaces.IUpdatable;
import com.alkerth.game.StarWIP;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BackgroundProvider implements IUpdatable {

    private List<BackgroundObject> backgroundObjects;

    private float spawnRate;

    public BackgroundProvider() {
        this.setSpawnRate(0.01f);
        this.setBackgroundObjects(new ArrayList<BackgroundObject>());
        for (int i = 0; i < (int)(Math.random() * 300); i++) {
            int size = (int)(Math.random() * 16);
            Star star = new Star(StarWIP.assetProvider.getTexture("star"), (int)(Math.random() * 1000), (int)(Math.random() * 800),
                    new Vector2(size , size), new Vector2(10, 10));
            this.getBackgroundObjects().add(star);
        }
    }

    @Override
    public void update(SpriteBatch batch) {
        Iterator<BackgroundObject> i = this.getBackgroundObjects().iterator();
        while (i.hasNext()) {
            BackgroundObject bo = i.next();
            bo.update(batch);
            if (bo.isOutOfBounds(StarWIP.width, StarWIP.height)) {
                i.remove();
            }

        }

        if (Math.random() < this.getSpawnRate()) {
            //createNewObject();
        }
    }

    public List<BackgroundObject> getBackgroundObjects() {
        return backgroundObjects;
    }

    public void setBackgroundObjects(List<BackgroundObject> backgroundObjects) {
        this.backgroundObjects = backgroundObjects;
    }

    public float getSpawnRate() {
        return spawnRate;
    }

    public void setSpawnRate(float spawnRate) {
        this.spawnRate = spawnRate;
    }
}
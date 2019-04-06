package com.alkerth.game.Background;

import com.alkerth.game.Interfaces.IUpdatable;
import com.alkerth.game.StarWIP;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class BackgroundProvider implements IUpdatable {

    private List<BackgroundObject> backgroundObjects;

    public BackgroundProvider() {
        this.setBackgroundObjects(new ArrayList<BackgroundObject>());
        for (int i = 0; i < (int)(Math.random() * 300); i++) {
            Star star = new Star(StarWIP.assetProvider.getTexture("star"), (int)(Math.random() * 1000), (int)(Math.random() * 800),
                    new Vector2((int)(Math.random() * 16), (int)(Math.random() * 16)), new Vector2(10, 10));
            this.getBackgroundObjects().add(star);
        }
    }

    @Override
    public void update(SpriteBatch batch) {
        for (BackgroundObject bo : this.getBackgroundObjects()) {
            bo.update(batch);
        }
    }

    public List<BackgroundObject> getBackgroundObjects() {
        return backgroundObjects;
    }

    public void setBackgroundObjects(List<BackgroundObject> backgroundObjects) {
        this.backgroundObjects = backgroundObjects;
    }
}

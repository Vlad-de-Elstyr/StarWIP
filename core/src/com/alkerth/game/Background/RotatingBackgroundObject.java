package com.alkerth.game.Background;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class RotatingBackgroundObject extends BackgroundObject {

    private int rotation;

    public RotatingBackgroundObject(Texture texture, int x, int y, Vector2 size, Vector2 vel, int rotation) {
        super(texture, x, y, size, vel);
        this.setRotation(rotation);
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
}

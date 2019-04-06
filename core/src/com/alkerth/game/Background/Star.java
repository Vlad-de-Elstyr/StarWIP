package com.alkerth.game.Background;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Star extends RotatingBackgroundObject {

    public Star(Texture texture, int x, int y, Vector2 size, Vector2 vel) {
        super(texture, x, y, size, vel, (int)(Math.random() * 2));
    }

    public Star(Texture texture, int x, int y, Vector2 size, Vector2 vel, int rotation) {
        super(texture, x, y, size, vel, rotation);
    }
}

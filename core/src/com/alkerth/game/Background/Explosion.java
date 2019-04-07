package com.alkerth.game.Background;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Explosion extends AnimatedBackgroundObject {
    public Explosion(Texture texture, int x, int y, Vector2 size, int columns, int rows) {
        super(texture, x, y, size, new Vector2(0, 0), columns, rows);
        this.setRepeat(false);

    }
}

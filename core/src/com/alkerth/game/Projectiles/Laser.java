package com.alkerth.game.Projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Laser extends Projectile {
    public Laser(Texture texture, int x, int y, int damage) {
        super(texture, x, y, new Vector2(0, 500), new Vector3(0, 0, 0), damage);
    }
}

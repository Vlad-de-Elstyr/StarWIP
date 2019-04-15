package com.alkerth.game.Ships;

import com.alkerth.game.Projectiles.Projectile;
import com.badlogic.gdx.math.Vector2;

abstract class Weapon extends Equipment{

    public Weapon(Vector2 offset) {
        super(offset);
    }

    public Weapon() {
        super();
    }

    abstract Projectile[] createProjectiles(int offsetX, int offsetY);


}

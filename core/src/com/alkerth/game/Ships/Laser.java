package com.alkerth.game.Ships;

import com.alkerth.game.Projectiles.LaserProjectile;
import com.alkerth.game.Projectiles.Projectile;
import com.badlogic.gdx.math.Vector2;

public class Laser extends Weapon {

    public Laser() {
        super();
    }

    public Laser(Vector2 offset) {
        super(offset);
    }


    @Override
    Projectile[] createProjectiles(int offsetX, int offsetY) {
        Projectile[] p = new Projectile[1];
        p[0] = new LaserProjectile(offsetX, offsetY);
        return p;
    }
}

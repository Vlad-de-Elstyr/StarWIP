package com.alkerth.game.Ships;

import com.alkerth.game.Projectiles.LaserProjectile;
import com.alkerth.game.Projectiles.Projectile;

public class Laser extends Weapon {


    @Override
    Projectile[] createProjectiles(int offsetX, int offsetY) {
        Projectile[] p = new Projectile[1];
        p[0] = new LaserProjectile(offsetX, offsetY);
        return p;
    }
}

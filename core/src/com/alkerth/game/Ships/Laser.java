package com.alkerth.game.Ships;

import com.alkerth.game.Projectiles.LaserProjectile;
import com.alkerth.game.Projectiles.Projectile;

public class Laser extends Weapon {


    @Override
    Projectile[] createProjectiles() {
        Projectile[] p = new Projectile[1];
        p[0] = new LaserProjectile(100, 100);
        return p;
    }
}

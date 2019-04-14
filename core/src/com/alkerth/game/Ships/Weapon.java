package com.alkerth.game.Ships;

import com.alkerth.game.Projectiles.Projectile;

abstract class Weapon {

    abstract Projectile[] createProjectiles(int offsetX, int offsetY);


}

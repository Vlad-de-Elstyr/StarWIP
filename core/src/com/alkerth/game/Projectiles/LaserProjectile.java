package com.alkerth.game.Projectiles;

import com.alkerth.game.StarWIP;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class LaserProjectile extends Projectile {
    public LaserProjectile(int x, int y) {
        super(StarWIP.assetProvider.getTexture("laser"), x, y, new Vector2(0, 500), new Vector3(0, 0, 0), 50);
    }
}

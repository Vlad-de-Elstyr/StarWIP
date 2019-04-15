package com.alkerth.game.Factories;

import com.alkerth.game.Enemy;
import com.alkerth.game.Ships.Ship;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.collision.BoundingBox;

import java.util.List;

public abstract class EnemyFactory {

    private byte strength;
    private BoundingBox spawnBox;
    private Vector2 spawnPoint;


    abstract Enemy generateEnemy();
    abstract List<Enemy> generateEnemies(int amount);

    public byte getStrength() {
        return strength;
    }

    public void setStrength(byte strength) {
        this.strength = strength;
    }

    public BoundingBox getSpawnBox() {
        return spawnBox;
    }

    public void setSpawnBox(BoundingBox spawnBox) {
        this.spawnBox = spawnBox;
    }

    public Vector2 getSpawnPoint() {
        return spawnPoint;
    }

    public void setSpawnPoint(Vector2 spawnPoint) {
        this.spawnPoint = spawnPoint;
    }
}

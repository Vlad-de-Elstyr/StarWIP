package com.alkerth.game.Factories;

import com.alkerth.game.CollisionList;
import com.alkerth.game.Enemy;
import com.alkerth.game.Ships.Ship;

import java.util.List;

public class EasyEnemyFactory extends EnemyFactory {


    @Override
    Enemy generateEnemy() {
        Enemy e = new Enemy();
        return e;
    }

    @Override
    List<Enemy> generateEnemies(int amount) {
        List<Enemy> enemies = new CollisionList<Enemy>();
        for(int i =0; i < amount; i++) {
            Enemy e = generateEnemy();
            enemies.add(e);
        }
        return enemies;
    }
}

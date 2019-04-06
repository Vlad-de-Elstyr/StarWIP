package com.alkerth.game;

import com.alkerth.game.Interfaces.ICollidable;

import java.util.ArrayList;

public class CollisionList<T extends ICollidable> extends ArrayList<T> {


    @Override
    public boolean add(T t) {
        CollisionDetector.collisionList.add(t);
        return super.add(t);
    }
}

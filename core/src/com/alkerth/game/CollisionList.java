package com.alkerth.game;

import com.alkerth.game.Interfaces.ICollidable;

import java.util.ArrayList;

public class CollisionList<T extends ICollidable> extends ArrayList<T> {


    @Override
    public boolean add(T t) {
        CollisionDetector.collisionList.add(t);
        return super.add(t);
    }

    @Override
    public boolean remove(Object o) {
        CollisionDetector.collisionList.remove(o);
        return super.remove(o);
    }
}

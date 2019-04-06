package com.alkerth.game;

import com.alkerth.game.Interfaces.ICollidable;

import java.util.ArrayList;
import java.util.List;

public class CollisionDetector {

    public static List<ICollidable> collisionList = new ArrayList<ICollidable>();

    public static void checkForCollisions() {
        for (ICollidable me : collisionList) {
            for (ICollidable other : collisionList) {
                if (me.getBoundingBox().intersects(other.getBoundingBox())) {
                    // TODO implement Kollision
                }
            }
        }

    }
}

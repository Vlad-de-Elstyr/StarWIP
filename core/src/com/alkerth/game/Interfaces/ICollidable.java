package com.alkerth.game.Interfaces;

import com.badlogic.gdx.math.collision.BoundingBox;

public interface ICollidable {

    public void handleCollision(ICollidable other);
    public BoundingBox getBoundingBox();
    public void updateBoundingBox();
}

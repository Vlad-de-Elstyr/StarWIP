package com.alkerth.game.Interfaces;

import com.badlogic.gdx.math.collision.BoundingBox;

public interface ICollidable {

    public boolean collides(ICollidable other);
    public BoundingBox getBoundingBox();
    public void updateBoundingBox();
}

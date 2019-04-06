package com.alkerth.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class MovingObject {

    private int x;
    private int y;
    private Vector2 vel;

    public MovingObject(int x, int y, Vector2 vel) {
        this.setX(x);
        this.setY(y);
        this.setVel(vel);
    }

    public void move() {
        float delta = Gdx.graphics.getDeltaTime();
        int x = this.getX();
        int y = this.getY();
        float changeX = getVel().x * delta < 1 ? 1 : getVel().x * delta;
        float changeY = getVel().y * delta < 1 ? 1 : getVel().y * delta;
        if (this.getVel().x != 0){}
            this.setX((int)(x + changeX));
        if (this.getVel().y != 0) {}
            this.setY((int)(y + changeY));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Vector2 getVel() {
        return vel;
    }

    public void setVel(Vector2 vel) {
        this.vel = vel;
    }
}

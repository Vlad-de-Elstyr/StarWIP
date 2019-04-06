package com.alkerth.game;

import com.alkerth.game.Interfaces.ICollidable;
import com.alkerth.game.Interfaces.IUpdatable;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

public class Projectile extends MovingObject implements IUpdatable, ICollidable {


    private Vector3 velChange;
    private Texture texture;
    private BoundingBox boundingBox;

    public Projectile(Texture texture, int x, int y, Vector2 vel, Vector3 velChange) {
        super(x, y, vel);
        this.setTexture(texture);
        this.setVelChange(velChange);
        this.setBoundingBox(new BoundingBox(new Vector3(this.getX(), this.getY(), 0), new Vector3(this.getX() + this.getTexture().getWidth(), this.getY() + this.getTexture().getHeight(), 0)));
    }

    @Override
    public void update(SpriteBatch batch) {
        move();

        this.updateBoundingBox();

        batch.draw(getTexture(), getX(), getY());
    }


    public Vector3 getVelChange() {
        return velChange;
    }

    public void setVelChange(Vector3 velChange) {
        this.velChange = velChange;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public boolean collides(ICollidable other) {
        return false;
    }

    @Override
    public BoundingBox getBoundingBox() {
        return null;
    }

    @Override
    public void updateBoundingBox() {
        BoundingBox b = new BoundingBox();
        Vector3 min = new Vector3(this.getX(), this.getY(), 0);
        Vector3 max = new Vector3(this.getX() + this.getTexture().getWidth(), this.getY() + this.getTexture().getHeight(), 0);
        b.set(min, max);
        this.setBoundingBox(b);
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }
}

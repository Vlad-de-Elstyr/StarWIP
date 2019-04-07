package com.alkerth.game.Projectiles;

import com.alkerth.game.Enemy;
import com.alkerth.game.Interfaces.ICollidable;
import com.alkerth.game.Interfaces.IUpdatable;
import com.alkerth.game.MovingObject;
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

    private int damage;
    private boolean remove;

    public Projectile(Texture texture, int x, int y, Vector2 vel, Vector3 velChange, int damage) {
        super(x, y, vel);
        this.setTexture(texture);
        this.setVelChange(velChange);
        this.setDamage(damage);
        this.setRemove(false);
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
    public void handleCollision(ICollidable other) {
        if (other instanceof Enemy) {
            Enemy o = (Enemy)other;
            o.handleHit(this.getDamage());
            this.setRemove(true);
        }



    }

    @Override
    public BoundingBox getBoundingBox() {
        return boundingBox;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean canRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }
}

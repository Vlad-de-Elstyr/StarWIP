package com.alkerth.game;

import com.alkerth.game.Interfaces.ICollidable;
import com.alkerth.game.Interfaces.IUpdatable;
import com.alkerth.game.Projectiles.Projectile;
import com.alkerth.game.Ships.Ship;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

import java.util.Iterator;
import java.util.List;

public class Player extends AnimatedMovingObject implements IUpdatable, ICollidable {

    private int x;
    private int y;
    private Ship ship;
    private Vector3 destination;
    private Vector2 speed;
    private Vector3 accel;
    private Vector3 originAccel;
    private Vector3 maxSpeed;
    private int hitpoints;

    private List<Projectile> projectiles;
    private BoundingBox boundingBox;


    public Player(Ship ship, int x, int y, Vector2 vel, int hitpoints) {
        super(ship.getTexture(), x, y, vel, ship.getColumns(), ship.getRows());
        this.setX(x);
        this.setY(y);
        this.setSpeed(vel);
        this.setDestination(new Vector3(0, 0, 0));
        this.setAccel(new Vector3(10,10,0));
        this.setOriginAccel(new Vector3(getAccel().x, getAccel().y, 0));
        this.setMaxSpeed(new Vector3(150, 90, 0));
        this.setProjectiles(new CollisionList<Projectile>());
        this.setBoundingBox(new BoundingBox(new Vector3(this.getX(), this.getY(), 0), new Vector3(100, 100, 0)));
        this.setShip(ship);
    }

    @Override
    public void update(SpriteBatch batch) {
        /*if (!(getDestination().x == -1 || getDestination().y == -1)) {
            int signX = 0;
            int signY = 0;
            if (getDestination().x - getX() < 0) {
                signX = -1;
            } else if (getDestination().x - getX() > 0) {
                signX = 1;
            }

            if (getDestination().y - getY() < 0) {
                signY = -1;
            } else if (getDestination().y - getY() > 0) {
                signY = 1;
            }

            float delta = Gdx.graphics.getDeltaTime();
            int x = this.getX();
            int y = this.getY();
            this.setX((int)(x + getSpeed().x * delta * signX));
            this.setY((int)(y + getSpeed().y * delta * signY));

            Gdx.app.debug("StarWIP", "XXXX" + getSpeed().x * delta * signX);
            Gdx.app.debug("StarWIP", "YYYY" + getSpeed().x * delta * signY);


        }*/


        Iterator<Projectile> pr = getProjectiles().listIterator();
        while (pr.hasNext()) {
            Projectile p = pr.next();

            if (p.canRemove()) {
                pr.remove();
                CollisionDetector.collisionList.remove(p);
            }

            Vector2 center = getCenter();
            p.setShipCords(center);
            p.update(batch);

        }

        if (getDestination().x == 0) {
            resetAcceleration(0);
        } else if (getDestination().y == 0) {
            resetAcceleration(1);
        }

        float delta = Gdx.graphics.getDeltaTime();
        float accelX = this.getAccel().x;
        float accelY = this.getAccel().y;
        //getSpeed().x += accelX;
        //getSpeed().y += accelY;
        if (getDestination().x != 0)
            getAccel().x *= (getSpeed().x + accelX >= getMaxSpeed().x) ? 1 : 1.02f;
        if (getDestination().y != 0)
            getAccel().y *= (getSpeed().y + accelY >= getMaxSpeed().y) ? 1 : 1.02f;
        int x = this.getX();
        int y = this.getY();
        this.setX((int)(x + (getSpeed().x + accelX) * delta * getDestination().x));
        this.setY((int)(y + (getSpeed().y + accelY )* delta * getDestination().y));

        this.updateBoundingBox();

        //Gdx.app.debug("TESTING:X", getSpeed().x + "::" + getAccel().x);
        //Gdx.app.debug("TESTING:Y", getSpeed().y + "::" + getAccel().y);
        batch.draw(this.getNextTexture(), getX(), getY(), 100, 100);
    }

    public void fire() {
        /*Projectile p1 = new LaserProjectile(StarWIP.assetProvider.getTextures().get("laser"), getX() - 30, getY() + 100, 50);
        Projectile p2 = new LaserProjectile(StarWIP.assetProvider.getTextures().get("laser"), getX() + 30, getY() + 100, 50);

        this.getProjectiles().add(p1);
        this.getProjectiles().add(p2);*/
        List<Projectile> pr = getShip().fire();
        this.getProjectiles().addAll(pr);
    }

    public void resetAcceleration(int dim) {
        switch(dim) {
            case 0:
                this.getAccel().x = this.getOriginAccel().x;
                break;
            case 1:
                this.getAccel().y = this.getOriginAccel().y;
                break;
        }
    }

    public Vector2 getCenter () {
        return new Vector2(getX() + getTexture().getWidth() / 2, getY() + getTexture().getHeight() / 2);
    }

    public Vector3 getDestination() {
        return destination;
    }

    public void setDestination(Vector3 destination) {
        this.destination = destination;
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

    public Vector2 getSpeed() {
        return speed;
    }

    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }

    public Vector3 getAccel() {
        return accel;
    }

    public void setAccel(Vector3 accel) {
        this.accel = accel;
    }

    public Vector3 getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Vector3 maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Vector3 getOriginAccel() {
        return originAccel;
    }

    public void setOriginAccel(Vector3 originAccel) {
        this.originAccel = originAccel;
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(List<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    @Override
    public void handleCollision(ICollidable other) {

    }

    @Override
    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    @Override
    public void updateBoundingBox() {

        BoundingBox b = new BoundingBox();
        Vector3 min = new Vector3(this.getX(), this.getY(), 0);
        Vector3 max = new Vector3(this.getX() + this.getShip().getTexture().getWidth(), this.getY() + this.getShip().getTexture().getHeight(), 0);
        b.set(min, max);
        this.setBoundingBox(b);

    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }
}

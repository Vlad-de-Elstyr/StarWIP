package com.alkerth.game;

import com.alkerth.game.Background.Explosion;
import com.alkerth.game.Interfaces.ICollidable;
import com.alkerth.game.Interfaces.IUpdatable;
import com.alkerth.game.Projectiles.Projectile;
import com.alkerth.game.Ships.Ship;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends AnimatedMovingObject implements IUpdatable, ICollidable {

    private Ship ship;
    private List<Projectile> projectiles = new CollisionList<Projectile>();
    private List<Explosion> explosions;
    private float fireRate;
    private long lastProjectile;
    private int hitpoints;

    private BoundingBox boundingBox;

    public Enemy(Ship ship, int x, int y, Vector2 vel, float fireRate, int hitpoints) {
        super(ship.getTexture(), x, y, vel, ship.getColumns(), ship.getRows());
        this.setShip(ship);
        this.setFireRate(fireRate);
        this.setLastProjectile(System.currentTimeMillis());
        this.setHitpoints(hitpoints);
        this.setExplosions(new ArrayList<Explosion>());
        this.setBoundingBox(new BoundingBox(new Vector3(this.getX(), this.getY(), 0), new Vector3(this.getX() + this.getShip().getTexture().getWidth(), this.getY() + this.getShip().getTexture().getHeight(), 0)));

    }

    @Override
    public void update(SpriteBatch batch) {

        for (IUpdatable proj : getProjectiles()) {
            proj.update(batch);
        }
        for (Explosion e : getExplosions()) {
            Gdx.app.debug("DEBUG", "SIZE" + getExplosions().size());
            e.update(batch);
        }


        move();
        if (getHitpoints() > 0) {
            batch.draw(this.getNextTexture(), this.getX(), this.getY(), 100, 100);
        }

        this.updateBoundingBox();

        if (System.currentTimeMillis() >= this.getLastProjectile() + this.getFireRate()) {
            /*this.setLastProjectile(System.currentTimeMillis());
            Projectile proj = new Projectile(StarWIP.assetProvider.getTexture("laser"), this.getX(), this.getY(), new Vector2(0, -50), new Vector3(0,0,0), 50);
            this.getProjectiles().add(proj);*/
        }
    }

    public void handleHit(int damage) {
        setHitpoints(getHitpoints() - damage);

        if (getHitpoints() <= 0) {
            getExplosions().add(new Explosion(StarWIP.assetProvider.getTexture("explosion"), getX(), getY(), new Vector2(100, 100), 5, 1));
        }
    }



    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }


    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(List<Projectile> projectiles) {
        this.projectiles = projectiles;
    }

    public float getFireRate() {
        return fireRate;
    }

    public void setFireRate(float fireRate) {
        this.fireRate = fireRate;
    }

    public long getLastProjectile() {
        return lastProjectile;
    }

    public void setLastProjectile(long lastProjectile) {
        this.lastProjectile = lastProjectile;
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

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public List<Explosion> getExplosions() {
        return explosions;
    }

    public void setExplosions(List<Explosion> explosions) {
        this.explosions = explosions;
    }
}

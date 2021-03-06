package com.alkerth.game.Ships;


import com.alkerth.game.CollisionList;
import com.alkerth.game.Projectiles.Projectile;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Part {

    private List<Weapon> weapons;
    private List<Shield> shields;
    private List<Engine> engines;
    private List<Hull> hulles;

    //private int relativePosition

    private Vector2 relativeOffset;

    public Part() {
        weapons = new ArrayList<Weapon>();
        shields = new ArrayList<Shield>();
        engines = new ArrayList<Engine>();
        hulles = new ArrayList<Hull>();

        //setRelativeOffset(new Vector2());
    }


    public int getHitpoints () {
        int h = 0;
        for (Hull hh: getHulles()) {
            h += hh.getHitpoints();
        }
        return h;
    }

    public List<Projectile> getProjectiles() {
        List<Projectile> p = new CollisionList<Projectile>();
        for ( Weapon w:
             getWeapons()) {
            Vector2 offset = w.getRelativeOffset();
            for (Projectile pp:
                 w.createProjectiles((int)(this.getRelativeOffset().x + offset.x), (int)(this.getRelativeOffset().y + offset.y))) {
                p.add(pp);
            }
        }

        return p;
    }

    public Vector2 getSpeed() {
        Vector2 s = new Vector2(0,0);
        for (Engine e:
             getEngines()) {
            s.x += e.getSpeed().x;
            s.y += e.getSpeed().y;
        }
        return s;
    }

    public int getShield() {
        int s = 0;
        for (Shield sh:
                getShields()) {
            s += sh.getShield();
        }
        return s;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public List<Shield> getShields() {
        return shields;
    }

    public void setShields(List<Shield> shields) {
        this.shields = shields;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }

    public List<Hull> getHulles() {
        return hulles;
    }

    public void setHulles(List<Hull> hulles) {
        this.hulles = hulles;
    }

    public Vector2 getRelativeOffset() {
        return relativeOffset;
    }

    public void setRelativeOffset(Vector2 relativeOffset) {
        this.relativeOffset = relativeOffset;
    }
}

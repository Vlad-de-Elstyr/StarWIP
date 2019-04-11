package com.alkerth.game.Ships;

import com.alkerth.game.CollisionList;
import com.alkerth.game.Projectiles.Projectile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private Texture texture;
    private int rows;
    private int columns;

    private List<Part> parts;

    public Ship(Texture texture, int rows, int columns) {
        this.setTexture(texture);
        this.setRows(rows);
        this.setColumns(columns);
        this.setParts(new ArrayList<Part>());
    }
    public int getHitpoints() {
        int h = 0;
        for (Part p:
             getParts()) {
            h += p.getHitpoints();
        }
        return h;
    }
    public Vector2 getSpeed() {
        Vector2 s = new Vector2(0,0);
        for (Part p:
                getParts()) {
            s.x += p.getSpeed().x;
            s.y += p.getSpeed().y;
        }
        return s;
    }
    public int getShield() {
        int sh = 0;
        for (Part p:
                getParts()) {
            sh += p.getShield();
        }
        return sh;
    }

    public List<Projectile> fire() {
        List<Projectile> p = new CollisionList<Projectile>();
        for (Part pp:
             getParts()) {
            List<Projectile> ppp = pp.getProjectiles();
            for (Projectile pr : ppp) {
                p.add(pr);
            }
        }
        return p;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}

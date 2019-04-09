package com.alkerth.game.Ships;

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

    public Projectile[] fire() {
        return null;
    }

    public Vector2 getSpeed() {
        return null;
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

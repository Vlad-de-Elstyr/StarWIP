package com.alkerth.game.Ships;

import com.badlogic.gdx.graphics.Texture;

public class Ship {

    private Texture texture;
    private int rows;
    private int columns;

    public Ship(Texture texture, int rows, int columns) {
        this.setTexture(texture);
        this.setRows(rows);
        this.setColumns(columns);
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
}

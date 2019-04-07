package com.alkerth.game.Background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class AnimatedBackgroundObject extends BackgroundObject {

    private int index;
    private int columns;
    private int rows;
    private TextureRegion[] regions;

    private boolean repeat;
    private boolean remove;
    private double intervall;
    private long timestamp;

    public AnimatedBackgroundObject(Texture texture, int x, int y, Vector2 size, Vector2 vel, int columns, int rows) {
        super(texture, x, y, size, vel);
        this.setIndex(0);
        this.setRows(rows);
        this.setColumns(columns);
        this.setRegions(new TextureRegion[rows * columns]);
        int w = getTexture().getWidth();
        int h = getTexture().getHeight();
        int wp = w / getColumns();
        int hp = h / getRows();
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                TextureRegion tr = new TextureRegion(getTexture(), wp * j, hp * i, wp, hp);
                getRegions()[i * getColumns() + j] = tr;
            }
        }
        this.setRepeat(true);
        this.setRemove(false);
        this.setIntervall(60);
        this.setTimestamp(System.currentTimeMillis());
    }

    @Override
    public void update(SpriteBatch batch) {
        if (!canRemove()) {
            batch.draw(getRegions()[getIndex()], getX(), getY(), getSize().x, getSize().y);
            if (System.currentTimeMillis() - getTimestamp() >= getIntervall()) {
                setIndex(getIndex() + 1);
                setTimestamp(System.currentTimeMillis());
            }
        }
        //Gdx.app.debug("DEBUG", getIndex() + "::" + this);
        if (getIndex() >= getRows() * getColumns()) {
            if (canRepeat()) {
                setIndex(0);
            } else {
                setRemove(true);
            }
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public TextureRegion[] getRegions() {
        return regions;
    }

    public void setRegions(TextureRegion[] regions) {
        this.regions = regions;
    }

    public boolean canRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public boolean canRemove() {
        return remove;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public double getIntervall() {
        return intervall;
    }

    public void setIntervall(double intervall) {
        this.intervall = intervall;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

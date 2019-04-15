package com.alkerth.game.Util;

import com.badlogic.gdx.math.Vector2;

public class MinMaxBoxBound {

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;

    private boolean includeBounds;

    public MinMaxBoxBound(int minX, int maxX, int minY, int maxY, boolean include) {
        this.setMinX(minX);
        this.setMaxX(maxX);
        this.setMinY(minY);
        this.setMaxY(maxY);
        this.setIncludeBounds(include);
    }

    public MinMaxBoxBound(int minX, int maxX, int minY, int maxY) {
        this(minX, maxX, minY, maxY, true);
    }

    public Vector2 generate() {
        Vector2 res = new Vector2(0, 0);
        int minX = getMinX();
        int maxX = getMaxX();
        int minY = getMinY();
        int maxY = getMaxY();
        if (isIncludeBounds()) {
            minX += 1;
            maxX -= 1;
            minY += 1;
            maxY -= 1;
        }
        res.x = (int)(Math.random() * (maxX - minX) + minX);
        res.y = (int)(Math.random() * (maxY - minY) + minY);
        return res;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public boolean isIncludeBounds() {
        return includeBounds;
    }

    public void setIncludeBounds(boolean includeBounds) {
        this.includeBounds = includeBounds;
    }
}

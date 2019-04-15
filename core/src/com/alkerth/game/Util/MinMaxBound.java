package com.alkerth.game.Util;

public class MinMaxBound {

    private int min;
    private int max;

    private boolean includeBounds;

    public MinMaxBound(int min, int max, boolean include) {
        this.setMin(min);
        this.setMax(max);
        this.setIncludeBounds(include);

        if (min >= max) {
            throw new NumberFormatException();
        }
    }

    public MinMaxBound(int min, int max) {
        this(min, max, true);
    }

    public int generate() {
        int min = getMin();
        int max = getMax();
        if (isIncludeBounds()) {
            min += 1;
            max -= 1;
        }
        return (int)(Math.random() * (max - min) + min);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isIncludeBounds() {
        return includeBounds;
    }

    public void setIncludeBounds(boolean includeBounds) {
        this.includeBounds = includeBounds;
    }
}

package com.alkerth.game.Ships;

import com.badlogic.gdx.math.Vector2;

public class Equipment {

    private Vector2 relativeOffset;

    public Equipment() {
        this.setRelativeOffset(new Vector2(0, 0));
    }

    public Equipment(Vector2 offset) {
        this.setRelativeOffset(offset);
    }

    public Vector2 getRelativeOffset() {
        return relativeOffset;
    }

    public void setRelativeOffset(Vector2 relativeOffset) {
        this.relativeOffset = relativeOffset;
    }
}

package com.alkerth.game.Ships;

import com.badlogic.gdx.graphics.Texture;

public class Ship {

    private Texture texture;

    public Ship(Texture texture) {
        this.setTexture(texture);
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}

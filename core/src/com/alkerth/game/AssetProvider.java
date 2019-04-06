package com.alkerth.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class AssetProvider {

    private HashMap<String, Texture> textures;

    public AssetProvider() {
        setTextures(new HashMap<String, Texture>());
    }

    public void dispose() {

    }

    public Texture getTexture(String tag) {
        return this.getTextures().get(tag);
    }

    public void addTexture(String tag, Texture texture) {
        this.getTextures().put(tag, texture);
    }

    public HashMap<String, Texture> getTextures() {
        return textures;
    }

    public void setTextures(HashMap<String, Texture> textures) {
        this.textures = textures;
    }
}


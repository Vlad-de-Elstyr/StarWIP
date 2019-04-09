package com.alkerth.game.Background;


import com.alkerth.game.Interfaces.IUpdatable;
import com.alkerth.game.MovingObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class BackgroundObject extends MovingObject implements IUpdatable {

    private Texture texture;
    private Vector2 size;

    public BackgroundObject(Texture texture, int x, int y, Vector2 size, Vector2 vel) {
        super(texture, x, y, vel);
        this.setTexture(texture);
        this.setSize(size);
    }


    @Override
    public void update(SpriteBatch batch) {
        move();
        batch.draw(getTexture(), getX(), getY(), getSize().x, getSize().y);
    }

    public boolean isOutOfBounds(int x, int y) {
        if (this.getX() < 0 || this.getX() > x)
            return true;
        if (this.getY() < 0 || this.getY() > y)
            return true;
        return false;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }



    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }




}

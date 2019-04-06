package com.alkerth.game.Background;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class RotatingBackgroundObject extends BackgroundObject {

    private int rotation;
    private int curRotation;

    public RotatingBackgroundObject(Texture texture, int x, int y, Vector2 size, Vector2 vel, int rotation) {
        super(texture, x, y, size, vel);
        this.setRotation(rotation);
        this.setCurRotation(0);
    }

    @Override
    public void update(SpriteBatch batch) {
        move();
        this.setCurRotation(this.getCurRotation() + this.getRotation());
        batch.draw(this.getTexture(), this.getX(), this.getY(), this.getSize().x / 2, this.getSize().y / 2, this.getSize().x, this.getSize().y,1,1,this.getCurRotation(),0,0, (int)this.getSize().x, (int)this.getSize().y, false, false);
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getCurRotation() {
        return curRotation;
    }

    public void setCurRotation(int curRotation) {
        this.curRotation = curRotation;
    }
}

package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Duck {
    private Texture texture;
    private Vector2 position;
    private Vector2 velocity;
    private Rectangle bounds;
    private boolean isKilled;


    private final int WIDTH = 216;
    private final int HEIGHT = 240;
    private float time;
    private float angle = 0;



    public Duck(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
        this.texture = new Texture("rival2.png");
        bounds = new Rectangle(position.x,position.y, WIDTH,HEIGHT);
    }

    public void render(SpriteBatch batch) {
        int frame = (int) (time / 0.1f);
        frame = frame % 2;
        batch.draw(texture, position.x, position.y, WIDTH/2, HEIGHT/2,
                WIDTH, HEIGHT, 1, 1, angle, frame * WIDTH, 0, WIDTH, HEIGHT, false, false);

    }

    public void dispose() {
        texture.dispose();
    }

    public void update (float delta) {
        time += delta;
        position.add(velocity);
        velocity.x += 0.05f * delta;
        bounds.setPosition(position.x, position.y);
        if (isKilled) {
            angle+=10;
            velocity.y--;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }
}

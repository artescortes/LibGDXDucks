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

    private final int WIDTH = 216;
    private final int HEIGHT = 240;
    private float time;


    public Duck(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
        this.texture = new Texture("rival2.png");
        bounds = new Rectangle(position.x,position.y, WIDTH,HEIGHT);
    }

    public void render(SpriteBatch batch) {
        int frame = (int) (time / 0.1f);
        frame = frame % 2;
        batch.draw(texture, position.x, position.y, frame * WIDTH, 0, WIDTH, HEIGHT);

    }

    public void dispose() {
        texture.dispose();
    }

    public void update (float delta) {
        time += delta;
        position.add(velocity);
        velocity.x += 0.05f * delta;
        bounds.setPosition(position.x, position.y);

    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }
}

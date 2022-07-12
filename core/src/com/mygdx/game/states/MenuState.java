package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends AbstractState {
    private Texture background1, background2;
    private Texture startBtn;
    float xMax, xCoordBg1, xCoordBg2;
    final int BACKGROUND_MOVE_SPEED = 100;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background1 = new Texture("oblaka.jpg");
        background2 = new Texture("oblaka.jpg");
        startBtn = new Texture("start.png");
        xMax = background1.getWidth();
        xCoordBg1 = 0;
        xCoordBg2 = xMax;
    }

    private void handelInput() {
        if (Gdx.input.isTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float delta) {
        xCoordBg1 -= BACKGROUND_MOVE_SPEED * delta;
        xCoordBg2 = xCoordBg1 - xMax;
        if (xCoordBg1 <= 0) {
            xCoordBg1 = xMax;
            xCoordBg2 = 0;
        }
        handelInput();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(background1, xCoordBg1,-50);
        batch.draw(background2, xCoordBg2, -50);
        batch.draw(startBtn, Gdx.graphics.getWidth()/2 - startBtn.getWidth()/2,
                Gdx.graphics.getHeight()/2 - startBtn.getHeight()/2);
        batch.end();

    }

    @Override
    public void dispose() {
        background1.dispose();
        background2.dispose();
        startBtn.dispose();
    }
}

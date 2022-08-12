package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.InputHandler;
import com.mygdx.game.Score;
import com.mygdx.game.entities.Duck;

import javax.swing.plaf.basic.BasicListUI;

public class PlayState extends AbstractState {
    private BitmapFont font;
    private Texture fon;
    private Texture grass;
    private Texture ground;
    private int score;
    private final int DUCKS_COUNT = 5;
    private Duck[] ducks;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        fon = new Texture("fon.jpg");
        grass = new Texture("grass.png");
        ground = new Texture("ground.jpg");
        font = new BitmapFont(Gdx.files.internal("myfont.fnt"),Gdx.files.internal("myfont.png"), false);
        score = 0;
        ducks[0] = new Duck(new Vector2(0,0), new Vector2(1.5f,1.0f));
        for (int i = 1; i < DUCKS_COUNT; i++) {
            ducks[i] = new Duck(new Vector2(ducks[i - 1].getPosition().x - MathUtils.random(200,900),
                    ducks[i - 1].getPosition().y - MathUtils.random(200,300)),
                    new Vector2(ducks[i - 1].getVelocity().x,ducks[i - 1].getVelocity().y));
        }
    }

    @Override
    public void update(float delta) {
        for (int i = 0; i < DUCKS_COUNT; i++) {
            ducks[i].update(delta);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(fon, 0,0);

        for (int i = 0; i < DUCKS_COUNT; i++)  {
            ducks[i].render(batch);
            if (InputHandler.isClicked()) {
                if (ducks[i].getBounds().contains(InputHandler.getMousePosition().x, InputHandler.getMousePosition().y)) {
                    ducks[i].setKilled(true);
                score++;
                Score.setScores(score);
                }
            }
        }
        font.draw(batch, "Scores: " + score, 10, Gdx.graphics.getHeight() - 20);
        int x = 0;
        do {
            batch.draw(ground, x, 0);
            batch.draw(grass, -30 + x, -90);
            x += ground.getWidth();
        } while (x <= Gdx.graphics.getWidth());
        Texture sight;
        //batch.draw(sight, InputHandler.getMousePosition().x - sight.get);
        batch.end();
    }

    @Override
    public void dispose() {
        fon.dispose();
    }
}

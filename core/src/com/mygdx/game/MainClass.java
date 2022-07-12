package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;

public class MainClass extends ApplicationAdapter {
	private GameStateManager gsm;
	private SpriteBatch batch;
	private Texture img;
	
	@Override
	public void create () {
		gsm = new GameStateManager();
		batch = new SpriteBatch();
		img = new Texture("rival.png");
		
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

package com.mazaoking.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mazaoking.game.States.GameStateMananger;
import com.mazaoking.game.States.MenuState;

public class PandemiLTD extends ApplicationAdapter {

	private GameStateMananger gsm;
	private  SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateMananger();
		Gdx.gl.glClearColor(0, 0, 1, 1);
		gsm.push(new MenuState(gsm)); //pusheo el estado menu
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime()); //obtenemos el dt para actualizar el juego a partir de la libreria gdx
		gsm.render(batch);//renderizamos el batch
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

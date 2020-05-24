package com.mazaoking.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mazaoking.game.PandemiLTD;

public class PlayState extends State{

    private Texture pajaro, bg;

    public PlayState(GameStateMananger gsm) {
        super(gsm);
        pajaro = new Texture("bird.png");
        bg = new Texture("bg.png");
        camera.setToOrtho(false, PandemiLTD.Width / 2, PandemiLTD.Height / 2 );
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        //usaremos proyectionMatrix, para dibujar objetos que se ven dentro del viewport o cuadro de juego
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();

        spriteBatch.draw(bg, 0, 0, PandemiLTD.Width, PandemiLTD.Height);

        spriteBatch.draw(pajaro, 60, 60, (pajaro.getWidth() * 2) , (pajaro.getHeight() * 2));

        spriteBatch.end();


    }

    @Override
    public void dispose() {

    }
}

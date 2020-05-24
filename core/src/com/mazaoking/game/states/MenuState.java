package com.mazaoking.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mazaoking.game.PandemiLTD;

public class MenuState extends State {


    private Texture background;
    private Texture btn_play;

    /**
     * constructor
     *
     * @param gameStateMananger
     */
    public MenuState(GameStateMananger gameStateMananger) {
        super(gameStateMananger);
        background = new Texture("bg.png");
        btn_play = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        //just touch para ver cuando se toca la pantalla
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.begin();

        spriteBatch.draw(background, 0, 0, PandemiLTD.Width, PandemiLTD.Height);

        spriteBatch.draw(btn_play, (PandemiLTD.Width / 2) - (btn_play.getWidth()), (PandemiLTD.Height / 2), 205, 120);

        spriteBatch.end();

    }

    /**
     * dejamos de cargar el fondo y el boton de jugar
     */
    @Override
    public void dispose() {
        background.dispose();
        btn_play.dispose();
    }
}

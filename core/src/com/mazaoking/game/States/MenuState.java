package com.mazaoking.game.States;

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
        background = new Texture("fondomenu.png");
        btn_play = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.begin();

        spriteBatch.draw(background, 0, 3, PandemiLTD.Width, PandemiLTD.Height);

        spriteBatch.end();

    }
}

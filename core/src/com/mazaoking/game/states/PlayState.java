package com.mazaoking.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mazaoking.game.PandemiLTD;
import com.mazaoking.game.sprites.Bird;
import com.mazaoking.game.sprites.Palo;

public class PlayState extends State{

    private static final int TUBE_SPACING = 200;
    private static final int TUBE_COUNT = 9;

    private Texture bg;
    private Bird pajaro;
    private Texture piso;
    private Vector2 pisoPos1;
    private Vector2 pisopos2;

    private Array<Palo> tubos;

    public PlayState(GameStateMananger gsm) {
        super(gsm);
        pajaro = new Bird(30, 420);
        bg = new Texture("bg.png");
        piso = new Texture("ground.png");
        pisoPos1 = new Vector2(camera.position.x - (camera.viewportWidth * 2),0);
        pisopos2 = new Vector2(camera.position.x - (camera.viewportWidth * 2) + piso.getWidth(), 0);
        camera.setToOrtho(false, PandemiLTD.Width / 2, PandemiLTD.Height / 2 );
        tubos = new Array<Palo>();

        for (int i = 1; i <= TUBE_COUNT; i++){
            tubos.add(new Palo(i * (TUBE_SPACING + Palo.ANCHO_TUBO)));
        }
    }

    @Override
    protected void handleInput() {

        if (Gdx.input.justTouched()){

            pajaro.fly();

        }

    }

    @Override
    public void update(float dt) {

        handleInput();
        pajaro.update(dt);

        camera.position.x = pajaro.getPosicion().x + 80;

        for (int i = 0; i < tubos.size; i++){
            Palo palos = tubos.get(i);
            if (camera.position.x - (camera.viewportWidth / 2) > palos.getPostt().x + palos.getTopT().getWidth()){
                palos.reposition(palos.getPostt().x + (Palo.ANCHO_TUBO + TUBE_SPACING) * TUBE_COUNT);
            }
            if (palos.colisiono(pajaro.getBound())){
                gsm.set(new PlayState(gsm));
            }
        }

        camera.update();

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        //usaremos proyectionMatrix, para dibujar objetos que se ven dentro del viewport o cuadro de juego
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();

        spriteBatch.draw(bg, camera.position.x - (camera.viewportWidth / 2),  camera.position.y - (camera.viewportHeight / 2), PandemiLTD.Width, PandemiLTD.Height);

        spriteBatch.draw(pajaro.getPajaro(), pajaro.getPosicion().x, pajaro.getPosicion().y, 68, 48);

        for (Palo tube: tubos){
            spriteBatch.draw(tube.getTopT(), tube.getPostt().x, tube.getPostt().y);

            spriteBatch.draw(tube.getBotT(), tube.getPosbt().x, tube.getPosbt().y);
        }

        spriteBatch.draw(piso, pisoPos1.x, pisoPos1.y);
        spriteBatch.draw(piso, pisopos2.x, pisopos2.y);

        spriteBatch.end();


    }

    @Override
    public void dispose() {

        bg.dispose();
        pajaro.dispose();
        for(Palo tube: tubos){
            tube.dispose();
        }
        System.out.println("PLAY STATE DISPOSE");

    }
}

package com.mazaoking.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {

    protected OrthographicCamera camera; //es la camara para saber como va a ver el usuario el juego

    protected Vector3 mouse; //para saber donde esta el click

    protected GameStateMananger gsm; //el manejador de estados

    /**
     * constructor
     * @param gameStateMananger
     */
    protected State(GameStateMananger gameStateMananger){
        this.gsm = gameStateMananger;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected abstract void handleInput(); //detectar las entradas que demos en el estado actual del juego

    /**
     * Metodo del loop game
     * Actualiza el juego para saber el estado actual y que estado sigue-actualiza el juego en tiempo real
     * @param dt
     */
    public abstract void update(float dt);

    /**
     *Metodo para el loop game (loop game: ciclo del juego, para saber que estados se estan ejecutando cual toca y cuando actulizarlos)
     * Carga los elementos para el juego, visuales
     * @param spriteBatch
     */
    public abstract void render(SpriteBatch spriteBatch);

}

package com.mazaoking.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Clase que va a manejar todos los estados del juego
 */
public class GameStateMananger {

    //pila que guardara los estados del juego
    private Stack<com.mazaoking.game.states.State> states;

    /**
     * constructor, inicia la pila
     */
    public GameStateMananger(){
        states = new Stack<com.mazaoking.game.states.State>();
    }

    /**
     * pushear un elemento en la pila, oseace agrega
     */
    public void push(com.mazaoking.game.states.State estado){
        states.push(estado);
    }

    /**
     * popea un elemento de la pila, obviamente el ultimo en ingresar
     */
    public void pop(){
        states.pop();
    }

    /**
     * setea un estado en la pila, pero no como push, aca remplazo el ultimo estado por el que mandamos ahora
     * @param estado
     */
    public void set(State estado){
        states.pop();
        states.push(estado);
    }

    /**
     * COn este metodo se obtiene el estado en el que nos encontramos y lo actualiza al delta time actual
     * @param deltatime es el tiempo de ejecucion real del juego, mas o menos frecuencia de actualizacion
     */
    public void update(float deltatime){
        states.peek().update(deltatime);
    }

    /**
     * renderiza la aplicacion con el spritebatch ingresado
     * @param sb sprite batch es un contenedor que ayuda a almacenar los sprites, osease imagenes para los dibujitos
     * se usa spritebatch para optimizar el game
     * Obtenemos el estado actual y le renderizamos el sb que recibe
     */
    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}

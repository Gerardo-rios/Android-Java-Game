package com.mazaoking.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {

    private static final int MOVEMENT = 180;

    private static final int gravedad = -13;

    private Vector3 posicion;
    private Vector3 velocidad;

    private Texture pajaro;

    private Rectangle limites;


    public Bird(int x, int y){

        //empezamos en la posicion en donde se crea el pajaro
        posicion = new Vector3(x, y, 0);
        //empezamos con velocidad ceo
        velocidad = new Vector3(0, 0, 0);
        //la textura del pajaro
        pajaro = new Texture("bird.png");
        //limites del rectangulo
        limites = new Rectangle(x, y, pajaro.getWidth(), pajaro.getHeight());
    }

    public void update(float deltatime){

        if (posicion.y > 0){
            velocidad.add(0, gravedad, 0);
        }

        velocidad.scl(deltatime);
        posicion.add(MOVEMENT * deltatime, velocidad.y, 0);

        if (posicion.y < 0){
            posicion.y = 0;
        }
        velocidad.scl(1/deltatime); //para que se asigne el valor 1 vez cada segundo del delta time

        limites.setPosition(posicion.x, posicion.y); //reposicionando el rectangulo del pajaro

    }

    public Rectangle getBound(){
        return limites;
    }

    public void fly(){

        velocidad.y = 280;

    }

    public void dispose(){
        pajaro.dispose();
    }

    public Vector3 getPosicion() {
        return posicion;
    }

    public Texture getPajaro() {
        return pajaro;
    }
}

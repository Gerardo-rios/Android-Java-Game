package com.mazaoking.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class Palo {

    public static final int ANCHO_TUBO = 156;

    private static final int FLUCTUATION = 390; //la fluctuacion para la altura del tubo, aleatoria
    private static final int TUBE_GAP = 200; //para la distacia entre tubos en el eje horizntal
    private static final int LOWEST_OPENING = 240; //para determinar que el tubo de arriba no baje mucho

    private Texture topT;
    private Texture botT;

    private Vector2 postt;
    private Vector2 posbt;

    private Random random;

    private Rectangle limite_superior; //rectangulo para el limite del tubo de arriba
    private Rectangle limite_inferior; //rectangulo para el limite del tubo de abajo

    public Palo(float x) {
        topT = new Texture("tubotop.png");
        botT = new Texture("tubobottom.png");
        random = new Random();

        postt = new Vector2(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posbt = new Vector2(x, postt.y - TUBE_GAP - botT.getHeight());

        limite_superior = new Rectangle(postt.x, postt.y, topT.getWidth(), topT.getHeight());
        limite_inferior = new Rectangle(posbt.x, posbt.y, botT.getWidth(), botT.getHeight());

    }

    public void reposition(float x){
        postt.set(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posbt.set(x, postt.y - TUBE_GAP - botT.getHeight());

        limite_superior.setPosition(postt.x, postt.y); //reposicionamos los rectangulos y le pnemos el valor del tubo en
        limite_inferior.setPosition(posbt.x, posbt.y); //x y en y para que se mueva al igual que los tubos

    }

    public boolean colisiono(Rectangle jugador){

        //con los rectangulos podremos comprobar si se choco el pajaro con el tubo

        return jugador.overlaps(limite_superior) || jugador.overlaps(limite_inferior);

    }

    public void dispose(){
        botT.dispose();
        topT.dispose();
    }

    public Texture getTopT() {
        return topT;
    }

    public void setTopT(Texture topT) {
        this.topT = topT;
    }

    public Texture getBotT() {
        return botT;
    }

    public void setBotT(Texture botT) {
        this.botT = botT;
    }

    public Vector2 getPostt() {
        return postt;
    }

    public void setPostt(Vector2 postt) {
        this.postt = postt;
    }

    public Vector2 getPosbt() {
        return posbt;
    }

    public void setPosbt(Vector2 posbt) {
        this.posbt = posbt;
    }
}

package com.mazaoking.game.sprites;

import com.badlogic.gdx.graphics.Texture;
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

    public Palo(float x) {
        topT = new Texture("tubotop.png");
        botT = new Texture("tubobottom.png");
        random = new Random();

        postt = new Vector2(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posbt = new Vector2(x, postt.y - TUBE_GAP - botT.getHeight());

    }

    public void reposition(float x){
        postt.set(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posbt.set(x, postt.y - TUBE_GAP - botT.getHeight());
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

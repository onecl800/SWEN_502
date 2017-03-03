package com.example.claire.balloonpopping;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Balloon {

    private static Bitmap balloon;
    private int balloonX;
    private int balloonY;
    private int bSpeedX = 0;
    private int bSpeedY = 0;

    //getters and setters
    public int getBalloonX() {
        return balloonX;
    }
    public void setBalloonX(int balloonX) {
        this.balloonX = balloonX;
    }
    public int getBalloonY() {
        return balloonY;
    }
    public void setBalloonY(int balloonY) {
        this.balloonY = balloonY;
    }
    public int getbSpeedX() {
        return bSpeedX;
    }
    public void setbSpeedX(int bSpeedX) {
        this.bSpeedX = bSpeedX;
    }
    public int getbSpeedY() {
        return bSpeedY;
    }
    public void setbSpeedY(int bSpeedY) {
        this.bSpeedY = bSpeedY;
    }


    //constructors for balloon
    public Balloon(int x, int y, int speedX, int speedY, Bitmap balloon, Context context) {
        balloonX = x;
        balloonY = y;
        bSpeedX = speedX;
        bSpeedY = speedY;
        balloon = BitmapFactory.decodeResource(context.getResources(), R.drawable.blueballoon);
    }

}


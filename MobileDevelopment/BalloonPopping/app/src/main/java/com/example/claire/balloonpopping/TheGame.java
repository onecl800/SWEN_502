package com.example.claire.balloonpopping;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import java.util.ArrayList;


public class TheGame extends GameThread {

    //array list to hold all the balloons
    ArrayList<Balloon> balloons = new ArrayList();

    //Will store the image of a balloon
    private Bitmap balloon;

    //The X and Y position of the ball on the screen (middle of ball)
    private float balloonX = 0;
    private float balloonY = 0;

    //The speed (pixel/second) of the ball in direction X and Y
    private float balloonSpeedX = 0;
    private float balloonSpeedY = 0;

    //This is run before anything else, so we can prepare things here
    public TheGame(GameView gameView) {
        //House keeping
        super(gameView);

        //Prepare the image by creating the balloons so we can draw it on the screen (using a canvas)
        createBalloons(gameView.getContext());
    }

    //This is run before a new game (also after an old game)
    @Override
    public void setupBeginning() {
        //Initialise speeds
        balloonSpeedX = 0;
        balloonSpeedY = 0;

        //Place the ball in the middle of the screen.
        //mBall.Width() and mBall.getHeigh() gives us the height and width of the image of the ball
        balloonX = mCanvasWidth / 2;
        balloonY = mCanvasHeight / 2;
    }


    //draw an individual balloon
    public void drawBalloon(Canvas canvas, Bitmap balloon, int balloonX, int balloonY) {
        canvas.drawBitmap(balloon, balloonX, balloonY, null);
    }


    @Override
    protected void doDraw(Canvas canvas) {
        //If there isn't a canvas to draw on do nothing
        //It is ok not understanding what is happening here
        if(canvas == null) return;

        super.doDraw(canvas);

        //draw the image of the balloon using the X and Y of the balloon, calling drawBalloon method
        for (int i = 0; i < balloons.size(); i ++) {
            drawBalloon(canvas, balloon, balloons.get(i).getBalloonX(), balloons.get(i).getBalloonY());
        }
    }


    //This is run whenever the phone is touched by the user
    @Override
    protected void actionOnTouch(float x, float y) {

        //locate the balloon using x and y of the touch, and remove balloon from the array list.
        //balloon should disappear when update method runs
        //score is updated
        for (int i = 0; i < balloons.size(); i++) {
            if (balloons.get(i).getBalloonX() == x && balloons.get(i).getBalloonY() == y) {
                balloons.remove(i);
                updateScore(5);
                break;
            }
        }
    }



    //This is run whenever the phone moves around its axises
    @Override
    protected void actionWhenPhoneMoved(float xDirection, float yDirection, float zDirection) {
		/*
		Increase/decrease the speed of the ball.
		If the ball moves too fast try and decrease 70f
		If the ball moves too slow try and increase 70f
		 */

        balloonSpeedX = balloonSpeedX + 70f * xDirection;
        balloonSpeedY = balloonSpeedY - 70f * yDirection;
    }


    //This is run just before the game "scenario" is printed on the screen
    @Override
    protected void updateGame(float secondsElapsed) {
        //Move the ball's X and Y using the speed (pixel/sec)
        balloonX = balloonX + secondsElapsed * balloonSpeedX;
        balloonY = balloonY + secondsElapsed * balloonSpeedY;
    }



    //create balloons of different colours and add to arraylist
    public void createBalloons(Context context) {

        for (int i = 0; i < balloons.size(); i++) {
            int randomColour = (int)(Math.random()*4);

            int balloonX = (int)(Math.random()* mCanvasWidth);
            int balloonY = (int)(Math.random()* mCanvasHeight);
            int bSpeedX = 0;
            int bSpeedY = 0;

            //create balloon with different colours depending on outcome of randomColour
            if(randomColour < 0.25) {
                Balloon b = new Balloon(balloonX, balloonY, bSpeedX, bSpeedY, BitmapFactory.decodeResource(context.getResources(), R.drawable.blueballoon), context);
                balloons.add(b);
            } else if(randomColour >= 0.25 && randomColour < 0.5) {
                Balloon b = new Balloon(balloonX, balloonY, bSpeedX, bSpeedY, BitmapFactory.decodeResource(context.getResources(), R.drawable.blueballoon), context);
                balloons.add(b);
            } else if (randomColour >= 0.5 && randomColour < 0.75) {
                Balloon b = new Balloon(balloonX, balloonY, bSpeedX, bSpeedY, BitmapFactory.decodeResource(context.getResources(), R.drawable.blueballoon), context);
                balloons.add(b);
            } else {
                Balloon b = new Balloon(balloonX, balloonY, bSpeedX, bSpeedY, BitmapFactory.decodeResource(context.getResources(), R.drawable.blueballoon), context);
                balloons.add(b);
            }
        }
    }



    //move balloons around the screen at random. Need to stop balloons going offscreen
    public void moveBalloons() {
        int balloonX = 0;
        int balloonY = 0;

        for (int i = 0; i < balloons.size(); i++) {
            int randX = (int)(Math.random()*2);
            int randY = (int)(Math.random()*2);

            balloonX = balloonX + randX;
            balloonY = balloonY + randY;

            //call updateGame method here?
        }
    }



    //end game
    public void endGame() {

        if(balloons.size() == 0) {
            //TextView startText = (TextView)findViewById(startText);
            //startText.setText("Game over");

            //check if score is a high score and add to high score list
        }
    }

}

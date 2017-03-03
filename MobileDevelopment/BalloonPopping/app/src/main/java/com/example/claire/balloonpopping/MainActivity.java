package com.example.claire.balloonpopping;

import android.content.Context;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private int [] highScores = {0,0,0,0,0,0,0,0,0,0};

    private GameThread mGameThread;
    private GameView mGameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_screen);

        mGameView = (GameView)findViewById(R.id.gamearea);
        mGameView.setStatusView((TextView)findViewById(R.id.text));
        mGameView.setScoreView((TextView)findViewById(R.id.score));

        this.startGame(mGameView, null, savedInstanceState);
    }


    public void startScreen() {
        setContentView(R.layout.activity_main);

        Button newGameBtn = (Button)findViewById(R.id.newGameBtn);
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //should be startGame method?
                //  newGame();
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();

        if(mGameThread.getMode() == GameThread.STATE_RUNNING) {
            mGameThread.setState(GameThread.STATE_PAUSE);
        }
    }


    @Override
    public void onDestroy() {

        super.onDestroy();

        mGameView.cleanup();
        mGameView.removeSensor((SensorManager)getSystemService(Context.SENSOR_SERVICE));
        mGameThread = null;
        mGameView = null;
    }


    private void startGame(GameView gView, GameThread gThread, Bundle savedInstanceState) {

        //Set up a new game, we don't care about previous states
        mGameThread = new TheGame(mGameView);
        mGameView.setThread(mGameThread);
        mGameThread.setState(GameThread.STATE_READY);
        mGameView.startSensor((SensorManager)getSystemService(Context.SENSOR_SERVICE));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.howToPlay:
                showHowTo();
                return true;
            case R.id.menuPlay:
                //newGame();
                return  true;
            case R.id.highScore:
                showHighScores();
                return true;
            case R.id.settings:
                showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


//    public void newGame() {
//        setContentView(R.layout.game_screen);
//
//        //TextView startText = (TextView)findViewById(R.id.startText);
//        //startText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startGame();
//            }
//        });
//
//    }


    public void startGame() {
        TextView startText = (TextView) findViewById(R.id.text);
        startText.setText("");

    }


    public void showHowTo() {
        setContentView(R.layout.how_to_play);

        Button howToToMain = (Button)findViewById(R.id.howToToMain);
        howToToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScreen();
            }
        });
    }


    public void showHighScores() {
        setContentView(R.layout.high_score);

        Button scoresToMain = (Button)findViewById(R.id.scoresToMain);
        scoresToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScreen();
            }
        });
    }


    public void showSettings() {
        setContentView(R.layout.settings);

        Button settingsToMain = (Button)findViewById(R.id.settingsToMain);
        settingsToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScreen();
            }
        });
    }

}

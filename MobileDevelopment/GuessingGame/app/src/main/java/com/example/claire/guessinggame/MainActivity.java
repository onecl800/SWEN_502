package com.example.claire.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import static com.example.claire.guessinggame.R.id.userMin;


public class MainActivity extends AppCompatActivity {

    public static final String SETTINGS = "MySettingsFile";

    private int minNumber = 1;
    private int maxNumber = 100;
    private int numGuesses = 10;


    //start app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showInitialScreen();
    }


    //create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //menu actions
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.playNumber:
                showNumGame();
                return true;
            case R.id.playColour:
                showColourGame();
                return true;
            case R.id.settings:
                showSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //save settings when app is closed
    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(SETTINGS, 0);
        SharedPreferences.Editor editor = settings.edit();

        editor.putInt("SetMin", minNumber);
        editor.putInt("SetMax", maxNumber);
        editor.putInt("SetNumGuesses", numGuesses);

        editor.commit();
    }



    //show first screen of the app
    public void showInitialScreen() {
        setContentView(R.layout.activity_main);

        //open layout for number guessing game
        Button numBtn = (Button)findViewById(R.id.numBtn);
        numBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumGame();
            }
        });

        //open layout for colour guessing game
        Button colourBtn = (Button)findViewById(R.id.colourBtn);
        colourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColourGame();
            }
        });

    }


    //show number guessing game
    public void showNumGame() {
        setContentView(R.layout.number_layout);

        //play number guessing game
        final TextView numTxt = (TextView) findViewById(R.id.numText);
        final EditText numGuess = (EditText)findViewById(R.id.editText);
        final int numToGuess = (int)(Math.random() * 100);


        Button numGo = (Button)findViewById(R.id.goBtn);
        numGo.setOnClickListener(new View.OnClickListener() {
            int totalGuesses = 0;
            @Override
            public void onClick(View v) {

                int userGuess = Integer.parseInt(numGuess.getText().toString());
                totalGuesses++;

                if (userGuess >= minNumber && userGuess <= maxNumber && totalGuesses < numGuesses ) {

                    if (userGuess < numToGuess) {
                        numTxt.setText("Your guess is too low, guess again");
                    } else if (userGuess > numToGuess) {
                        numTxt.setText("Your guess is too high, guess again");
                    } else if (userGuess == numToGuess) {
                        showNumWinScreen();
                    }

                } else if ((userGuess < minNumber || userGuess > maxNumber) && totalGuesses < numGuesses) {
                    numTxt.setText("Your guess is outside of the set range, guess again");
                } else if (totalGuesses > numGuesses){
                    numTxt.setText("You've run out of guesses, you lose the game :(");
                }
            }
        });


        //start new game
        Button newGame = (Button)findViewById(R.id.newGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumGame();
            }
        });


        //go back to main screen
        Button numBtnBack = (Button)findViewById(R.id.numBtnBack);
        numBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInitialScreen();
            }
        });
    }


    //show layout after number game played
    public void showNumWinScreen() {
        setContentView(R.layout.guess_win);

        //replay number guessing game
        Button replay = (Button)findViewById(R.id.replay);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumGame();
            }
        });

        //go back to initial screen
        Button main = (Button)findViewById(R.id.returnToMain);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInitialScreen();
            }
        });
    }


    //show colour guessing game
    public void showColourGame() {
        setContentView(R.layout.colour_layout);

        //set min and max values for RGB numbers picker
        NumberPicker redPicker = (NumberPicker)findViewById(R.id.redPicker);
        redPicker.setMinValue(0);
        redPicker.setMaxValue(255);
        NumberPicker greenPicker = (NumberPicker)findViewById(R.id.greenPicker);
        greenPicker.setMinValue(0);
        greenPicker.setMaxValue(255);
        NumberPicker bluePicker = (NumberPicker)findViewById(R.id.bluePicker);
        bluePicker.setMinValue(0);
        bluePicker.setMaxValue(255);


        Button colourGo = (Button)findViewById(R.id.colourGo);
        colourGo.setOnClickListener(new View.OnClickListener() {
            //set random color
            NumberPicker redPicker = (NumberPicker)findViewById(R.id.redPicker);
            NumberPicker greenPicker = (NumberPicker)findViewById(R.id.greenPicker);
            NumberPicker bluePicker = (NumberPicker)findViewById(R.id.bluePicker);
            @Override
            public void onClick(View v) {
                int yourColor = (Color.rgb(redPicker.getValue(), greenPicker.getValue(), bluePicker.getValue()));
                int randColor = (Color.rgb((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
                showColorWinScreen(yourColor, randColor);
            }
        });

        //go back to main screen
        Button colourBtnBack = (Button)findViewById(R.id.colourBtnBack);
        colourBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInitialScreen();
            }
        });
    }


    //show layout after colour guess made
    public void showColorWinScreen(int yourColor, int randColor) {
        setContentView(R.layout.colour_win);

        //show two squares with colors
        TextView showRand = (TextView)findViewById(R.id.showRand);
        showRand.setBackgroundColor(randColor);
        TextView showYourColor = (TextView)findViewById(R.id.showYourColor);
        showYourColor.setBackgroundColor(yourColor);


        //set text depending on outcome of the guess
        TextView colorOutcome = (TextView)findViewById(R.id.colorOutcome);
        if (yourColor == randColor) {
            colorOutcome.setText("Congratulations, you guessed the correct colour!");
        } else {
            colorOutcome.setText("Your guess is wrong. Click to play again.");
        }

        //replay colour guessing game
        Button replayColour = (Button)findViewById(R.id.replayColour);
        replayColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showColourGame();
            }
        });

        //go back to initial screen
        Button colourMain = (Button)findViewById(R.id.colourMain);
        colourMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInitialScreen();
            }
        });
    }


    //show settings layout
    public  void showSettings() {
        setContentView(R.layout.settings);

        //TODO change values of min/max to actual values  of fields
        final EditText getMin = (EditText)findViewById(R.id.userMin);
        final EditText getMax = (EditText)findViewById(R.id.userMax);
        final EditText getNumGuesses = (EditText)findViewById(R.id.userNumGuesses);
        getMin.setText(Integer.toString(minNumber));
        getMax.setText(Integer.toString(maxNumber));
        getNumGuesses.setText(Integer.toString(numGuesses));

        //load saved settings
        final SharedPreferences settings = getSharedPreferences(SETTINGS, 0);
        minNumber = settings.getInt("SetMin", 1);
        maxNumber = settings.getInt("SetMax", 100);
        numGuesses = settings.getInt("SetNumGuesses", 10);

        //save entered values and go back to initial screen
        Button setSettings = (Button)findViewById(R.id.setSettings);
        setSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO get values of min/max from view and store in fields
                minNumber = Integer.parseInt(getMin.getText().toString());
                maxNumber = Integer.parseInt(getMax.getText().toString());
                numGuesses = Integer.parseInt(getNumGuesses.getText().toString());
                getMin.setText(Integer.toString(minNumber));
                getMax.setText(Integer.toString(maxNumber));
                getNumGuesses.setText(Integer.toString(numGuesses));
                showInitialScreen();
            }
        });
    }

}

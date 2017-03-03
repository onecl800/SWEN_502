package com.example.claire.myapplication;

import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class main extends AppCompatActivity {

    //file to save state to
    public static final String PREFS_NAME = "MyPrefsFile";

    // onCreate: call firstScreen method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showFirstScreen();
    }


    // onStop: load preferences when app is reopened
    @Override
    protected void onStop() {

        final EditText nameField = (EditText) findViewById(R.id.nameField);
        final TextView txt = (TextView) findViewById(R.id.txt);

        SharedPreferences savedInfo = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = savedInfo.edit();

        //save text in nameField
        editor.putString("nameSaved", nameField.getText().toString());
        //save text in textView
        //editor.putString("textSaved", txt.getText().toString());

        editor.commit();
    }


    public void showFirstScreen() {
        setContentView(R.layout.activity_main);

        //set up button to switch to second layout (test_layout)
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                showSecondScreen();
            }
        });

        //greet user by name
        Button btn = (Button) findViewById(R.id.btn);
        final EditText nameField = (EditText) findViewById(R.id.nameField);
        final TextView txt = (TextView) findViewById(R.id.txt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txt = (TextView) findViewById(R.id.txt);
                txt.setText("Hello " + nameField.getText().toString() + " :)");
            }
        });


        //save preferences for when app is closed
        SharedPreferences savedInfo = getSharedPreferences(PREFS_NAME, 0);
        //load saved name from nameField
        String savedName = savedInfo.getString("nameSaved", "");
        nameField.setText(savedName);
        //load save text element
        //String savedText = savedInfo.getString("textSaved", "");
        //txt.setText(savedText);
    }

    //method to show second screen
    public void showSecondScreen() {
        setContentView(R.layout.test_layout);

        //set up button to switch to first screen (activity_main)
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFirstScreen();
            }
        });
    }
}

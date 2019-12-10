package com.example.lasalliansimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PopUpPlayerName extends AppCompatActivity {

    Button start;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_player_name);

        start = findViewById(R.id.btn_startterm);
        editText = findViewById(R.id.editText);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * .8), (int)(height * .3));


    }

    public void startGameEngine(View view) {
        AppConstants.player.setName(editText.getText().toString());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}

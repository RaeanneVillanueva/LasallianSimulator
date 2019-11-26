package com.example.lasalliansimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
    }

    public void playAgain(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        finish();

    }
}

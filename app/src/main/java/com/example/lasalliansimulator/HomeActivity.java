package com.example.lasalliansimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
    }

    public void inputCharacterName(View view) {
        Intent intent = new Intent(this, PopUpPlayerName.class);
//        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up); for animation
        startActivity(intent);
        finish();
    }
}

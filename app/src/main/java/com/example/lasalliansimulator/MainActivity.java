package com.example.lasalliansimulator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

//hello im on git!
public class MainActivity extends AppCompatActivity {

    public AppAdapter appAdapter;
    private SwipeFlingAdapterView flingContainer;
    private ProgressBar health_bar, social_bar, grades_bar, money_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppConstants.init();

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.swipeFrame);

        health_bar = findViewById(R.id.healthBar);
        social_bar = findViewById(R.id.socialBar);
        grades_bar = findViewById(R.id.gradesBar);
        money_bar = findViewById(R.id.moneyBar);
         appAdapter = new AppAdapter(AppConstants.array, MainActivity.this);

        flingContainer.setAdapter(appAdapter);

        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {

                AppConstants.player.setChanges(AppConstants.array.get(0).getConsequenceRight());

                updateProgressBar();

                AppConstants.array.remove(0);
                appAdapter.notifyDataSetChanged();

                if(!AppConstants.player.isSurviving()){
                    Intent intent = new Intent(MainActivity.this, GameOver.class);
                    startActivity(intent);
                    finish();
                }
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject



            }

            @Override
            public void onRightCardExit(Object dataObject) {

                AppConstants.player.setChanges(AppConstants.array.get(0).getConsequenceLeft());

                updateProgressBar();


                AppConstants.array.remove(0);
                appAdapter.notifyDataSetChanged();

                if(!AppConstants.player.isSurviving()){
                    Intent intent = new Intent(MainActivity.this, GameOver.class);
                    startActivity(intent);
                    finish();
                }
            }

            private void updateProgressBar(){
                health_bar.setProgress(AppConstants.player.getHealth());
                social_bar.setProgress(AppConstants.player.getSocial());
                grades_bar.setProgress(AppConstants.player.getGrades());
                money_bar.setProgress(AppConstants.player.getMoney());
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

                View view = flingContainer.getSelectedView();
                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {

                View view = flingContainer.getSelectedView();
                appAdapter.notifyDataSetChanged();
            }
        });

    }
}

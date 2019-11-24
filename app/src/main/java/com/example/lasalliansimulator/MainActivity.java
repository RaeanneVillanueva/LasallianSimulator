package com.example.lasalliansimulator;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

//hello im on git!
public class MainActivity extends AppCompatActivity {

    public AppAdapter appAdapter;
    private ArrayList<Data> array;
    private SwipeFlingAdapterView flingContainer;
    private ProgressBar health_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.swipeFrame);

        health_bar = findViewById(R.id.healthBar);

        array = new ArrayList<>();

        array.add(new Data(R.drawable.andrew, "Andrew", "Let's code! Want me to reserve a discussion room?", "Sure!", "No thanks.."));
        array.add(new Data(R.drawable.dad, "Dad", "Go drink and have fun! I won't tell mom..", "You're the best dad!", "I'm scared.."));
        array.add(new Data(R.drawable.mom, "Mom", "Go home now! If you don't go home, I kill you!", "OK!", "GOING NOW!"));
        array.add(new Data(R.drawable.bob, "Bob", "Hi there! I like playing LoL, wanna play with me?", "Sure?","Loser.."));
        array.add(new Data(R.drawable.bek, "Bek", "Lemme draw you!", "That would be great!", "Hell no!"));
        array.add(new Data(R.drawable.james, "James", "Meet me at the gym! Let's lift weights!", "Gainz!!", "I'm tired.."));
        array.add(new Data(R.drawable.girl, "Random Girl", "Hi im nothing", "Hi?", "Hi?"));

        appAdapter = new AppAdapter(array, MainActivity.this);
        flingContainer.setAdapter(appAdapter);

        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                array.remove(0);
                appAdapter.notifyDataSetChanged();
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
            }

            @Override
            public void onRightCardExit(Object dataObject) {

                array.remove(0);
                appAdapter.notifyDataSetChanged();
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

package com.example.lasalliansimulator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Quests extends Fragment {

    private View view;
    private TextView questLbl;


    public Quests() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_quests, container, false);
        questLbl = view.findViewById(R.id.quest_lbl);

        return view;
    }
}

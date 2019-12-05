package com.example.lasalliansimulator;

import java.util.ArrayList;

public class AppConstants {
    public static Player player;
    public static ArrayList<CardData> array;
    public static void init(){

        array = new ArrayList<>();


        array.add(new CardData(R.drawable.mom, "Mom", "DCAT is coming, you should study!", "Study", "Stock Knowledge", new Consequence(0, 10, 15, 0), new Consequence(0,-10,-20,0)));
        array.add(new CardData(R.drawable.prof3, "Upperclassmen", "Hey frosh! Would like to join us for dinner? Your blockmates are coming too!", "Sure!!", "I wanna go home..", new Consequence(0,30,0,0), new Consequence(0,-20,0,0)));
        array.add(new CardData(R.drawable.prof3, "Upperclassmen", "How about the after party? Can you join us?", "G!", "I really wanna go home..", new Consequence(-10,30,0,0), new Consequence(0,-20,0,0)));

//        array.add(new CardData(0, "Upperclassmen", "You went the party.", "Let's go!", "Okay..", new Consequence(0,0,0,0), new Consequence(0,0,0,0)));

        //narration: you were forced to join the party

        array.add(new CardData(R.drawable.prof2, "Upperclassmen", "You should try out this drink! You’ll surely love it!", "Lemme buy one!!", "No thanks..", new Consequence(-20,20,0,-10), new Consequence(10,-10,0,20)));
        array.add(new CardData(R.drawable.mom, "Mom", "Go home now!", "Book a Grab", "Ride LRT", new Consequence(10, -5, 0, -20), new Consequence(-5,20,0,0)));

        //narration: annual recruitment week!

        array.add(new CardData(R.drawable.prof3, "Upperclassmen", "Welcome to our annual recruitment week!", "Yay!", "Yay!", new Consequence(0,0,0,0), new Consequence(0,0,0,0)));
        array.add(new CardData(R.drawable.prof3, "Upperclassmen", "Join our organization and be a part of a committee! Your block mates are joining too!", "Sure!", "Not really interested..", new Consequence(0,15,5,-10), new Consequence(0,-15,-5,10)));
        array.add(new CardData(R.drawable.jyle, "Jyle", "They said it can help with our resume in the future. Come on, Join with me!", "Let’s join!", "Sorry, not really interested..", new Consequence(0,15,5,-10), new Consequence(0,-15,-5,10)));



        array.add(new CardData(R.drawable.andrew, "Andrew", "Let's code! Want me to reserve a discussion room?", "Sure!", "No thanks..", new Consequence(0, 10, 15, 0), new Consequence(0,-10,-20,0)));
        array.add(new CardData(R.drawable.dad, "Dad", "Go drink and have fun! I won't tell mom..", "You're the best dad!", "I'm scared..", new Consequence(20,20,0,-20), new Consequence(20,-10,0,10)));
        array.add(new CardData(R.drawable.mom, "Mom", "Go home now! If you don't go home, I kill you!", "OK!", "GOING NOW!", new Consequence(0,-10,0,10), new Consequence(0,-10,0,10)));
        array.add(new CardData(R.drawable.bob, "Bob", "Hi there! I like playing LoL, wanna play with me?", "Sure?","Loser..", new Consequence(-10,10,-5,0), new Consequence(10,-30,5,0)));
        array.add(new CardData(R.drawable.bek, "Bek", "Lemme draw you!", "That would be great!", "Hell no!", new Consequence(10,15,0,0), new Consequence(-20,-30,0,0)));
        array.add(new CardData(R.drawable.james, "James", "Meet me at the gym! Let's lift weights!", "Gainz!!", "I'm tired..", new Consequence(30,30,0,0), new Consequence(-40,15,0,0)));
        array.add(new CardData(R.drawable.girl, "Random Girl", "Hi im nothing", "Hi?", "Ew", new Consequence(0,0,0,0), new Consequence(-50,-50,-50,-50)));

        player = new Player();
    }
}

package com.example.LasallianSimulator;

import android.graphics.drawable.Drawable;

public class Data {

    private String scenario;
    private String characterName;
    private int imagePath;
    private String choiceLeft;
    private String choiceRight;
    private int health;

    public Data(int imagePath, String characterName, String scenario, String left, String right) {
        this.imagePath = imagePath;
        this.characterName = characterName;
        this.scenario = scenario;
        this.choiceLeft = left;
        this.choiceRight = right;
    }

    public String getCharacterName() {
        return characterName;
    }
    public int getImagePath() { return imagePath; }
    public String getScenario() { return scenario; }
    public String getChoiceLeft() { return choiceLeft; }
    public String getChoiceRight() { return choiceRight; }

}

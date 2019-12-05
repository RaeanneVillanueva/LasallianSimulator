package com.example.lasalliansimulator;

public class CardData {

    private String scenario;
    private String characterName;
    private int imagePath;
    private String choiceLeft;
    private String choiceRight;
//    private int health,social, grades, money;
    private Consequence left, right;

    public CardData(int imagePath, String characterName, String scenario, String  choiceLeft, String choiceRight, Consequence left, Consequence right) {
        this.imagePath = imagePath;
        this.characterName = characterName;
        this.scenario = scenario;
        this.choiceLeft = choiceLeft;
        this.choiceRight = choiceRight;
        this.left = left;
        this.right = right;
    }

    public String getCharacterName() {
        return characterName;
    }
    public int getImagePath() { return imagePath; }
    public String getScenario() { return scenario; }
    public String getChoiceLeft() { return choiceLeft; }
    public String getChoiceRight() { return choiceRight; }
    public Consequence getConsequenceLeft(){return left;}
    public Consequence getConsequenceRight(){return right;}
}

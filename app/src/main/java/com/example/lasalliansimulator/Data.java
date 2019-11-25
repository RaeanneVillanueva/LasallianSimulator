package com.example.lasalliansimulator;

public class Data {

    private String scenario;
    private String characterName;
    private int imagePath;
    private String choiceLeft;
    private String choiceRight;
    private int health,social, grades, money;


    public Data(int imagePath, String characterName, String scenario, String left, String right, int health, int social, int grades, int money) {
        this.imagePath = imagePath;
        this.characterName = characterName;
        this.scenario = scenario;
        this.choiceLeft = left;
        this.choiceRight = right;
        this.health = health;
        this.social = social;
        this.grades = grades;
        this.money = money;
    }

    public String getCharacterName() {
        return characterName;
    }
    public int getImagePath() { return imagePath; }
    public String getScenario() { return scenario; }
    public String getChoiceLeft() { return choiceLeft; }
    public String getChoiceRight() { return choiceRight; }
    public int getHealthPts() { return health; }
    public int getSocialPts() { return social; }
    public int getGradesPts() { return grades; }
    public int getMoneyPts() { return money; }

}

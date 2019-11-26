package com.example.lasalliansimulator;

public class Player {
    private int health;
    private int social;
    private int money;
    private int grades;

    public Player(){
        this.health = 50;
        this.social = 50;
        this.money = 50;
        this.grades = 50;
    }

    public void setChanges(Consequence consequence){
        this.health += consequence.getHealth();
        this.social += consequence.getSocial();
        this.money += consequence.getMoney();
        this.grades += consequence.getGrades();
    }

    public boolean isSurviving(){
        if(health>0&&social>0&&money>0&&grades>0) return true;
        return false;
    }

    public int getHealth() {
        return health;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public void setHealth(int health) {
        this.health = health;
    }



}

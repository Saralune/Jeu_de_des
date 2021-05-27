package com.company.jeude;

public class PlayerBean {
    private String name;
    private int score;
    private CupBean cup;

    public PlayerBean(String name){
        this.name = name;
        cup = new CupBean();
        score = 0;
    }

    //Constructeur > clic droit > generate > constructor > choisir l'attribut ou none, ici string, ok

    public void launch(){
        cup.launch();
    }

    public void add1Pt(){
        score++;
    }

    //Getter & Setter

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CupBean getCup() {
        return cup;
    }

    public void setCup(CupBean cup) {
        this.cup = cup;
    }
}

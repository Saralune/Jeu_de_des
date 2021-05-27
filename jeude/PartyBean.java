package com.company.jeude;

public class PartyBean {
    private PlayerBean j1;
    private PlayerBean j2;
    private PlayerBean joueurCourant;
    private int tour;

    public PartyBean(String nameJ1, String nameJ2){
        j1 = new PlayerBean(nameJ1);
        j2 = new PlayerBean(nameJ2);
        joueurCourant = j1;
        tour = 0;
    }

    public void add1tour(){
        tour++;
    }

    public void switchPlayer(){
        if(joueurCourant == j1){
            joueurCourant = j2;
        }
        else{
            joueurCourant = j1;
        }
    }

    //Getter & Setter

    public PlayerBean getJ1() {
        return j1;
    }

    public void setJ1(PlayerBean j1) {
        this.j1 = j1;
    }

    public PlayerBean getJ2() {
        return j2;
    }

    public void setJ2(PlayerBean j2) {
        this.j2 = j2;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public PlayerBean getJoueurCourant() {
        return joueurCourant;
    }

    public void setJoueurCourant(PlayerBean joueurCourant) {
        this.joueurCourant = joueurCourant;
    }
}

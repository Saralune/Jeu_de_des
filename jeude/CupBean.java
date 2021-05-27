package com.company.jeude;

public class CupBean {
    private DeBean d1;
    private DeBean d2;

    public CupBean(){
        d1 = new DeBean();
        d2 = new DeBean();
    }

    public void launch(){
        d1.lancer();
        d2.lancer();
    }

    public int getScoreDice(){
        return d1.getValeur() + d2.getValeur();
    }

    //Getter & Setter


    public DeBean getD1() {
        return d1;
    }

    public void setD1(DeBean d1) {
        this.d1 = d1;
    }

    public DeBean getD2() {
        return d2;
    }

    public void setD2(DeBean d2) {
        this.d2 = d2;
    }
}

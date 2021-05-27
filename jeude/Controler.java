package com.company.jeude;

import java.util.Scanner;

public class Controler {

    private PartyBean party;

    public void createPlayer(){
        //Demander les noms sur la console avec le scanner
        Scanner scanner = new Scanner(System.in);

        //créer la party
        party = new PartyBean("Jean", "Baptiste");
    }

    public void launchGame(){
        //lance tous les tours de jeu pour J1 et J2
        for (int i = 0; i < 10; i++) {
            party.getJ1().launch();
            if(party.getJ1().getCup().getScoreDice() >= 7){
                party.getJ1().add1Pt();
            }

            party.getJ2().launch();
            if(party.getJ2().getCup().getScoreDice() >= 7){
                party.getJ2().add1Pt();
            }

            party.add1tour();
        }
    }

    public void printResult(){
        if(party.getJ1().getScore() > party.getJ2().getScore()){
            System.out.println(party.getJ1().getName() + " a gagné avec un score de " + party.getJ1().getScore() + " en " + party.getTour() + " tours");
            System.out.println("Score de " + party.getJ2().getName() + " : " + party.getJ2().getScore());
        }
        else if(party.getJ1().getScore() < party.getJ2().getScore()){
            System.out.println(party.getJ2().getName() + " a gagné avec un score de " + party.getJ2().getScore() + " en " + party.getTour() + " tours");
            System.out.println("Score de " + party.getJ1().getName() + " : " + party.getJ1().getScore());
        }
        else{
            System.out.println("Match nul");
            System.out.println("Score de " + party.getJ1().getName() + " : " + party.getJ1().getScore());
            System.out.println("Score de " + party.getJ2().getName() + " : " + party.getJ2().getScore());
        }
    }

//Getter & Setter


    public PartyBean getParty() {
        return party;
    }

    public void setParty(PartyBean party) {
        this.party = party;
    }
}

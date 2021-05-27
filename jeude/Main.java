package com.company.jeude;

public class Main {

    public static void main (String[] args){
     //  CupBean essai = new CupBean();

     //  for (int i = 0; i < 20; i++) {
     //      essai.launch();
     //      System.out.println(essai.getScoreDice());
     //  }

     //  PlayerBean j1 = new PlayerBean("Jean");
     //  PlayerBean j2 = new PlayerBean("Marie");

     //  for (int i = 0; i < 20; i++) {
     //      j1.launch();
     //      j2.launch();

     //      j1.add1Pt();
     //      j2.add1Pt();

     //      System.out.println("score j1 : " + j1.getScore() + " & score j2 : " + j2.getScore());

        PartyBean partyBean = new PartyBean("Jean", "Baptiste");
     //  //j1 lance les dés
     //  partyBean.getJ1().launch();
     //  //lire son score
     //  int scoreDe = partyBean.getJ1().getCup().getScoreDice();
     //  System.out.println("Score dé de J1 : " + scoreDe);

     //  //Modifier son score
     //  partyBean.getJ1().add1Pt();
     //  //modifier le tour
     //  partyBean.add1tour();

     //  System.out.println(partyBean.getJ1().getName() + " a fait un score de " + partyBean.getJ1().getScore() + " en " + partyBean.getTour() + " tour.");

        Controler controler = new Controler();
        controler.createPlayer();
        //controler.launchGame();
        //ontroler.launchGame2();
        //controler.printResult();

        }
    }

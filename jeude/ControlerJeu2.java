package com.company.jeude;

public class ControlerJeu2 {
        private PartyBean party;


        public void createPlayer() {
//        Scanner scanner = new Scanner(System.in);
//        //Demander les noms sur la console avec le scanner
//        System.out.print("Donnez le nom de j1 : ");
//        String nomJ1 = scanner.nextLine();
//        System.out.print("Donnez le nom de j2 : ");
//        String nomJ2 = scanner.nextLine();
            //Et créer la party
            party = new PartyBean("Toto", "Bob");
        }

        public void launchGame() {
            int nb7affile = 0;
//Tant qu'on a pas fait 3 '7' de suite
            while (nb7affile < 3) {
                party.getJ1().launch();
                //on regarde combien il a fait
                if (party.getJ1().getCup().getScoreDice() == 7) {
                    //on lui ajoute 1 point
                    nb7affile++;
                } else {
                    nb7affile = 0;
                }
                party.getJ1().add1Pt();
            }

            nb7affile = 0;
            while (nb7affile < 3) {
                party.getJ2().launch();
                //on regarde combien il a fait
                if (party.getJ2().getCup().getScoreDice() == 7) {
                    //on lui ajoute 1 point
                    nb7affile++;
                } else {
                    nb7affile = 0;
                }
                party.getJ2().add1Pt();
            }
        }

        public void printResult() {

            if (party.getJ1().getScore() < party.getJ2().getScore()) {
                System.out.print(party.getJ1().getName() + " a gagné : ");
            } else if (party.getJ1().getScore() > party.getJ2().getScore()) {
                System.out.print(party.getJ2().getName() + " a gagné : ");
            } else {
                System.out.print("Egalité : ");
            }
            System.out.print(party.getJ1().getScore() + " - " + party.getJ2().getScore());

        }

    public void launchGame2(){
        int tourJ1 = 0;
        while(party.getJ1().getCup().getScoreDice() != 7){
            party.getJ1().launch();
            party.add1tour();
            if(party.getJ1().getCup().getScoreDice() == 7){
                party.getJ1().launch();
                party.add1tour();
                if(party.getJ1().getCup().getScoreDice() == 7){
                    party.getJ1().launch();
                    party.add1tour();
                    if(party.getJ1().getCup().getScoreDice() == 7){
                        party.add1tour();
                        tourJ1 = party.getTour();
                        System.out.println("nombre de tours de " + party.getJ1().getName() + " : " + tourJ1);
                        break;
                    }
                }
            }
        }

        int tourJ2 = 0;
        while(party.getJ2().getCup().getScoreDice() != 7){
            party.getJ2().launch();
            party.add1tour();
            if(party.getJ2().getCup().getScoreDice() == 7){
                party.getJ2().launch();
                party.add1tour();
                if(party.getJ2().getCup().getScoreDice() == 7){
                    party.getJ2().launch();
                    party.add1tour();
                    if(party.getJ2().getCup().getScoreDice() == 7){
                        party.add1tour();
                        tourJ2 = party.getTour();
                        System.out.println("nombre de tours de " + party.getJ2().getName() + " : " + tourJ2);
                        break;
                    }
                }
            }
        }

        if(tourJ1 < tourJ2){
            System.out.println(party.getJ2().getName() + " a gagné avec " + tourJ1 + " tours");
        }
        else if(tourJ2 < tourJ1){
            System.out.println(party.getJ2().getName() + " a gagné avec " + tourJ1 + " tours");
        }
        else{
            System.out.println("Match nul");
        }
    }

    }


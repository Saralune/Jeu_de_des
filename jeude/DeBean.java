package com.company.jeude;

import java.util.Random;

public class DeBean {
        private int valeur;
        private int nbFace;

        public DeBean() {
            this(6);
            //nbFace = 6;
        }

        public DeBean(int nbFace) {
            this.nbFace = nbFace;
        }



        public int getValeur() {
            return valeur;
        }

        public void setValeur(int valeur) {
            this.valeur = valeur;
        }
    public void lancer() {
        valeur = new Random().nextInt(nbFace) + 1;
    }
}

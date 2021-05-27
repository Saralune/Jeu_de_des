package com.company.jeude;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class IHM {
    //constante
    private static final int NB_TOUR = 9;
    private static final int SCORE_A_ATTEINDRE = 7;

    // Composants graphique
    JFrame frame;
    JLabel lblJoueur1;
    JCheckBox cbJ1, cbJ2;

    // Données
    private PartyBean partyBean;
    private JTextField textFieldScoreJ1;
    private JTextField textFieldDe1;
    private JTextField textFieldDe2;
    private JTextField textFieldScoreJ2;
    private JButton btnLancerJ1;
    private JLabel labelTourValue;
    private JButton btnLancerJ2;
    private JButton btnRestart;
    private JLabel lblJoueur2;
    private JLabel lblInfo;


    /**
     * Create the application.
     */
    public IHM() {
        partyBean = new PartyBean("Toto", "Tata");
        initialize();
        partyBean.setTour(1);

        //Etat de déaprt
        btnLancerJ2.setVisible(false);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    IHM window = new IHM();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*******************
     * Methode private
     */

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 682, 403);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblJoueur1 = new JLabel(partyBean.getJ1().getName()); //nom joueur 1
        lblJoueur1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblJoueur1.setBounds(39, 45, 82, 18);
        frame.getContentPane().add(lblJoueur1);

        lblJoueur2 = new JLabel(partyBean.getJ2().getName()); //nom joueur 2
        lblJoueur2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblJoueur2.setBounds(500, 45, 108, 18);
        frame.getContentPane().add(lblJoueur2);

        final JLabel lblDe1 = new JLabel("Dé 1");
        lblDe1.setBounds(235, 123, 46, 14);
        frame.getContentPane().add(lblDe1);

        final JLabel lblDe2 = new JLabel("Dé 2");
        lblDe2.setBounds(315, 123, 46, 14);
        frame.getContentPane().add(lblDe2);

        final JLabel lblScoreJ1 = new JLabel("Score : ");
        lblScoreJ1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblScoreJ1.setBounds(33, 93, 57, 23);
        frame.getContentPane().add(lblScoreJ1);

        textFieldScoreJ1 = new JTextField();
        textFieldScoreJ1.setEditable(false);
        textFieldScoreJ1.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldScoreJ1.setBackground(Color.WHITE);
        textFieldScoreJ1.setText("0");
        textFieldScoreJ1.setBounds(86, 96, 35, 20);
        frame.getContentPane().add(textFieldScoreJ1);
        textFieldScoreJ1.setColumns(10);

        textFieldDe1 = new JTextField();
        textFieldDe1.setEditable(false);
        textFieldDe1.setText("1");
        textFieldDe1.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldDe1.setColumns(10);
        textFieldDe1.setBackground(Color.WHITE);
        textFieldDe1.setBounds(211, 148, 70, 64);
        frame.getContentPane().add(textFieldDe1);

        textFieldDe2 = new JTextField();
        textFieldDe2.setEditable(false);
        textFieldDe2.setText("1");
        textFieldDe2.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldDe2.setColumns(10);
        textFieldDe2.setBackground(Color.WHITE);
        textFieldDe2.setBounds(304, 148, 70, 64);
        frame.getContentPane().add(textFieldDe2);

        final JLabel labelScoreJ2 = new JLabel("Score : ");
        labelScoreJ2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelScoreJ2.setBounds(479, 93, 57, 23);
        frame.getContentPane().add(labelScoreJ2);

        textFieldScoreJ2 = new JTextField();
        textFieldScoreJ2.setEditable(false);
        textFieldScoreJ2.setText("0");
        textFieldScoreJ2.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldScoreJ2.setColumns(10);
        textFieldScoreJ2.setBackground(Color.WHITE);
        textFieldScoreJ2.setBounds(532, 96, 35, 20);
        frame.getContentPane().add(textFieldScoreJ2);

        final JLabel lblTour = new JLabel("Tour : ");
        lblTour.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblTour.setBounds(247, 36, 67, 27);
        frame.getContentPane().add(lblTour);

        labelTourValue = new JLabel(partyBean.getTour() + "");
        labelTourValue.setFont(new Font("Tahoma", Font.PLAIN, 22));
        labelTourValue.setBounds(324, 36, 37, 27);
        frame.getContentPane().add(labelTourValue);

        btnLancerJ1 = new JButton("Lancer");

        btnLancerJ1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                //Modification des données
                partyBean.getJ1().launch();
                if(partyBean.getJ1().getCup().getScoreDice() >= SCORE_A_ATTEINDRE){
                    partyBean.getJ1().add1Pt();
                }

                //si case tricheur cochée
                if(cbJ1.isSelected()){
                    partyBean.getJ1().getCup().getD1().setValeur(6);
                }

                //Affichage des données
                lblJoueur1.setText(partyBean.getJ1().getName()); // ou à

                textFieldDe1.setText(partyBean.getJ1().getCup().getD1().getValeur() + ""); //modification de la valeur de dé 1
                textFieldDe2.setText(partyBean.getJ1().getCup().getD2().getValeur() + "");

                //score
                textFieldScoreJ1.setText(partyBean.getJ1().getScore() + "");

                //rend le bouton j1 invisible après lancer et bouton j2 visible
                btnLancerJ1.setVisible(false);
                btnLancerJ2.setVisible(true);

            }
        });

        btnLancerJ1.setBounds(33, 169, 89, 23);
        frame.getContentPane().add(btnLancerJ1);

        //bouton j2

        btnLancerJ2 = new JButton("Lancer");
        btnLancerJ2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Modification des données
                partyBean.getJ2().launch();
                if(partyBean.getJ2().getCup().getScoreDice() >= 7){
                    partyBean.getJ2().add1Pt();
                }
                //ajouter un tour
                partyBean.add1tour();

                //Affichage des données
                lblJoueur2.setText(partyBean.getJ2().getName());

                textFieldDe1.setText(partyBean.getJ2().getCup().getD1().getValeur() + "");
                textFieldDe2.setText(partyBean.getJ2().getCup().getD2().getValeur() + "");

                //afficher le score j2
                textFieldScoreJ2.setText(partyBean.getJ2().getScore() + "");

                //rend le bouton j2 invisible après lancer et bouton j1 visible
                btnLancerJ2.setVisible(false);
                btnLancerJ1.setVisible(true);

                //afficher un tour
                labelTourValue.setText(partyBean.getTour() + "");////////////////////////////

                //rendre les 2 boutons invisibles et indiquer le gagnant
                if(partyBean.getTour() > NB_TOUR){
                    btnLancerJ1.setVisible(false);//rend invisible le bouton si false
                    btnLancerJ2.setVisible(false);

                    if(partyBean.getJ1().getScore() > partyBean.getJ2().getScore()){
                        lblInfo.setText(partyBean.getJ1().getName() + " a gagné");
                    }
                    else if(partyBean.getJ1().getScore() < partyBean.getJ2().getScore()) {
                        lblInfo.setText(partyBean.getJ2().getName() + " a gagné");
                    }
                    else{
                        lblInfo.setText("Match nul");
                    }
                }

            }
        });
        btnLancerJ2.setBounds(479, 169, 89, 23);
        frame.getContentPane().add(btnLancerJ2);

        btnRestart = new JButton("Restart");
        btnRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //modification des données
                //remettre les scores à 0
                partyBean = new PartyBean(partyBean.getJ1().getName(), partyBean.getJ2().getName());

               //Affichage des données
                //affichage du score
               textFieldScoreJ1.setText("0");
               textFieldScoreJ2.setText("0");

                //affichage du tour à 0
                labelTourValue.setText("0");

                //boutons visibles
                btnLancerJ1.setVisible(true);

                //Pas d'affichage gagnant
                lblInfo.setText("");
            }
        });

        btnRestart.setBounds(235, 293, 140, 23);
        frame.getContentPane().add(btnRestart);

        cbJ1 = new JCheckBox("Tricheur");
        cbJ1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                //partyBean.getJ1().getCup().getD1().setValeur(6);
            }
        });


        cbJ1.setBounds(24, 119, 97, 23);
        frame.getContentPane().add(cbJ1);

        cbJ2 = new JCheckBox("Tricheur");
        cbJ2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            }
        });

        cbJ2.setBounds(470, 119, 97, 23);
        frame.getContentPane().add(cbJ2);

        lblInfo = new JLabel("");
        lblInfo.setForeground(Color.RED);
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setBounds(0, 255, 591, 14);
        frame.getContentPane().add(lblInfo);

    }

    private void temp() {

    }
}
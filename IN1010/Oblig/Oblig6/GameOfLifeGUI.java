
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class GameOfLifeGUI{

    JFrame vindu;
    JPanel toppPanel;
    JPanel rutenettPanel;
    JButton[][] alleKnapper;

    Rutenett rutenett;
    Kontroller kontroller;
    JLabel antallLevende;

    JTextField tidField;

    Font f = new Font("sansserif", Font.PLAIN, 17);

    // Konstruktør, setter opp hele GUIet.
    public GameOfLifeGUI(Rutenett rutenett, Kontroller kontroller){

        this.kontroller = kontroller;
        this.rutenett = rutenett;

        // GENERELT OPPSETT:
        // Set vinduer osv til platform (Windows, mac) sin stil.
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (Exception e) { 
            System.out.println("Klarte ikke å finne CrossPlatformLookAndFeel");
            System.exit(1); 
        }

        vindu = new JFrame("Game Of Lifeeee");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setSize(900, 900);

        JPanel vinduInnhold = new JPanel();
        vindu.add(vinduInnhold);

        vinduInnhold.setLayout(new BorderLayout());
        

        // ************
       
        // START, ANTALL I LIVET, AVSLUTT:
        toppPanel = new JPanel();
        JPanel bunnPanel = new JPanel();
        
        // oprette topp komponenter
        JButton startKnapp = new JButton("START");
        antallLevende = new JLabel("Antall levende: " + rutenett.tellLevendeCeller() + ", Generasjons nr: " + kontroller.hentGenerasjon()); // <-
        JButton avsluttKnapp = new JButton("AVSLUTT");

        // fylle mekanisme
        JPanel fyllePanel = new JPanel();
        JButton fyllKnapp = new JButton("FYLL");
        JLabel infoLabel = new JLabel("% Levende celler");
        JTextField sjanseForAaFylleEnCelle = new JTextField("33");

        // endre tid mekansime.
        JPanel tidPanel = new JPanel();
        tidField = new JTextField("2000");
        JLabel tidLabel = new JLabel("ms mellom generasjoner");

    
        
        // legg till i riktige "subpaneler".
        fyllePanel.add(fyllKnapp);
        fyllePanel.add(sjanseForAaFylleEnCelle);
        fyllePanel.add(infoLabel);

        tidPanel.add(tidField);
        tidPanel.add(tidLabel);


        // Sette utforming
        startKnapp.setBackground(Color.white);
        antallLevende.setBackground(Color.white);
        avsluttKnapp.setBackground(Color.white);
        fyllKnapp.setBackground(Color.white);

        tidField.setColumns(3);
        sjanseForAaFylleEnCelle.setColumns(2);

        // sett Font
        tidField.setFont(f);
        sjanseForAaFylleEnCelle.setFont(f);

        // sette ActionEvents:
        class Avslutt implements ActionListener{ // Kjører System.exit() når avslutt er trykket
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Registret trykk paa AVSLUTT knapp");
                System.exit(0);
            }
        }

        class FyllTilfedig implements ActionListener{
            
            @Override
            public void actionPerformed(ActionEvent e){

                int sjanse = Integer.parseInt(sjanseForAaFylleEnCelle.getText());
                System.out.println("Registret trykk paa FYLL knapp");
                System.out.println("Fyller rutenett med " + sjanse + "% Levende celler");
                kontroller.fyllRutenettTilfeldig(sjanse);
            }
        }


        startKnapp.addActionListener(new Start(startKnapp)); // lenker metode/klasse til tilsvarende knapp...
        avsluttKnapp.addActionListener(new Avslutt());
        fyllKnapp.addActionListener(new FyllTilfedig());


        // legge til i tilsvarende panel.
        toppPanel.add(startKnapp);
        toppPanel.add(antallLevende);
        toppPanel.add(avsluttKnapp);

        bunnPanel.setLayout(new FlowLayout()); // sett layout til bunnpanel .... 
        bunnPanel.add(fyllePanel);
        bunnPanel.add(tidPanel);
        

        vinduInnhold.add(toppPanel, BorderLayout.NORTH);
        vinduInnhold.add(bunnPanel, BorderLayout.SOUTH);


        // ************
        // OPPRETTING AV RUTENETT:
        rutenettPanel = new JPanel(); // se args fra Kontroller.java
        rutenettPanel.setLayout(new GridLayout(rutenett.antallRader, rutenett.antallKolonner));
        rutenettPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 10));
        vinduInnhold.add(rutenettPanel, BorderLayout.CENTER);

        // tegne rutenett:
        alleKnapper = opprettRutenett(rutenett);


        vindu.setLocationRelativeTo(null);
        //vindu.pack(); // foreløpig(?) skaper problemer med størrelse på vindu. 
        vindu.setVisible(true);

        }

    public JButton[][] opprettRutenett(Rutenett rutenett){

        JButton[][] alleRuter = new JButton[rutenett.antallRader][rutenett.antallKolonner];
        
        for (int i = 0; i < rutenett.antallRader; i++){
            for (int j = 0; j < rutenett.antallKolonner; j++){

                alleRuter[i][j] = new JButton();
                alleRuter[i][j].setBackground(Color.BLUE); // starter alltid "blank"
                alleRuter[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                alleRuter[i][j].addActionListener(new celleTrykk(i, j));
                
                rutenettPanel.add(alleRuter[i][j]);
            }
        }
        return alleRuter;
    }

    public void tegnRutenett(){

        try{ // endrer tiden til tiden som står live 
            int nyTid = Integer.parseInt(tidField.getText());
            kontroller.endreTid(nyTid);
        }
        catch( Exception e){}

    
        for (int i = 0; i < rutenett.antallRader; i++){
            for (int j = 0; j < rutenett.antallKolonner; j++){

                Celle celle = rutenett.hentCelle(i, j);
                JButton knapp = alleKnapper[i][j];

                Random rand = new Random();

                // ENDRE HER FOR Å ENDRE FARGER...
                int r = rand.nextInt(100,255);
                int g = rand.nextInt(100,255);
                int b = rand.nextInt(190,200);

                //Color randomFarge = new Color(r, g, b);
                if (celle.hentLeveStatus()){
                    knapp.setBackground(new Color(r, g, 0));
                }
                else {
                    knapp.setBackground(new Color(0, 0, b));
                }
            }
        }
        antallLevende.setText("Antall levende: " + rutenett.tellLevendeCeller() + ", Generasjons nr: " + kontroller.hentGenerasjon());

    }


   class celleTrykk implements ActionListener{ // Skal "toggle" status til cellen.

        int rad, kol;

        public celleTrykk(int i, int j){
            rad = i; kol = j;  
        }
        @Override
        public void actionPerformed(ActionEvent e){
            kontroller.oppdaterCelle(rad, kol);
        }     
    }

    // endrer ActionListener til start/stopp knappen tilbake til start og stopper kjoreTraaden. 
    class Stopp implements ActionListener{
        
        JButton knapp;
        Thread kjoreTraad;

        public Stopp(JButton knapp, Thread kjoreTraad){
            this.knapp = knapp;
            this.kjoreTraad = kjoreTraad;
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            knapp.setText("START");
            knapp.removeActionListener(this);
            knapp.addActionListener(new Start(knapp));
            kjoreTraad.interrupt();
            System.out.println("Stoppet aa oppdatere spillet!");
            
        }
    }

    // Starter en while løkke i en Traad som kjorer til den blir interrupted av Stopp actionListener.
    class Start implements ActionListener{
        
        JButton knapp;

        public Start(JButton knapp){
            this.knapp = knapp;
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            knapp.setText("STOPP");
            Thread kjoreTraad = new Thread(kontroller);
            knapp.removeActionListener(this);
            knapp.addActionListener(new Stopp(knapp, kjoreTraad));
            kjoreTraad.start();
            System.out.println("Startet aa oppdatere spillet!");
            
        }
    }

}




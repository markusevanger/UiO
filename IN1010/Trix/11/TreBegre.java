
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;
import java.util.random.*;
class TreBegre{


    public static void main(String[] args) {
        
        JFrame vindu = new JFrame("Tre begre og en ball");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        vindu.add(panel);


        

        int ANT_KNAPPER = 3;
        JButton[] knapper = new JButton[ANT_KNAPPER];
        boolean[] fasit = lagFasit(ANT_KNAPPER);

        class Svar implements ActionListener{ // Endrer teksten når en knapp er trykket.

            @Override
            public void actionPerformed(ActionEvent e){

                for (int i = 0; i < knapper.length; i++){
                    JButton knapp = knapper[i];
                    if (fasit[i]){
                        knapp.setText("OK");
                    }
                    else {
                        knapp.setText("NEI");
                    }
                }
            }

        }

        for (int i = 0; i < ANT_KNAPPER; i++){
            JButton knapp = new JButton("Beger");
            knapper[i] = knapp;
            knapp.addActionListener(new Svar());
            panel.add(knapp);
            
        }



        vindu.pack();
        vindu.setVisible(true);
    }

    public static boolean[] lagFasit(int storrelse){
        
        boolean[] listeMedBool = new boolean[storrelse];
        Random random = new Random();
        int begerMedBall = random.nextInt(storrelse+1);

        for (int i = 0; i < listeMedBool.length; i++){
          listeMedBool[i] = (i == begerMedBall);
        }
        
        System.out.println("FASIT:");
        for (boolean b : listeMedBool){
            System.out.println(b);
        }

        return listeMedBool;


    }
}
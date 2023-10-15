import java.time.LocalTime;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Klokke{

    static boolean slutt = false;

    public static void main(String[] args) {

        JFrame vindu = new JFrame("Klokken akkuratt nå");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        JButton klokken = new JButton(("Klokken er: " + naa()));
        
        class Stopper implements ActionListener {

            @Override
            public void actionPerformed (ActionEvent e){
                slutt = true;
                System.exit(0);
            }
        }
        klokken.addActionListener(new Stopper());
        panel.add(klokken);


        class Sekundteller extends Thread {

            @Override
            public void run() {
                while(!slutt){
                    try{
                        sleep(1000);
                        klokken.setText("Klokken er: " + naa());
                    } catch  (InterruptedException e) {}
                }
            }
        }

        new Sekundteller().start();

        vindu.pack();
        vindu.setVisible(true);

    }

    private static String naa() {
        // Hva er klokken nå?
        LocalTime t = LocalTime.now();
        return
          String.format("%02d:%02d:%02d",
            t.getHour(), t.getMinute(), t.getSecond());
    }
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Rutenett{

    public static void main(String[] args) {

        JFrame vindu = new JFrame("Rutenett");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        vindu.add(panel);

        JPanel rutenett = new JPanel(null, false);

        int bredde = 3;
        int hoyde = 3;

        rutenett.setLayout(new GridLayout(bredde, hoyde));

        for (int i = 1; i <= (bredde*hoyde); i++){
            JLabel nr = new JLabel("" + i);
            nr.setPreferredSize(new Dimension(30, 30));
            nr.setHorizontalAlignment(JLabel.CENTER);
            nr.setVerticalAlignment(JLabel.CENTER);
            nr.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // rounded?
            rutenett.add(nr);
        }

        panel.add(rutenett);

        vindu.pack();
        vindu.setVisible(true);

        
    }
}
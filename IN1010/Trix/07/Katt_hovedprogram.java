import java.util.Random;
import java.util.ArrayList;

    public class Katt_hovedprogram {
    
    // hovedprogram.
        public static void main(String[] args){

            Random rand = new Random();
            Katt[] kattehus = new Katt[10];
            String[] kattenavn = {"Tussi", "Pus", "Markus", "Knut", "Simba", "Felix", "Katta", "Luna", "Marius", "Linn"};
      

            System.out.println("");
            System.out.println("Legger til " + kattehus.length + " katter....");
            for (int i = 0; i < kattehus.length; i++){
                int alder = rand.nextInt(14); // tilfeldig tall mellom 
                String navn = kattenavn[i]; // hent navn fra kattenavn.

                Katt nyKatt = new Katt(navn, alder);
                kattehus[i] = nyKatt;

                System.out.println(nyKatt);
            }
            System.out.println("");



            ArrayList<Katt> eldsteKatter;
            for (int i = 0; i < kattehus.length; i++){

                Katt nesteKatt = kattehus[i];
                

            }
        }
}
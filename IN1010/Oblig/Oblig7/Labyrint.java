
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;



public class Labyrint {

    Rute[][] rutenett; 

    public Labyrint(String filnavn){
        rutenett = lesFilOgLagRutenett(filnavn);
        settAlleNaboer(); 
    }

    public String toString(){
        System.out.println();
        

        for (Rute[] rad : rutenett){
            for (Rute rute : rad){
                System.out.print(rute);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Rader: " + rutenett.length + ", Kolonner: " + rutenett[0].length);
        return ("");
    }


    public String printRuter(){
            
            System.out.println();    
            for (Rute[] rad : rutenett){
                for (Rute rute : rad){
                    System.out.print(rute.hentVerdi());
                }
                System.out.println();
            }
    
            System.out.println();
            System.out.println("Rader: " + rutenett.length + ", Kolonner: " + rutenett[0].length);
            return ("");



    }

    public Rute hentRute(int rad, int kol){
        try{
            return rutenett[rad][kol];
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
        
    }

    public void settAlleNaboer(){
        for (Rute[] rad : rutenett){
            for (Rute rute : rad){
                rute.settNaboer();
            }
        }
    }

    public void finnUtveiFra(int rad, int kol){
        System.out.println("Aapninger: ");
        rutenett[rad][kol].finn(null);
        fjernSjekketStatusFraAlleCeller();
        
    }

    public Rute[][] lesFilOgLagRutenett(String filnavn){
        // Rute[][] rutenett;


        // Opprett filobjekt.

        File fil;
        Scanner sc = null;

        
        // Redefinerer Scanner slik at vi kan lese den omigjen. 
        try{
            fil = new File(filnavn);
            sc = new Scanner(fil);
        }
        catch(FileNotFoundException e){
            System.out.println("Fant ikke filen!");
            System.out.println(e);
            e.printStackTrace();
            System.exit(1);
        }

        int rad = 0; // holder telling på hvilken rad I RUTENETTET vi leser, teller kun opp etter vi har opprettet rutenettet
        int kjoring = 0; // holder telling på hvilken linje i filen vi er på.
        Rute[][] rutenett = null; // initialiserer rutenett
        int antallRader = 0;
        int antallKol = 0;
        
        while (sc.hasNextLine()){
            String linje = sc.nextLine(); // hold av linjen. Vi kan kun bruke nextLine(); en gang per loop.
            String[] linjeStr = linje.split(" "); // oppretter en liste: ["8", "9"]
           
            // OPPRETT RUTENETT! #️⃣
            if (kjoring == 0){

                antallRader = Integer.parseInt(linjeStr[0]);
                antallKol = Integer.parseInt(linjeStr[1]);

                System.out.println("Oppretter rutenett paa stoerrelse: " + antallRader + ", " + antallKol);
                
                rutenett = new Rute[antallRader][antallKol]; 
            }

            else{
                char[] linjeChar = linje.toCharArray(); // bruker en char array slik at vi kan sammenlikne char istedenfor Strings.  
                for (int kol = 0; kol < antallKol; kol++){ // for hver kol eller char i linjen:
                    if (linjeChar[kol] == '#'){
                        rutenett[rad][kol] = new SortRute(rad, kol, this);
                    }
                    else if (linjeChar[kol] == '.'){

                        // sjekk om det er en aapning:
                        if (rad == 0 || rad == antallRader-1 || kol == 0 || kol == antallKol-1){
                            rutenett[rad][kol] = new Aapning(rad, kol, this);
                            System.out.println("Opprettet en ny aapning: Rad: " + rad + "Kol:" + kol);
                        }
                         // ikke en aapning
                        else{
                            rutenett[rad][kol] = new HvitRute(rad, kol, this);
                        }

                        
                    }
                }
                rad++; // iterer rad, [innenfor rutenettet i txt filen].
            }
            kjoring++;
        }
        return rutenett;
    } 

    public void fjernSjekketStatusFraAlleCeller(){

        for (Rute[] rader : rutenett){
            for (Rute rute : rader){
                rute.fjernSjekketStatus();
            }
        }
        Rute.leseTeller = 0; // endrer statisk teller til 0;
    }

}
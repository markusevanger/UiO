
import java.util.Random;

class Rutenett{

    private Celle[][] rutenett;
    public final int antallRader; // public fordi de er final. Slipper en hentX() metode.
    public final int antallKolonner;
    private int generasjonsTeller;

    public Rutenett(int rader, int kolonner){

        // Settes slik at det alltid er offentlig hvor stort rutenettet er.
        antallRader = rader;
        antallKolonner = kolonner;

        // fyller rutenett med doede celler
        rutenett = new Celle[kolonner][rader];
        for (int i = 0; i < kolonner; i++){
            for (int j = 0; j < rader; j++){
                rutenett[i][j] = new Celle();
            }
        }

        finnAlleNaboer(); // setter basis, kobler alle naboer.
        telleAlleNaboer(); // blir alltid 0. Ikke nødvendig om rutenettet starter tomt. 

        generasjonsTeller = 0;
    }

    public Celle[][] hentRutenett(){
        return rutenett;
    }

    // Skriver ut alle ruter i "riktig format"
    public void skrivTilTerminal(){
        for (Celle[] rad : rutenett){
            for (Celle rute : rad){
                System.out.print(rute);
            }
        System.out.println(); // linjeskift.
        }
    }

    // Sjekker at input er lovlig og returnerer cellen på [rad][kol]. 
    public Celle hentCelle(int rad, int kol){
        if (rad <= rutenett.length && kol <= rutenett[0].length && rad >= 0 && kol >= 0){
            return rutenett[rad][kol];
        }
        return null; //
    }

    // Fyller Rutenett med tilfeldige celler. 
    public void fyllMedTilfeldigeCeller(int sjanseProsent){
        Random rand = new Random();
        for (Celle[] rad : rutenett){
            for (Celle celle : rad){
                if (rand.nextInt(100 + 1) <= sjanseProsent){ // til og med 100 og ikke 99
                    celle.settLevende();
                }
            }
        }
        telleAlleNaboer(); // må telle alle naboene "manuelt" slik at alt er oppdatert når programmet skal kjøre.
    }

    public void finnAlleNaboer(){

        // iterer gjennom alle ruter i rutenettet
        for (int rad = 0; rad < rutenett.length; rad++){
            for (int kolonne = 0; kolonne < rutenett[rad].length; kolonne++){

                Celle celle = rutenett[rad][kolonne]; // sett hovedcellen

                // iterer gjennom cellens naboer i rutenettet. De med +1, 0, eller -1 ekstra i kordinater.
                for (int offset_x = -1; offset_x < 2; offset_x++){
                    for (int offset_y = -1; offset_y < 2; offset_y++){
                        if (!(offset_x == 0 && offset_y == 0)){
                            try{
                                celle.leggTilNabo(rutenett[offset_x + rad][offset_y + kolonne]);
                            }
                            catch(IndexOutOfBoundsException e){
                                // Da gjør vi ingenting, pga ruten vi ser etter er utfor bounds. 
                                // System.out.println("out of bounds! for celle: " + (offset_x+rad) + ", " + (offset_y+kolonne));
                            }
                        }
                    }
                }
            }
        }
    }

    public void telleAlleNaboer(){

        for (Celle[] rad : rutenett){
            for (Celle celle : rad){
                celle.tellLevendeNaboer();
            }
        }
    }

    public int tellLevendeCeller(){
        int teller = 0;
        for (Celle[] rad : rutenett){
            for (Celle celle : rad){
                if (celle.hentLeveStatus()){teller++;};
            }
        }
        return teller;
    }

    public void oppdaterStatus(){

        // oppdaterer celler i takt med reglene til spillet:
        // levende celler skal død om: levendeNaboer < 2 eller levevendeNaboer > 3
        // døde celler skal komme til live om: levendeNaboer == 3.

        for (Celle[] rad : rutenett){
            for (Celle celle : rad){

                if (celle.hentLeveStatus()){
                    if (celle.hentAntallLevendeNaboer() < 2 || celle.hentAntallLevendeNaboer() > 3){ 
                        celle.settDoed();
                    }
                }
                else if (celle.hentAntallLevendeNaboer() == 3){
                    celle.settLevende();
                }
            }
        }
        telleAlleNaboer();
        generasjonsTeller++;
    }

    // kalles på av kontroller, som kalles på av gui for å vise riktig generasjon.
    public int hentGenerasjon(){
        return generasjonsTeller;
    }
}
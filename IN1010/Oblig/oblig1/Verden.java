class Verden {

    // setter instansvariablene
    private int genNr;
    private Rutenett rutenett;


    // Konstruktør, oppretter rutenett objekt med oppgitt antall rader og kolonner. Setter opp rutenettet for bruk.
    public Verden(int rader, int kolonner) {

        rutenett = new Rutenett(rader, kolonner);
        genNr = 0;

        rutenett.fyllMedTilfeldigeCeller(); 
        rutenett.kobleAlleCeller();
    
    }

    // kjører tegnRutenett() en gang og deretter oppgir informasjon om generasjonsnummer og hvor mange levende som er i rutenettet. 
    public void tegn(){


        rutenett.tegnRutenett();
        System.out.println("Generasjon: " + genNr);
        System.out.println("Antall Levende: " + rutenett.antallLevende());

    }


    // Teller antall levende naboer for hver celle. Deretter oppdaterer den cellens status i følge spillets regler. Oppdaterer generasjons nummeret. 
    
    public void oppdatering(){

        

          for (int rad = 0; rad < rutenett.antRader; rad++) {
            for (int kol = 0; kol < rutenett.antKolonner; kol++) {
        
                rutenett.hentCelle(rad, kol).tellLevendeNaboer();
            }
        }

          for (int rad = 0; rad < rutenett.antRader; rad++) {
            for (int kol = 0; kol < rutenett.antKolonner; kol++) {
        
                rutenett.hentCelle(rad, kol).oppdaterStatus();
            }
        }
        
        genNr++; 
}
}
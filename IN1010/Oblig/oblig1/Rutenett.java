class Rutenett {


    // oppretter instansvariablene for rutenettet aka nøstede arrays
    public int antRader;
    public int antKolonner; // public, brukes i verdensprogram. kunne eventuelt laget ny metode for å returnere verdiene.
    private Celle[][] rutene;
    

    // Setter verdiene til valgte verdier. 
    public Rutenett(int rader, int kolonner) {

        antRader = rader; 
        antKolonner = kolonner;
        rutene = new Celle[antRader][antKolonner];
    }


    // oppretter nytt celle objekt i minnet og lagrer en referanse til den i valgt index i rutenett
    // Setter levende 1/3 av gangene.
    public void lagCelle(int rad, int kol) {

        Celle cellen = new Celle();
        rutene[rad][kol] = cellen;

        if (Math.random()<=0.3333) {
            cellen.settLevende();
        }
    }

    // kjører lagCelle() på alle celler i rutenettet. Resultatet er et rutenett fylt av celler, der 1/3 er levende. 
    public void fyllMedTilfeldigeCeller(){

        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol ++) {
                lagCelle(rad, kol);
            }
        }
    }

    // henter ut celleobjektet av rutenettet. Returnerer null om opgitt index er utenfor rutenettet. 
    public Celle hentCelle(int rad, int kolonne) {

        if (rad >= antRader || rad < 0 || kolonne >= antKolonner || kolonne < 0) {
            return null;
        }      
        return rutene[rad][kolonne];
    }

    // Kjører hentStatusTegn() på alle celler i rutenettet og skriver ut resultatet i terminalen. 
    public void tegnRutenett(){


         for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol ++) {
                
                System.out.print(" " + rutene[rad][kol].hentStatusTegn() + " ");

            }
        System.out.println(" ");
    }
    }



    // Sjekker de 8 rutene rundt en valgt celle og lagrer en referanse til dem i cellens interne array. 
    public void settNaboer(int rad, int kol) {

        Celle hoved = rutene[rad][kol];

        for (int offset_rad = -1; offset_rad < 2; offset_rad++) {
            for (int offset_kol = -1; offset_kol < 2; offset_kol++) {

                int ny_r = offset_rad + rad;
                int ny_k = offset_kol + kol;

                
                
                // if hentCelle ikke er 0 på valgt index i rutenett AND not seg selv:
                if (hentCelle(rad + offset_rad, kol + offset_kol) != null && !(offset_rad == 0 && offset_kol == 0)){

                    
                    Celle nabo = hentCelle(ny_r, ny_k);
                    hoved.leggTilNabo(nabo);
                    
                } 
                }


        }
    }


    // kjører settNaboer på alle celler i rutenettet
    public void kobleAlleCeller() {

        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {

                settNaboer(rad, kol);
            }
        }
    }


    // teller antall celler med levende status i rutenettet, returneres som int
    public int antallLevende() {

        int teller = 0;

        for (int rad = 0; rad < antRader; rad++) {
            for (int kol = 0; kol < antKolonner; kol++) {

                if (rutene[rad][kol].erLevende()) {
                    teller++;
                }
            }
        }

        return teller;
}



}

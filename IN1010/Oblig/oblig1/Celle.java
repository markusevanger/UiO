class Celle {

    // opretter instansvariabelene for cellens informasjon
     private boolean levende; // 
     private Celle[] naboer; // array som skal holde referenase til alle naboer
     private int antNaboer; // hvor mange naboer cellen har
     private int antLevendeNaboer; // hvor mange av dem lever.



    // kontruktør, oppretter cellen som død og setter array til 8 celleobjekter stor. 
    public Celle(){


        levende = false;
        naboer = new Celle[8];
        antNaboer = 0;
        antLevendeNaboer  = 0;



    }

    // metode for å sette levende status til død
    public void settDoed(){

        levende = false;
    }

    // metode for å sette levende statis til levende
    public void settLevende(){

        levende = true;
    }

    // metode for å sjekke statusen til cellen.
    public boolean erLevende(){

        return levende;

    }


    // For å representere om cellen er levende eller død, returneres en char der: O er levende og . er død
    public char hentStatusTegn(){

        if (levende) {
            return 'O';
            
        } else {
            return '.';
        }
    }

    // Legger til oppgit nabo i naboer arrayen til cellen. 
    public void leggTilNabo(Celle naboen) {

        for (int i = 0; i < naboer.length; i++) {
            if (naboer[i] == null) { // finner ledig plass i arrayen.
                naboer[i] = naboen;
                antNaboer++;
                return;  // avbryter for loopen slik at ikke hele fylles med referanser til samme objekt.
                
            }
        }
    }

    // sjekker hvor mange naboer i arrayen naboer som har status levende. Oppdaterer instansvariabelen antLevendeNaboer.
    public void tellLevendeNaboer() {

        int teller = 0;
        for (int i = 0; i < naboer.length; i++) {
        if (naboer[i] != null){
            if (naboer[i].erLevende()) {
                teller++; 
            }
        }
        antLevendeNaboer = teller;
        }
    }

    // "Reglene for spillet", disse som bestemmer om en celle skal dø, fortsette å leve eller komme tilbake i live. Kjøres en gang per celle for hver generasjon.
    public void oppdaterStatus() {

        if (levende) {
            if (antLevendeNaboer < 2 || antLevendeNaboer > 3 ) {
                settDoed();
            }
        } else {
            if (antLevendeNaboer == 3) {
                settLevende();
            }
        }

}

}
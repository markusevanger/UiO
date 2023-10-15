

// Tilsvarer celle fra oblig1 i 


class Celle{

    private boolean lever; //maa kanskje endre til priv?
    private int antallLevendeNaboer = 0;
    private Celle[] naboer = new Celle[8];


    public Celle(){
        lever = false;
    }

    public void settLevende(){
        lever = true;
    }
    public void settDoed(){
        lever = false;
    }

    public void toggleStatus(){
        lever = !lever;
    }

    public boolean hentLeveStatus(){
        return lever;
    }

    public int hentAntallLevendeNaboer(){
        return antallLevendeNaboer;
    }

    public String toString(){
        if (lever){ return "o"; }
        return ".";
    }
    
    public void leggTilNabo(Celle nyNabo){
        for (int i = 0; i < naboer.length; i++){
            if (naboer[i] == null){
                naboer[i] = nyNabo;
                return;
            }
        } 
    }

    public void tellLevendeNaboer(){
        
        int teller = 0;
        for (Celle nabo : naboer){
            if (nabo != null){
                if (nabo.hentLeveStatus()){
                    teller++;
                }
            }
            else {
                break;
            }
        }
        antallLevendeNaboer = teller;
    }
}
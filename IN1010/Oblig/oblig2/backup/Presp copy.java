class Presp extends Hvit {

    public Presp(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }


    public int prisAaBetale(){

    int rabbatert_pris = (legemiddel.hentPris() - 108 );
    
    if (bruk()) { // om gyldig -> bruk
        if (rabbatert_pris > 0) { // om rabbatert pris er over 0, returner ny pris. 
            return rabbatert_pris;
        }
    }
    return 0;
}
}
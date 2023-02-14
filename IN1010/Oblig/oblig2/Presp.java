class Presp extends Hvit {

    public Presp(int id, Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(id, legemiddel, utskrivendeLege, pasientId, reit);
        this.legemiddel = legemiddel;
    }


    public int prisAaBetale(){

    int rabbatert_pris = (legemiddel.hentPris()-108);
    
    if (bruk()) { // om gyldig -> bruk
        if (rabbatert_pris > 0) { // om rabbatert pris er over 0, returner ny pris. 
            return rabbatert_pris;
        }
    }
    return 0;
}
}
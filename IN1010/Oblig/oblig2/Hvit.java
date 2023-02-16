class Hvit extends Resept {

    //konstruktør med reit
    public Hvit(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // konstruktør uten reit.
    public Hvit(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){
        super(legemiddel, utskrivendeLege, pasientId);
    }


    // gir standardpris som i utgangspunktet. 
    public int prisAaBetale(){
        return legemiddel.hentPris();
    }

    public String farge(){
        return "hvit";
    }
}
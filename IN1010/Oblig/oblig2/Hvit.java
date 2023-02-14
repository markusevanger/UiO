class Hvit extends Resept {

    //konstruktør med reit
    public Hvit(int id, Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(id, legemiddel, utskrivendeLege, pasientId, reit);
    }

    // konstruktør uten reit.
    public Hvit(int id, Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){
        super(id, legemiddel, utskrivendeLege, pasientId);
    }


    // gir standardpris som i utgangspunktet. 
    public int prisAaBetale(){
        return legemiddel.hentPris();
    }

    public String farge(){
        return "hvit";
    }
}
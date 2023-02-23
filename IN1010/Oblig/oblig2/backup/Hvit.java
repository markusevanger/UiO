class Hvit extends Resept {

    private String hvit = "hvit";

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
        return farge;
    }
}
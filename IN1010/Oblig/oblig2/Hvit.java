class Hvit extends Resept {

    private String farge = "hvit";
    private Legemiddel legemiddel;


    //konstruktør med reit
    public Hvit(int id, Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(id, legemiddel, utskrivendeLege, pasientId, reit);
        this.legemiddel = legemiddel;
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
        return farge;
    }
}
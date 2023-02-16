abstract class Resept {

    public final Legemiddel legemiddel;
    private final Lege utskrivendeLege;
    private final int pasientId;
    private int reit;

    private static int teller = 0;
    public final int id;
   

    // konstruktør med reit
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) { 

        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        id = teller;
        teller++;
    }

    // konstruktør uten reit
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) { 

        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = 3;
        id = teller;
        teller++;
    }


    public boolean bruk(){

        if (reit > 0) {
            reit -= 1;
            return true;         
        }
        return false;
    }
    

    // abstrakte metoder som blir definert i subklassene. 
    abstract public String farge();
    abstract public int prisAaBetale();








    // hent metoder

    public int hentId(){
        return id;
    }

    public Legemiddel hentLegemiddel(){
        return legemiddel;
    }

    public Lege hentLege(){
        return utskrivendeLege;
    }

    public int hentReit(){
        return reit;
    }

    public int hentPasientID(){
        return pasientId;
    }




}
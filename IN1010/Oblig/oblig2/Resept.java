abstract class Resept {

    private final Legemiddel legemiddel;
    private final Lege utskrivendeLege;
    private final int pasientId;
    private final int id;
    private int reit;
   

    // konstruktør med reit
    public Resept(int id, Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) { 

        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        this.id = id;
    }

    // konstruktør uten reit
    public Resept(int id, Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) { 

    this.legemiddel = legemiddel;
    this.utskrivendeLege = utskrivendeLege;
    this.pasientId = pasientId;
    this.reit = reit;
    this.id = id;
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
        return legemiddel.id;
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




}
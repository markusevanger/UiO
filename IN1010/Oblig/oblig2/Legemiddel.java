abstract class Legemiddel { // abstract = umulig å danne en klasse av Legemiddel.

    public final String navn;
    public final double virkestoff; 
    public final int id;
    public int pris;
    


    public Legemiddel(String navn, int pris, double virkestoff, int id) {

        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.id = id;
    }
    


    public int hentPris(){
        return pris;
    }

    public void settNyPris(int pris){

        this.pris = pris;
    }
}
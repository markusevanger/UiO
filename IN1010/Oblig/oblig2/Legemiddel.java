abstract class Legemiddel { // abstract = umulig å danne en klasse av Legemiddel.

    public final String navn;
    public final double virkestoff; 
    public int pris;

    private static int teller = 0;
    public final int id;
    


    public Legemiddel(String navn, int pris, double virkestoff) {

        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id = teller;
        teller++;
    }
    


    public int hentPris(){
        return pris;
    }

    public void settNyPris(int pris){

        this.pris = pris;
    }
}
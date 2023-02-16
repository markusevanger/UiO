class Narkotisk extends Legemiddel {

    public final int styrke;

    public Narkotisk(String navn, int pris, double virkestoff, int styrke){

        super(navn, pris, virkestoff); // <-- sender videre parametre som skal brukes av super klassen
        this.styrke = styrke;

    }

}


class Subsekvens {

    public final String subsekvens;// public + final. Kan bli lest men ikke skrevet til (utenom i konstruktor og metoden)
    private int antall = 0;


    // konstruktor
    public Subsekvens(String subsekvens, int antall){

        this.subsekvens = subsekvens;
        this.antall = antall;
    }

    // endre forekomster
    public void oekAntallForekomster(int nyttAntall){
        antall += nyttAntall;
    }

    public void inkrementerAntall(){
        antall++;
    }

    // antall forekomster
    public int hentAntallForekomster(){
        return antall;
    }

    // to string
    public String toString(){
        return subsekvens + "," + antall;
    }

}
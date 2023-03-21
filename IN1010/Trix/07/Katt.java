

public class Katt implements Comparable<Katt> {

    private String navn;
    private int alder;

    public Katt(String navn, int alder){
        this.navn = navn;
        this.alder = alder;
    }

    public String toString(){
        return "Denne katten heter " + navn + " og er " + alder + " aar gammel.";
    }

    public int hentAlder(){
        return alder;
    }

    public String hentnavn(){
        return navn;
    }

    public int compareTo(Katt annen_katt){

        int annen_alder = annen_katt.hentAlder();

        if (alder > annen_alder){return  1;}
        if (alder < annen_alder){return -1;}
        return 0;
    }
}
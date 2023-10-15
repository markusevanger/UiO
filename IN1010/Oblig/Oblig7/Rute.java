abstract public class Rute {

    int rad;
    int kol;
    Labyrint lab;

    Rute nord;
    Rute soer;
    Rute vest;
    Rute oest;

    Rute[] naboer = new Rute[4]; 

    int id;
    boolean sjekket;
    static int leseTeller;

    public Rute(int rad, int kol, Labyrint lab){

        this.rad = rad;
        this.kol = kol;
        this.lab = lab;
        sjekket = false;

    }

    public void fjernSjekketStatus(){
        sjekket = false;
    }


    public void settNaboer(){
       
        nord = lab.hentRute(rad + 1, kol); 
        soer = lab.hentRute(rad - 1, kol);
        vest = lab.hentRute(rad, kol - 1);
        oest = lab.hentRute(rad, kol + 1);

        naboer[0] = nord;
        naboer[1] = oest;
        naboer[2] = soer;
        naboer[3] = vest;

        // System.out.println(nord);
        // System.out.println(vest + this.toString() + oest);
        // System.out.println(soer);

    }

    public abstract void finn(Rute fra);
    public abstract String hentVerdi();
    
}


// #O#
// O.O
// #O#
public class SortRute extends Rute {

    public SortRute(int rad, int kol, Labyrint lab){
        super(rad, kol, lab);
    }

    public String toString(){
        return " # ";
    }

    @Override
    public void finn(Rute fra){
        if (fra == null){
            System.out.println("Du kan ikke starte paa en svart rute! (" + rad + ", " + kol + ")");
        }
    }

    @Override
    public String hentVerdi(){
        return toString();
    };
    
}

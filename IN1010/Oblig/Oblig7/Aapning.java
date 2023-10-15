
public class Aapning extends HvitRute {

    public Aapning(int rad, int kol, Labyrint lab){
        super(rad, kol, lab);
    }
     
    @Override
    public void finn(Rute fra){
        System.out.println("(" + rad + ", " + kol + ")");
        sjekket = true;
    }

    @Override
    public String hentVerdi(){
        return " X ";
    }
}

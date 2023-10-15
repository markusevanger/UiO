public class HvitRute extends Rute {

    int leseId;
    

    public HvitRute(int rad, int kol, Labyrint lab){
        super(rad, kol, lab);

    }

    public String toString(){
        return " . ";
    }

    @Override
    public String hentVerdi(){
        return " " + leseId + " ";
    }
    
    @Override
    public void finn(Rute fra){



        if (!sjekket){ // Stopper programmet fra å sjekke samme rute to ganger.

            leseId = leseTeller;
            leseTeller++;

            for (Rute nabo : naboer){
                if (!(nabo == null) && nabo != fra){
                    sjekket = true; 
                    nabo.finn(this);
                }
            }
        }
    } 
}

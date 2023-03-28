

public class Monitor{

    private int detMinste = 0;
    private int detStorste = 0;


    public Monitor(int tall1, int tall2){

        if (tall1 > tall2){
            detMinste = tall2;
            detStorste = tall1;
            return;
        }
        // tall1 =< tall2
        detMinste = tall1;
        detStorste = tall2;
    }


    public boolean settStorste(int nyTall){
        if (nyTall >= detMinste){
            detStorste = nyTall;
            return true;
        }
        return false;
    }

    public boolean settMinste(int nyTall){
        if (nyTall <= detStorste){
            detMinste = nyTall;
            return true;
        }
        return false;
    }
}
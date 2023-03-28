import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor{

    public int detMinste = 0;
    public int detStorste = 0;
    private Lock laas = new ReentrantLock();


    public Monitor(int tall1, int tall2){

        laas.lock();

        try{
            if (tall1 > tall2){
                detMinste = tall2;
                detStorste = tall1;
                return;
            }
            // tall1 =< tall2
            detMinste = tall1;
            detStorste = tall2;
        }
        finally{
            laas.unlock();
        }
    }


    public boolean settStorste(int nyTall){

        laas.lock();

        try{
            if (nyTall >= detMinste){
                detStorste = nyTall;
                return true;
            }
            return false;
        }
        finally {
            laas.unlock();
        }
    }

    public boolean settMinste(int nyTall){
        
        laas.lock();

        try{
            if (nyTall <= detStorste){
                detMinste = nyTall;
                return true;
            }
            return false;
        }

        finally{
            laas.unlock();
        }
    }

    @Override
    public String toString(){
        return ("Storste: " + detStorste + ", Minste: " + detMinste);
    }
}
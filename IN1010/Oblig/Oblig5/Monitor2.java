import java.util.concurrent.locks.Lock;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;


class Monitor2{

    private SubsekvensRegister sr;
    private Lock laas;
    private String type;
    // private Condition condition;
    

    public Monitor2 (SubsekvensRegister sr, String smittet_eller_ikke){

        this.sr = sr;
        type = smittet_eller_ikke;
        laas = new ReentrantLock();
        

    }

    public void settInn(HashMap<String, Subsekvens> dict){
        
        laas.lock();
        try{
            sr.leggTil(dict);
        }
        finally {
            laas.unlock();
        }
    }

    public HashMap<String, Subsekvens> hentSubsekvens(String ss){
        laas.lock();
        try{
            return sr.hentSubsekvens(ss);
        }
        finally {
            laas.unlock();
        }
    }

    public ArrayList<HashMap<String, Subsekvens>> hentRegister(){
        return sr.hentRegister();
    }


    public int hentStoerelse(){

        laas.lock();
        try{
            return sr.hentStoerelse();
        }
        finally {
            laas.unlock();
        }    
    }
    

    public HashMap<String, Subsekvens> lesFraFil(String filnavn){
        return sr.lesFraFil(filnavn);
    }


    public HashMap<String, Subsekvens> slaaSammen(HashMap<String, Subsekvens> dict1, HashMap<String, Subsekvens> dict2){
        return sr.slaaSammen(dict1, dict2);
    }


    public ArrayList<HashMap<String, Subsekvens>> hentUtTo(){


        // Forsøker å hente ut de to "nederste" hashmaps i subsekvens register
        // Når det bare er en igjen, får vi index out of bounds som vi catcher. 

        laas.lock();
        ArrayList<HashMap<String, Subsekvens>> toHash = new ArrayList<HashMap<String, Subsekvens>>();

        try{
            toHash.add(sr.hentRegister().get(1)); // henter referanse
            sr.hentRegister().remove(1); // sletter referanse
            toHash.add(sr.hentRegister().get(0));
            sr.hentRegister().remove(0);
            return toHash;
        }
        catch(IndexOutOfBoundsException e){
            return null; 
        }
        finally{
            laas.unlock();
        }
    }

    public void settInnFlettet(HashMap<String, Subsekvens> flettetHash){
        laas.lock();
        try{
            sr.leggTil(flettetHash);
        }
        finally {
            laas.unlock();
        }
    }

    public String toString(){
        return type;
    }
}
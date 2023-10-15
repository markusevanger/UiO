import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

class Monitor1{

    private SubsekvensRegister sr;
    private Lock laas;
    

    public Monitor1(SubsekvensRegister sr){

        this.sr = sr;
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
        laas.lock();
        try{
            return sr.lesFraFil(filnavn);
        }
        finally {
            laas.unlock();
        }      
    }


    public HashMap<String, Subsekvens> slaaSammen(HashMap<String, Subsekvens> dict1, HashMap<String, Subsekvens> dict2){
        laas.lock();
        try{
            return sr.slaaSammen(dict1, dict2);
        }
        finally {
            laas.unlock();
        }
    }
}
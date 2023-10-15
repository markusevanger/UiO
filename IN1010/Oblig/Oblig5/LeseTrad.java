import java.util.HashMap;

class LeseTrad implements Runnable{
    
    String filnavn;
    Monitor2 monitor;
    HashMap<String, Subsekvens> hash;
    public LeseTrad(String filnavn, Monitor2 monitor){
        this.filnavn = filnavn;
        this.monitor = monitor;
        
    }

    public void run(){
        hash = monitor.lesFraFil(filnavn);
        monitor.settInn(hash);
        System.out.println(filnavn + ": er lest og lagt til i monitor. Storrelse: " + hash.size());
        
    }
}
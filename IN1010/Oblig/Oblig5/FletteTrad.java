
import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;




class FletteTrad implements Runnable{

    Monitor2 monitor;
    CountDownLatch latch;

    private final int id; 
    

    public FletteTrad(Monitor2 monitor, CountDownLatch latch, int id){
        this.monitor = monitor;
        this.latch = latch;
        
        this.id = id;
    }

    public void run(){

        // forsøker å kjøre til hentUtTo returnerer null, altså når det ikke lenger går an å hente ut mer. 
        System.out.println("Startet FletteTraad: " + id);
        
        while (true){ 
            
            // henter ut en arraylist med to hashmaps som nå har blitt fjerner. 
            ArrayList<HashMap<String, Subsekvens>> toHash = monitor.hentUtTo();
            
            // sjekker om hentUtTo() har returnert null. 
            if (toHash == null){
                latch.countDown(); // forteller til main at denne traaden er ferdig. 
                System.out.println("Avslutter FletteTraad: " + id);
                return;
            }

            // Fletter sammen toHash 0 og 1, setter flettet tilbake i monitor. 
            monitor.settInnFlettet(monitor.slaaSammen(toHash.get(0), toHash.get(1)));
        }
        
    }        
}

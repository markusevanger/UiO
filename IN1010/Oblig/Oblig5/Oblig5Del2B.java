
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


class Oblig5Del2B{

    

    public static void main(String[] mappepath) throws InterruptedException{

        int antallFletteTraader = 8;

        String mappe = mappepath[0];

        CountDownLatch latch = new CountDownLatch(antallFletteTraader);

        SubsekvensRegister sr = new SubsekvensRegister();
        Monitor2 monitor = new Monitor2(sr, "ingen oppgitt type");

        ArrayList<String> alleFiler = lesMetafil(mappe);
        Thread[] alleLeseTraader = new Thread[alleFiler.size()];

        for (int i = 0; i < alleLeseTraader.length; i++){
            LeseTrad lt = new LeseTrad(alleFiler.get(i), monitor);
            alleLeseTraader[i]= new Thread(lt);
            alleLeseTraader[i].start();
        }

        for (Thread traad : alleLeseTraader){
            traad.join();
        }

        System.out.println("Fullforte aa lese " + alleLeseTraader.length + " er filer." );
        System.out.println("Antall hashmaps: " + monitor.hentStoerelse());


        
        Thread[] alleFletteTraader = new Thread[antallFletteTraader];

        for (int i = 0; i < antallFletteTraader; i++){
            FletteTrad ft = new FletteTrad(monitor, latch, i ); // i = traadens id, brukes når vi skrives til terminal. 
            alleFletteTraader[i] = new Thread(ft);
            alleFletteTraader[i].start();
        }

        latch.await();

        System.out.println("Antall hashmaps igjen: " +  monitor.hentStoerelse());
        System.out.println(monitor.hentRegister());
        System.out.println("Stoerste subsekvens: " + hentStorsteSubsekvens(monitor));

    }



        
    // les metafil og returner som itererbar ArrayList.
    public static ArrayList<String> lesMetafil(String mappe){

        boolean IGNORER_BOOLEAN = true;

        File fil = null;
        Scanner sc = null;
        ArrayList<String> filListe = new ArrayList<String>();

        String metafil = mappe + "/metadata.csv";

        try {
            fil = new File(metafil);
            sc = new Scanner(fil);
        }
        catch(FileNotFoundException e){
            System.out.println("Fant ikke filen: " + metafil);
        }

        String linje;
        while (sc.hasNextLine()){

            linje = sc.nextLine();
            
            if (IGNORER_BOOLEAN){
                linje = linje.split(",")[0];
            }
            
            linje = mappe + "/" +  linje;
            filListe.add(linje);
        }
        return filListe;
    }

    // returnerer største subsekvens i monitor.
    public static Subsekvens hentStorsteSubsekvens(Monitor2 monitor){

        Subsekvens storste = null;
        int flestForekomster = 0;

        for (HashMap<String, Subsekvens> dict : monitor.hentRegister()){
            for (String nokkel : dict.keySet()){
                Subsekvens ss = dict.get(nokkel);
                if (ss.hentAntallForekomster() > flestForekomster){
                    flestForekomster = ss.hentAntallForekomster();
                    storste = ss;
                }
                    //System.out.println(ss);
            }
        }
        return storste;
    }

    
}
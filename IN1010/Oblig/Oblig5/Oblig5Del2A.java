import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Oblig5Del2A{

    
    private static Monitor2 monitor; // opprinnelig et monitor1 objekt, men senere endret for å fungere med "morderne" kode. 
    public static void main(String[] dataMappe){

        SubsekvensRegister sR = new SubsekvensRegister();
        monitor = new Monitor2(sR, "ingen oppgitt type");
        
        ArrayList<String> alleLitenArr = lesMetafil("TestDataLitenLike/metadata.csv"); // TODO***************** La bruker velge mappe for data.
        ArrayList<String> alleStoreArr = lesMetafil("TestDataLike/metadata.csv");

        OpprettTraaderOgLesFiler("TestDataLitenLike/", alleLitenArr, monitor);
        OpprettTraaderOgLesFiler("TestDataLike/", alleStoreArr, monitor);
        //OpprettTraaderOgLesFiler("TestDataLike/", alleStoreArr, monitor);

        System.out.println("Ferdig lest.");

        flettMonitor();
        System.out.println(hentStorsteSubsekvens());
        //System.out.println(hentStorsteSubsekvens(AlleStoreHash));
    }
    

    // les metafil og returner som itererbar ArrayList.
    public static ArrayList<String> lesMetafil(String filepath){

        File fil = null;
        Scanner sc = null;
        ArrayList<String> filListe = new ArrayList<String>();

        try {
            fil = new File(filepath);
            sc = new Scanner(fil);
        }
        catch(FileNotFoundException e){
            System.out.println("Fant ikke filen: " + filepath);
        }

        while (sc.hasNextLine()){
            String linje = sc.nextLine();
            filListe.add(linje);
        }
        return filListe;
    }


    public static void OpprettTraaderOgLesFiler(String mappePath, ArrayList<String> filer, Monitor2 monitor){

        String filpath;
        String filnavn;
        Thread[] alleTraader = new Thread[filer.size()];
        for (int index = 0; index < filer.size(); index++){


            filnavn = filer.get(index);
            filpath = mappePath + filnavn;
            LeseTrad lt = new LeseTrad(filpath, monitor);
            alleTraader[index] = new Thread(lt);
            alleTraader[index].start();
        }

        for (int index = 0; index < filer.size(); index++){
            try{
                alleTraader[index].join();
            }
            catch (InterruptedException e){
                System.out.println("Klarte ikke aa joine traaden: " + index);
                System.out.println();
                System.out.println(e);
                e.printStackTrace();
            }
            
        }

        System.out.println("Leste " + filer.size() + " filer.");
        System.out.println();
    }


    public static Subsekvens hentStorsteSubsekvens(){

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
        System.out.println();
        return storste;
    }

    public static void flettMonitor(){

        ArrayList<HashMap<String, Subsekvens>> sr = monitor.hentRegister();
        HashMap<String, Subsekvens> hash1 = sr.get(0);;
        HashMap<String, Subsekvens> hash2;

        for (int index = 0; index < sr.size()-1; index++){
            hash2 = sr.get(index+1);
            monitor.slaaSammen(hash1, hash2);
        }
        System.out.println("Slo sammen " + hash1.size() + " hashmaps i monitor."); 
    } 
}
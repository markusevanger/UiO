
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

 
 class Oblig5Hele{

    // Dette programmet tar imot en mappe, eks, "Data" eller "TestData" og finner automatisk tilhørende metafil. 
    public static void main(String[] mappe) throws InterruptedException{

        int ANTALL_FLETTE_TRAADER = 8; 
        
        // ⚠️
        int DOMINANS_MARGIN = 7; // endre disse i forhold til hvilken mappe som leses. 2 = TestDataLiten, 5 = TestData, 7 = Data
        int ANT_KJORINGER = 1; // hvor mange ganger skal programmet kjøre? Ment for å sjekke trådsikkerhet.

        boolean BRUK_FASIT = false; // true = stopp programmet om output != FASIT objekt. 
        Subsekvens FASIT = new Subsekvens("RMC", 20); // Endre for å sjekke fasit. 
        
        SubsekvensRegister smittede = new SubsekvensRegister();
        SubsekvensRegister friske = new SubsekvensRegister();

        Monitor2 smittedeMonitor = new Monitor2(smittede, "smittet");
        Monitor2 friskeMonitor = new Monitor2(friske, "frisk");
        
        HashMap<String, ArrayList<String>> filerSortert = lesMetafil(mappe[0]); // tar input fra kommandolinje "Data" eller "TestDataLike"
        lesFilerSortert(filerSortert, smittedeMonitor, friskeMonitor); // leser filer og sorterer innholdet i riktig monitorer. 

        for (int i = 0; i < ANT_KJORINGER; i++){ // tester flettingen for traadsikkerhet. 

            flettMonitor(smittedeMonitor, ANTALL_FLETTE_TRAADER); 
            flettMonitor(friskeMonitor, ANTALL_FLETTE_TRAADER);

            ArrayList<Subsekvens> dominante = finnDominante(smittedeMonitor, friskeMonitor, DOMINANS_MARGIN);

            Subsekvens stoerste = dominante.get(0);
            for (Subsekvens s : dominante){
                if (s.hentAntallForekomster() > stoerste.hentAntallForekomster()){
                    stoerste = s;
                }
            }

            // printer nødvendig informasjon,
            if (BRUK_FASIT){
                System.out.print(stoerste); // om vil sammenlikne med fasit, printer vi også bare fasit. 
            } else {
                
                for (Subsekvens s : dominante){ // om ikke viser vi alle.
                    System.out.println(s);
                }
            }
            
            // stopper kjøringen om den svar ikke e
            if (!(stoerste.subsekvens.equals(FASIT.subsekvens) && stoerste.hentAntallForekomster() == FASIT.hentAntallForekomster()) && BRUK_FASIT){
                System.out.println("FASITen du oppga matchet ikke programmets output.");
                return;
            }
            else if (BRUK_FASIT) {
                System.out.println(" = FASIT (riktig)");
            }
        }
        System.out.println();
    }

    // les metafil og returner som itererbar ArrayList.
    public static HashMap<String, ArrayList<String>> lesMetafil(String mappe){

        File fil = null;
        Scanner sc = null;
        

        String metafil = mappe + "/metadata.csv";

        try {
            fil = new File(metafil);
            sc = new Scanner(fil);
        }
        catch(FileNotFoundException e){
            System.out.println("Fant ikke filen: " + metafil);
        }

        

        // hashmap med to nøkler "true" eller "false"
        HashMap<String, ArrayList<String>> listerAvFiler = new HashMap<String, ArrayList<String>>();

        ArrayList<String> alleSmittede = new ArrayList<String>();
        ArrayList<String> alleFriske = new ArrayList<String>();

        listerAvFiler.put("True" , alleSmittede);
        listerAvFiler.put("False", alleFriske);

        String smittet;
        while (sc.hasNextLine()){

            String[] linje = sc.nextLine().split(",");
            String filpath = mappe + "/" +  linje[0];
            try{
                smittet = linje[1];
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Fant ikke en true eller false. Flagger som frisk.");
                smittet = "False";

            }

            listerAvFiler.get(smittet).add(filpath);
        }
        return listerAvFiler;
    }
    
    // les alle filer og legg inn i tilsvarende monitor.
    public static void lesFilerSortert(HashMap<String, ArrayList<String>> filerSortert, Monitor2 smittedeMonitor, Monitor2 friskeMonitor) throws InterruptedException{
        String filpath;
        LeseTrad lt;
        
        for (String smittetStatus : filerSortert.keySet()){ // {smittede : ArrayList , friske : ArrayList}

            Thread[] alleLeseTraader = new Thread[filerSortert.get(smittetStatus).size()];
            for (int i = 0; i < filerSortert.get(smittetStatus).size(); i++){

                filpath = filerSortert.get(smittetStatus).get(i);
                
                if (smittetStatus == "True"){
                    lt = new LeseTrad(filpath, smittedeMonitor);
                }
                else {
                    lt = new LeseTrad(filpath, friskeMonitor);
                }
                
                alleLeseTraader[i] = new Thread(lt);
                alleLeseTraader[i].start();  
      
            }

            for (Thread traad : alleLeseTraader){
                traad.join();
            }

            System.out.println("Lest ferdig alle filer som er flagget: " + smittetStatus);
            System.out.println();
        }
        // System.out.println("Antall smittede: " + smittedeMonitor.hentStoerelse());
        // System.out.println("Antall friske: " + friskeMonitor.hentStoerelse());
    }

    // fletter alle hash i oppgitt monitor med N antall traader. 
    public static void flettMonitor(Monitor2 monitor, int antallFletteTraader) throws InterruptedException{

        Thread[] alleFletteTraader = new Thread[antallFletteTraader];
        CountDownLatch latch = new CountDownLatch(antallFletteTraader);

        for (int i = 0; i < antallFletteTraader; i++){
            FletteTrad ft = new FletteTrad(monitor, latch, i); // i = traadens id, brukes når vi skrives til terminal. 
            alleFletteTraader[i] = new Thread(ft);
            alleFletteTraader[i].start();
        }

        latch.await();
        System.out.println("Ferdig aa lese monitor flagget som: " + monitor);
        System.out.println();

        // System.out.println("Antall hashmaps igjen: " +  monitor.hentStoerelse());
        // System.out.println("Stoerste subsekvens i " + monitor + ": " + hentStorsteSubsekvens(monitor));

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

    // Finner subsekvenser som forekommer N ganger mer i smittede enn i friske ...
    public static ArrayList<Subsekvens> finnDominante(Monitor2 smittedeMonitor, Monitor2 friskeMonitor, int dominans_margin){

        ArrayList<Subsekvens> dominante = new ArrayList<Subsekvens>();

        HashMap<String, Subsekvens> smittedeHash = smittedeMonitor.hentRegister().get(0);
        HashMap<String, Subsekvens> friskeHash = friskeMonitor.hentRegister().get(0);

        // 
        for (String subsekvens : smittedeHash.keySet()){
            Subsekvens subsekvensObj = smittedeHash.get(subsekvens);

            if (friskeHash.get(subsekvens) != null){
                if (subsekvensObj.hentAntallForekomster() >= friskeHash.get(subsekvens).hentAntallForekomster() + dominans_margin){
                    dominante.add(subsekvensObj);
                }
            }
            // oppstår kun i smittede:
            else if (subsekvensObj.hentAntallForekomster() >= dominans_margin){
                dominante.add(subsekvensObj);
            }
        }
        return dominante;

    }

}
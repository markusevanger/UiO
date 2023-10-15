

class Kontroller implements Runnable{

    private Rutenett rutenett;
    private GameOfLifeGUI gui;

    private int venteTid;

    public static void main(String[] args) {
        Kontroller kontroller = new Kontroller();
    }

    public Kontroller(){

        System.out.println("*********** NYTT SPILL I GANG****************");

        int rader = 25; // høyde
        int kolonner = 25; // bredde
        venteTid = 2000; // start tid mellom generasjoner;

        rutenett = new Rutenett(rader, kolonner);
        gui = new GameOfLifeGUI(rutenett, this); // oppretter et vindu objekt med referanse til kontrolleren. 
        
        // MVC ""tegning""
       
        // gui <=> kontroller -> Rutenett
       
        // ^view
        //        ^Controller    
        //                      ^model

    }

    // Oppdaterer en spesifisert celle, brukt til å endre cellen bruker trykker på i GUI.
    public void oppdaterCelle(int rad, int kol){
        rutenett.hentCelle(rad, kol).toggleStatus();
        rutenett.telleAlleNaboer(); // må dermed også telle alle naboer om igjen.
        gui.tegnRutenett(); // tegner rutenettet om igjen. Pga "random" farge implementasjonen endrer ruter fargen sin hver gang de blir trykket.

        System.out.println("Antall Levende: " + rutenett.tellLevendeCeller());
        rutenett.skrivTilTerminal(); // skriver også ut oppdatert rutenett til terminal
    }

    public void fyllRutenettTilfeldig(int sjanse){
        rutenett.fyllMedTilfeldigeCeller(sjanse); 
        gui.tegnRutenett();
    }

    // Oppdatere rutenett Traad.
    public void run(){

        while (true){

            System.out.println("Generasjon nr: " + rutenett.hentGenerasjon() + ", Antall Levende: " + rutenett.tellLevendeCeller());
            rutenett.oppdaterStatus();
            gui.tegnRutenett();
            rutenett.skrivTilTerminal();

            try{Thread.sleep(venteTid);}
            catch(InterruptedException e){break;} // blir Interrupted ved at bruker trykker på stopp knappen
        }
    }

    // disse funksjonene endrer tiden mellom hver generasjon. 
    public void endreTid(int nyTid){
        venteTid = nyTid;
    }

    public int hentTid(){
        return venteTid;
    }

    public int hentGenerasjon(){
        return rutenett.hentGenerasjon();
    }
}
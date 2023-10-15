public class RutenettTest {


    public static void main(String[] args) {
        
        Rutenett rtnt = new Rutenett(10, 10);

        rtnt.fyllMedTilfeldigeCeller(80);

        while (true){
            try{
                Thread.sleep(250);
           }
           catch (InterruptedException e){}

           rtnt.skrivTilTerminal();
           rtnt.oppdaterStatus();

        }
    }
    
}

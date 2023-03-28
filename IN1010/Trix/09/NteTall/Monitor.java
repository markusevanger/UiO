public class Monitor{

    static int teller = 0;
    public Monitor(int tall, int threadId){

        // sjekk hele tiden. Static teller kan bli oppdatert til == tall.
        while (true){

            // Om teller == tall, altså din tur i koen:
            if (teller == tall){
                System.out.println("Tall: " + tall + " fra thread: " + threadId); // print ut ditt tall
                teller++; // oek teller med en, ditt tall er ferdig. 
                return; // avlsutt metoden/konstruktoren.
            }

            // om ikke, vent litt. Stopper static teller fra aa bli overbelastet...
            else{
                try{
                    Thread.sleep(1); // 1 millisekund.
                }
                catch(Exception e){ // maa ha try catch for Thread.sleep()
                    System.out.println(e);
                }
                
            }
        }
    }
}
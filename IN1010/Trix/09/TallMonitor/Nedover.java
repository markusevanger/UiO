class Nedover implements Runnable{

    int startTall = 0;
    Monitor mon;
    public Nedover(Monitor mon){
        startTall = Integer.MAX_VALUE;
        this.mon = mon;

    }

    public void run(){

        while (true){
            if (mon.settStorste(startTall)){
                startTall--;
                System.out.println(startTall);
            }
            else {
                System.out.println("Klarte ikke aa sette storste, " + mon.detStorste + " =< " + mon.detMinste);
                return;
            }
        }
    }
}
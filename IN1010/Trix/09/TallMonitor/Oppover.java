class Oppover implements Runnable{

    int startTall = 0;
    Monitor mon;
    private static int idTeller;
    private final int id;
    public Oppover(Monitor mon){
        startTall = Integer.MIN_VALUE;
        this.mon = mon;
        id = idTeller;
        idTeller++;

    }

    public void run(){

        System.out.println("Opprettet ny Traad med id: " + id);

        while (true){

            if (mon.settMinste(startTall)){
                startTall++;
                System.out.println(startTall);
            }
            else {
                System.out.println("Klarte ikke aa sette minste: " + mon.toString());
                return;
            }
        }
    }
}
class Kjor{


    public static void main(String[] args){

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        Monitor mon = new Monitor(min, max);

        Oppover opp = new Oppover(mon);
        Nedover ned = new Nedover(mon);

        Thread oppover = new Thread(opp);
        Thread nedover = new Thread(ned);
        oppover.start();
        nedover.start();

    }
}
public class Teller implements Runnable{

    private int n;
    private int max;

    public Teller(int n, int max){
        this.n = n;
        this.max = max;
    }

    public void run(){
        for (int i = n; i < 1000; i+=10){
            System.out.println(i);
        }
    }
}
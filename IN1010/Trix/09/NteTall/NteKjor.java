

public class NteKjor{

    public static void main(String[] args){
        //todo   

        for (int i = 0; i < 10; i++){
            Teller teller = new Teller(i, 10000);
            Thread traad = new Thread(teller);
            traad.start();
        }
    }
}
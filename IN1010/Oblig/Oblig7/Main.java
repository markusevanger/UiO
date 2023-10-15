import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filnavn = args[0];
        //String filnavn = "labyrinter/1.in";
        Labyrint lab = new Labyrint(filnavn);
        // System.out.println(lab);



        Scanner sc = new Scanner(System.in);
        boolean ferdig = false;

        while (!ferdig){

            System.out.println(lab);
            
            System.out.println();
            
            System.out.println("Skriv inn start rute. <rad>, <kol>");
            System.out.println("eks: 3, 4");
            System.out.print(">> "); 
    
            String[] input = sc.nextLine().split(" ");
            System.out.println(lab);

            if (input[0].equals("-1")){
            }
            else{

                tomTerminal();
                
                try{
                    int rad = Integer.parseInt(input[0].replace(",", ""));
                    int kol = Integer.parseInt(input[1]);
                    
                    lab.finnUtveiFra(rad, kol);
                    lab.printRuter(); // skriv ut leterutene.


                    System.out.println("Ønsker du å spille en runde til?");
                    System.out.println("NEI = 0, JA = ENTER");
                    System.out.println();
                    System.out.print(">>");
    
                    input = sc.nextLine().split(" ");
                    if (input[0].equals("0")){
                        ferdig = true;
                    }

                    tomTerminal();
                    

                }
                catch(NumberFormatException e){
                    System.out.println("Du oppga ikke kordinater! Vensligst proev igjen:");
                }
                catch(IndexOutOfBoundsException a){
                    System.out.println("Du oppga kordinater utenfor kordinat systemet!");
                }
                
            }
        }
        sc.close();
        System.out.println("Avslutter programmet.");
    }


     public static void tomTerminal(){
        for (int i = 0; i < 50; i++){
            System.out.println();
        }
    }

}

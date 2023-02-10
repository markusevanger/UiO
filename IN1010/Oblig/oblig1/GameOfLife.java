import java.util.Scanner;


class GameOfLife {

    

    
    public static void main(String[] args) {


        for (int i=0; i < 50; i++){
            System.out.println(" ");

        }

        System.out.println("Velkommen til Game of Life Java Edition!");
        System.out.println("");
        System.out.println("");

        System.out.println("Skriv hvor mange rader du vil at rutenettet skal vaere."); // Henter input fra bruker 
        Scanner rader = new Scanner(System.in);
        String rad_str = rader.nextLine();

        System.out.println("Skriv hvor mange kolonner du vil at rutenettet skal vaere."); // Henter input fra bruker 
        Scanner kolonner = new Scanner(System.in);
        String kol_str = kolonner.nextLine();

        int rad = Integer.parseInt(rad_str); // gjør om til int
        int kol = Integer.parseInt(kol_str);


        Verden verden = new Verden(rad, kol); // sender input og oppretter nytt Verden objekt 
        verden.tegn(); // tegner verden en gang.


        System.out.println(" ");
        String svar = "";

        while (svar == ""){ // while loop som kjører så lenge bruker svar er Enter
        
        Scanner input = new Scanner(System.in);
        System.out.println("Trykk enter for aa fortsette"); // ber om ny input. 
        svar = input.nextLine();


        verden.oppdatering(); // kjører nødvendige metoder for å oppdatere og represtenere rutenettet.
        verden.tegn();

        

        }
    }
}
import java.util.HashMap;
import java.util.Scanner;




class Telefonbok {


  public static void main(String[] args) {

    HashMap<String, String> bok = new HashMap<String, String>();

    bok.put("Arne", "22334455");
    bok.put("Lisa", "95959595");
    bok.put("Jonas", "97959795");
    bok.put("Peder", "12345678");




    System.out.println(" ");
    for (String i : bok.keySet()) {
        System.out.println(i);
   
    
    } 
    System.out.println(" ");


    Scanner input = new Scanner(System.in);
    System.out.println("Skriv inn ett av navnene i telefonboken: ");
    String str_inp = input.nextLine();



    System.out.println(" ");
    System.out.println("Telefon nummeret til " + str_inp + " er: " + bok.get(str_inp));




    
  }  
}
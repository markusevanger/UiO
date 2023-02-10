import java.util.Scanner;

class Differanse {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Skriv verdien av x: ");

        String str_x = input.nextLine();
        int x = Integer.parseInt(str_x);

        input = new Scanner(System.in);
        System.out.println("Skriv verdien av y: ");

        String str_y = input.nextLine();
        int y = Integer.parseInt(str_y);


        if (x > y) {
            System.out.println("Differanse mellom x og y er " + (x-y));
        } else {
            System.out.println("Differanse mellom y og x er " + (y-x));
        }

        
    }
}
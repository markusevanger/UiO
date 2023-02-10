import java.util.Scanner; 


class MindreStorre {


    public static void main(String[] args){

        Boolean fortsett = true;

        while (fortsett){
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv verdien av x: ");

        String str_x = input.nextLine();

        if (str_x == "stop" ) {
            fortsett = false;
            break;
        }


        int x = Integer.parseInt(str_x);

        if (x > 10 && x < 20){
            System.out.println("Tallet er mellom 10 og 20");
        } else {
            System.out.println("Tallet er ikke mellom 10 og 20");
        }
        }

    }
}
class Divisor{

    public static void main(String[] args){

        int a = 525;
        int b = 13;

        System.out.println("Rekursjonsmetode: " + gcd(a, b));
        System.out.println("Iterativmetode: " + gcdIterativ(a, b));
    }

    // Rekursiv metode for å regne ut største felles divisor. 
    public static int gcd(int a, int b){

        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }

        int c = a % b;

        if (c == 0) {
            return b;
        } else {
            return gcd(b, c);
        }
        

    }

    // Iterativ metode å regne ut største felles divisor.
    public static int gcdIterativ(int a, int b){

        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }

        int c = a % b;

        while (c != 0) {
            a = b;
            b = c;

            c = a % b;
        }

        return b;
    }
}
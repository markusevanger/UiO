public class Bil3 {
    

    public static void main(String[] args) {

        String reg_nr = "AB12345"; // String skrives med stor bokstav pga er et  objekt... int skrives med liten, fordi det er en "primitiv" datatype...
        hentNummer(reg_nr); // <---- argument

    }

    public static void _skriv() {

        System.out.println("Jeg er en bil");
    } 

    public static void hentNummer(String nr) { // <---- parameter
        System.out.println(nr);
    }
}

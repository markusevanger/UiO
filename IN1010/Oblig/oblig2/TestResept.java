class TestResept {

    private static int id_legemidler = 0;
    private static int id_resepter = 0;
    private static int id_pasient = 0;

    public static void main(String[] args) {

        // opprette Legemiddler. 

        Narkotisk  narko = new Narkotisk("Tylenol", 10, 11.11, id_legemidler, 5);
        id_legemidler++;

        Vanedannende vane = new Vanedannende("Nesespray", 20, 22.22, id_legemidler, 2);
        id_legemidler++;
        
        Vanlig vanlig = new Vanlig("Paracet", 30, 33.33, id_legemidler);
        id_legemidler++;


        // opprette Lege (for å få kode til å kjøre)

        Lege eksempel_lege = new Lege();


        // opprette resepter
        Presp p_resept = new Presp(id_resepter, narko, eksempel_lege, id_pasient, 10);
        id_resepter++;
        id_pasient++;

        MilResept mil_resept = new MilResept(id_resepter, vane, eksempel_lege, id_pasient); // uten reit. mil_resept.
        id_resepter++;
        id_pasient++;

        Hvit hvit_resept = new Hvit(id_resepter, vanlig, eksempel_lege, id_pasient, 2);
        id_resepter++;
        id_pasient++;

        Blaa blaa_resept = new Blaa(id_resepter, narko, eksempel_lege, id_pasient, 1);
        id_resepter++;
        id_pasient++;



        // teste objektene:

        Resept[] arr = {p_resept, mil_resept, hvit_resept, blaa_resept};
        System.out.println("**********************************");

        for (Resept r : arr) {

            System.out.println("");
            System.out.println("Resept til pasient ID: " + r.hentPasientID());
            System.out.println("Har farge: " + r.farge());
            System.out.println("Utskrevet av lege: " + r.hentLege());
            System.out.println("");
            System.out.println("Antall reit gjenstående: " + r.hentReit());
            System.out.println("Pris: " + r.prisAaBetale());
            System.out.println("");
            System.out.println("**********************************");

        }
    
    }
}
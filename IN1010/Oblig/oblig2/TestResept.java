class TestResept {


    public static void main(String[] args) {

        // opprette Legemiddler. 

        Narkotisk  narko = new Narkotisk("Tylenol", 10, 11.11, 5);
        Vanedannende vane = new Vanedannende("Nesespray", 20, 22.22, 2);
        Vanlig vanlig = new Vanlig("Paracet", 30, 33.33);


        // opprette Lege (for å få kode til å kjøre)

        Lege eksempel_lege = new Lege("Emil");


        // opprette resepter
        Presp p_resept = new Presp(narko, eksempel_lege, 1, 10);
        MilResept mil_resept = new MilResept(vane, eksempel_lege, 2); // uten reit. mil_resept.
        Hvit hvit_resept = new Hvit(vanlig, eksempel_lege, 3, 2);
        Blaa blaa_resept = new Blaa(narko, eksempel_lege, 4, 1);


        // teste objektene:

        Resept[] arr = {p_resept, mil_resept, hvit_resept, blaa_resept};
        System.out.println("");
        System.out.println("**********************************");

        for (Resept r : arr) {

            System.out.println("");
            System.out.println("Resept til pasient ID: " + r.hentPasientID());
            System.out.println("Har farge: " + r.farge());
            System.out.println("Utskrevet av lege: " + r.hentLege());
            System.out.println("");
            System.out.println("Antall reit gjenstående: " + r.hentReit());
            System.out.println("Pris: " + r.prisAaBetale());
            System.out.println("Resept ID: " + r.hentId());
            System.out.println("");
            System.out.println("**********************************");

        }
    
    }
}
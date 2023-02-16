class Hovedprogram {


    public static void main(String[] args) {

        // opprette Legemiddler. 

        Narkotisk  narko = new Narkotisk("Tylenol", 350, 11.11, 5);
        Vanlig vanlig = new Vanlig("Paracet", 50, 5.55);


        // opprette Lege (for å få kode til å kjøre)

        Lege lege = new Lege("Emil");
        Spesialist Spesialist = new Spesialist("Marius", "kontrollkode_2");


        // opprette resepter
        Presp p_resept = new Presp(vanlig, lege, 1, 10);
        MilResept mil_resept = new MilResept(narko, Spesialist, 2);


        // teste objektene:

        Resept[] arr = {p_resept, mil_resept};
        System.out.println("**********************************");

        for (Resept r : arr) {

            System.out.println("");
            System.out.println("Resept til pasient ID: " + r.hentPasientID());
            System.out.println("Medisin navn: " + r.hentLegemiddel());
            System.out.println("");
            System.out.println("Har farge: " + r.farge());
            System.out.println("Utskrevet av lege: " + r.hentLege());
            System.out.println("Lege har godkjenningsfritak: " + (r.hentLege() instanceof Godkjenningsfritak));
            System.out.println("");
            System.out.println("Antall reit gjenstående: " + r.hentReit());
            System.out.println("Pris: " + r.prisAaBetale());
            System.out.println("Resept ID: " + r.hentId());
            System.out.println("");
            System.out.println("**********************************");

        }
        

    }
}
class Bil {


    String eieren;
    String merket;

    public Bil(String eier, String merke) {

        eieren = eier;
        merket = merke; 

        System.out.println("Bilen av merket " + merket + " er oprettet.");
    }

    public void skriv() {

        System.out.println("Her er bilens eier: " + eieren);
        System.out.println("Her er bilens merke: " + merket);


    }
}
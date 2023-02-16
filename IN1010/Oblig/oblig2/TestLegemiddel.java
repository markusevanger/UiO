class TestLegemiddel {

    


    public static void main(String[] args) {


        // String navn, int pris, double virkestoff

        Narkotisk narko = new Narkotisk("Tylenol", 10, 11.11, 5);
        Vanedannende vane = new Vanedannende("Nesespray", 20, 22.22, 2);
        Vanlig vanlig = new Vanlig("Paracet", 30, 33.33);

        Legemiddel[] arr = new Legemiddel[3];

        arr[0] = narko;
        arr[1] = vane;
        arr[2] = vanlig;

        for (Legemiddel ob : arr) {

            System.out.println("");
            System.out.println("Her er info om: " + ob.navn);
            System.out.println("Nåværende pris: " + ob.hentPris());
            ob.settNyPris(ob.hentPris()*2);
            System.out.println("Pris etter 100% prisøkning: " + ob.hentPris());
            System.out.println("Virkestoff: " + ob.virkestoff);
            System.out.println("ID: " + ob.id);
            
        }


    }
}
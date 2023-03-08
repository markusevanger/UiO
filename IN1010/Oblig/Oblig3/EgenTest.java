class EgenTest {


    public static void main(String[] args){


        Stabel<String> k = new Stabel<String>();

        System.out.println(k.stoerrelse());
        System.out.println(k.toString());

        k.leggTil("Anne");
        System.out.println(k.stoerrelse());
        System.out.println(k.toString());

        k.leggTil("Berit");
        System.out.println(k.stoerrelse());
        System.out.println(k.toString());

        k.leggTil("Chris");
        System.out.println(k.stoerrelse());
        System.out.println(k.toString());

        k.fjern();
        System.out.println(k.stoerrelse());
        System.out.println(k.toString());

        k.fjern();
        System.out.println(k.stoerrelse());
        System.out.println(k.toString());

        k.fjern();
        System.out.println(k.stoerrelse());
        System.out.println(k.toString());

}

}
class Person {

    String navnet;
    int alderen;

    public Person(String navn, int alder) {

        navnet = navn;
        alderen = alder;
    }


    public void skriv(){

        System.out.println(navnet + alderen);
    }



    public static void main(String[] args) {

        Person pers = new Person("Markus", 19);
        pers.skriv();
    }
}

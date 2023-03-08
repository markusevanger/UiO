class EgenTest<E extends Comparable<E>> {


       public static void main(String[] args){

              Prioritetskoe<String> k = new Prioritetskoe<String>();

              k.settInn("B");
              System.out.println(k.toString());
              System.out.println(k.stoerrelse());

              k.settInn("A");
              System.out.println(k.toString());
              System.out.println(k.stoerrelse());


              k.fjern();
              System.out.println(k.hent());
              System.out.println(k.toString());
              System.out.println(k.stoerrelse());

       }
}


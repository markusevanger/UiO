class EgenTest<E extends Comparable<E>> {


       public static void main(String[] args){

              //Prioritetskoe<String> k = new Prioritetskoe<String>();


              	Prioritetskoe<String> k = new Prioritetskoe<String>();
	              k.leggTil("B");
	              k.leggTil("D");  
	              k.leggTil("C");  
	              k.leggTil("A");
	              k.leggTil("Z"); 
	              k.leggTil("X");
	              System.out.println(k.toString());
	              System.out.println(k.hent());
	              k.fjern();
	              String h1 = k.hent();
	              if (h1.equals("B")) {
	                  System.out.println("OK");
              
              // k.settInn("B");
              // System.out.println(k.toString());
              // k.settInn("D");
              // System.out.println(k.toString());
              // k.settInn("C");
              // System.out.println(k.toString());
              // k.settInn("A");
              // System.out.println(k.toString());
              // k.settInn("Z");
              // System.out.println(k.toString()); 
              // k.settInn("X");
              // System.out.println(k.toString());
// 
// 

             // k.fjern();
             // System.out.println(k.hent());
             // System.out.println(k.toString());
              

       }
}
}


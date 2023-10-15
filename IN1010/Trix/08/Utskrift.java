class Utskrift {

    public static void main(String[] args){

        rekursivUtskrift(1);
    }

    public static void rekursivUtskrift(int i){

        if ( i == 10){
            System.out.println(i); // avslutter metode kallene. 10 = tallet vi avlsutter på. 
        }
        else{
            System.out.println(i);
            rekursivUtskrift(i + 1);
        }
    }
}
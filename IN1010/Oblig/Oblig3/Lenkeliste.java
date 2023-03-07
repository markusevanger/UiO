abstract class Lenkeliste<E> implements Liste<E>{



    protected Node start_node = new Node(null);


    public int stoerrelse(){ // returner antall lenkete objekter. 

        int teller = 0;
        Node peker_node = start_node;
        while (peker_node.element != null ){
            peker_node = peker_node.neste;
            teller++;
        }
        return teller;
    } 

    public void leggTil(E x){ // leggTil objekt på slutten

        Node peker_node = start_node;
        Node nyNode = new Node(x);

        while (peker_node.neste != null ){ // finer siste node uten null verdi. 
            peker_node = peker_node.neste;
        }

        peker_node.neste = nyNode; // lenker siste node med innhold til den nye noden.
        nyNode.forrige = peker_node; // lenker den nye noden til den forrige. 
    } 

    public E hent(){  // returnerer elementet fra den første noden.
        return start_node.element;
    } 

    public E fjern(){ // fjern element fra lenket liste
    
        Node slettet_node = start_node;

        
        if (start_node.element != null){

        start_node = start_node.neste;
        start_node.forrige = null;
        return slettet_node.element;
        }

        else {
            throw new UgyldigListeindeks(0);
        }
    } 
    
    public String toString(){ //skriv ut String

        String svar = "";
        Node peker_node = start_node;

        while (peker_node.element != null){
            svar += peker_node.element;
            svar += ", ";
        }

        return svar;


    } 



    // container
 
    class Node{

        protected Node neste = null; // må peke til et nytt node objekt
        protected Node forrige = null;
        protected E element;
        
        public Node(E element){ //konstruktør Node
            this.element = element;
        }
    }
}
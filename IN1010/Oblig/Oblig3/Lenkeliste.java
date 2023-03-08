abstract class Lenkeliste<E> implements Liste<E>{



    protected Node start_node;


    public int stoerrelse(){ // returner antall lenkete objekter. 

        int teller = 0; 
        boolean kjort = false;
        Node peker_node = start_node;


        while (peker_node != null){
            teller++;
            if (peker_node.neste != null){
                peker_node = peker_node.neste;
            }
            else {break;}


        }
        return teller;


    }


    public void leggTil(E x){ // leggTil objekt på slutten

        Node nyNode = new Node(x);

        if (start_node == null){
            start_node = nyNode;
            return;
        }

        Node peker_node = start_node;

        if (peker_node.neste == null){
            peker_node.neste = nyNode;
            return;
        }

        
        while (peker_node.neste != null){
            peker_node = peker_node.neste;
        }

        peker_node.neste = nyNode;

    } 


    public E hent(){  // returnerer elementet fra den første noden.
        return start_node.element;
    } 


    public E fjern(){ // fjern element fra lenket liste
    
        Node slettet_node = start_node;

        if (start_node == null){
            throw new UgyldigListeindeks(0);
        }

        // om noden ikke er eneste node med innhold ... 
        if (start_node.neste != null && start_node.element != null){ 

            start_node = start_node.neste;
            start_node.forrige = null;
            return slettet_node.element;
        }

        // om noden ikke er selv mangler innhold, alstå lenkelisten ikke er tom.
        else{
            start_node = null; // setter hele objektet til null
            return slettet_node.element;
        }

        // Konklusjon: du prøver å fjerne fra en tom Lenkeliste.

    }

    public String toString(){ //skriv ut String

        String svar = "";
        Node peker_node = start_node;

        while (peker_node != null){

            

            svar = svar + peker_node.element;
            svar = svar + ", ";

            peker_node = peker_node.neste;

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
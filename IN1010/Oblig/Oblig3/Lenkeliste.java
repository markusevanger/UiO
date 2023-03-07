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

    public void leggTil(E element){ // leggTil objekt på slutten

        Node peker_node = start_node;
        Node nyNode = new Node(element);
        while (peker_node.element != null ){
            peker_node = peker_node.neste;
        }
        peker_node = nyNode;
    } 

    public E hent(){  // returnerer elementet fra den første noden.
        return start_node.element;
    } 

    public E fjern(){ // fjern element fra lenket liste

    } 
    //public String toString(){} //skriv ut String



    // container
    class Node<E>{


        protected Node neste = null;
        protected Node forrige = null;
        protected E element;

        public Node(E element){ //konstruktør Node
            this.element = element;
        }
    }
}
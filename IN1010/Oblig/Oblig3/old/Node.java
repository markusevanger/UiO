class Node<E> {

    public Node nesteElement;
    public E element;
    public int indeks;

    public static int teller = 0;
    



    public Node(E element){

        this.element = element;

        indeks = teller; 
        this.teller++;

        this.nesteElement = null;

    }

    public int hentIndeks(){
        return indeks;
    }
    
    public E hentElement(){
        return element;
    }

    public Node hentNeste(){
        return nesteElement;
    }

    public void settNeste(E nyttElement){
        
        Node neste = new Node(nyttElement);
        nesteElement = neste;

    }

    public void byttElement(E nyttElement){
        element = nyttElement;
    }
}
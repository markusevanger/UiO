

// LENKELISTE KODE:

abstract class Lenkeliste <E> implements Liste<E> {

    private int stoerrelse;
    private E element;
    private Node forste;
    

    public Lenkeliste(){

        forste = new Node(null);
        
    }


    public void leggTil(E element){

        if (forste.hentElement() == null){
            forste.byttElement(element);
        }
        else {
            forste.settNeste(element);
        }

    }

    public int stoerrelse(){
        return (forste.hentLenkeStorrelse()-1);
    }
}





// NODE KODE


class Node<E> {

    public Node nesteElement;
    public E element;
    public int indeks;

    public static int teller = 0;
    



    public Node(E element){

        this.element = element;

        indeks = teller; 
        teller++;

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

    public int hentLenkeStorrelse(){
        return teller;
    }

    public void settNeste(E nyttElement){
        
        Node neste = new Node(nyttElement);
        nesteElement = neste;

    }

    public void byttElement(E nyttElement){
        element = nyttElement;
    }
}

// opprette Node objekt ...
// node objekt peker til new node objekt ...
// peker til neste

// node holder tall, indeks
// if node.hentIndeks == indeks, return node.hentElement
// else: node = node

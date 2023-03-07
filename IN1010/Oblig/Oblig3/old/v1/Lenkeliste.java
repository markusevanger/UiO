

// LENKELISTE KODE:

abstract class Lenkeliste <E> implements Liste<E> {

    private int stoerrelse;
    private E element;
    private Node forste;
    private Node neste;
    

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

    // finner lengden av "lenken"
    public int stoerrelse(){
        

        //
        // når Lenkeliste blir opprettet blir teller satt til en, selv om listen egentlig er tom.
        // dermed if sjekkes det om elementet i listen ikke er null. Ellers er teller riktig. 
        //
        if (forste.hentLenkeStorrelse() == 1){

            if (forste.hentElement() != null){
                return 1;
            }
            return 0;
        }
        
        return (forste.hentLenkeStorrelse()-1); // kompenserer for at teller økes av konstruktøren til Node.
    }

    public E hent(int indeks){


        for (int i = 0; i<forste.hentLenkeStorrelse(); i++){

            if (forste.hentIndeks() == indeks){
                return forste.hentElement();
            }

            if (i == 0){
                neste = forste.hentNeste();
            }


            if (neste.hentIndeks() == indeks){
                return neste.hentElement();
            }
            else {
                neste = neste.hentNeste();
            }
        }
    }



}





// NODE KODE


class Node<E> {

    public Node nesteElement;
    public E element;
    public int indeks;

    private static int teller = 0;
    



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

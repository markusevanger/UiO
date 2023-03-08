class Stabel <E> extends Lenkeliste<E> {

    public void leggTil(E x){ // leggTil objekt på starten
        
        
        
        Node nyNode = new Node(x);

        if (start_node == null){
            start_node = nyNode;
            return;
        }


        Node peker_node = start_node;

        nyNode.neste = start_node;
        nyNode.neste.forrige = nyNode;
        start_node = nyNode;

    } 
}
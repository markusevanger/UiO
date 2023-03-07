class Stabel <E> extends Lenkeliste<E> {

      public void leggTil(E x){ // leggTil objekt på slutten

        Node peker_node = start_node;
        Node nyNode = new Node(x);

        while (peker_node.element != null ){
            peker_node = peker_node.neste;
        }
        peker_node = nyNode;
    } 
}
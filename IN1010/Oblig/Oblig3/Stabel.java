class Stabel <E> extends Lenkeliste<E> {

    public void leggTil(E x){ // leggTil objekt på slutten

        Node nyNode = new Node(x);
        nyNode.neste = start_node;
        start_node.forrige = nyNode;
        start_node = nyNode;
    } 
}
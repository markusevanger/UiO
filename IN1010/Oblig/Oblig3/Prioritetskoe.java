class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E>{

    public void leggTil(E x){

        Node nyNode = new Node(x);
        Node peker_node = start_node;

        // sjekk om listen er helt tom;
        if (stoerrelse() == 0){
            start_node = nyNode;
            return;
        }

        while (true){
 
            int resultat = nyNode.element.compareTo(peker_node.element);
            if (resultat <= -1){
                
                if (peker_node.forrige != null){
                    nyNode.forrige = peker_node.forrige;
                    peker_node.forrige.neste = nyNode;

                    nyNode.neste = peker_node;
                    peker_node.forrige = nyNode;
                    return;
                }
                    nyNode.neste = peker_node;
                    peker_node.forrige = nyNode;
                    start_node = nyNode;
                    return;
            }

            // Slutten av køen. Legger bare til.
            else if (peker_node.neste == null){
                nyNode.forrige = peker_node;
                peker_node.neste = nyNode;
                return;

            }

            else if (resultat >= 0) {
                    peker_node = peker_node.neste;
            }

            
        }
    }
}
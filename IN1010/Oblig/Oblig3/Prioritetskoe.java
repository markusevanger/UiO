class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E>{

    
    public void settInn(E x){

        Node nyNode = new Node(x);
        Node storreNode = start_node;

        // sjekk om listen er helt tom;
        if (start_node == null){
            start_node = nyNode;
            return;
        }

        // sjekk om bare et element i listen;
        if (start_node.neste == null){
            
            // om a er viktigere enn b:
            if (nyNode.element.compareTo(storreNode.element) == 1){
                nyNode.neste = storreNode;
                storreNode.forrige = nyNode;
                start_node = nyNode;
            
            // om b er viktigere eller lik a:
            }
            else {
                nyNode.forrige = storreNode;
                storreNode.neste = nyNode;
                start_node = storreNode;
            }

            return;
        }

        while (true){
            // kommet til enden av køen.
            if (storreNode.neste == null){
                storreNode.neste = nyNode;
                nyNode.forrige = storreNode;
                return;
            }

            // b er viktigere enn a
            else if (nyNode.element.compareTo(storreNode.neste.element) == -1){
                storreNode = storreNode.neste;

                nyNode.neste = storreNode;
                nyNode.forrige = storreNode.forrige;
                
                if (storreNode.forrige != null){
                    storreNode.forrige.neste = nyNode;
                    storreNode.forrige = nyNode;
                    return;
                }
                storreNode.forrige = nyNode;
                start_node = nyNode;
                return;
            }
            // a er viktigere enn b
            else {
                storreNode = storreNode.neste;
            }
        }
    }






}
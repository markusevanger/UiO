class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E>{

    
    public void leggTil(E x){

        Node nyNode = new Node(x);
        Node storreNode = start_node;

        // sjekk om listen er helt tom;
        if (start_node == null){
            start_node = nyNode;
            return;
        }

        // sjekk om bare et element i listen;
        if (start_node.neste == null){
            
            // om nyNode er viktigere enn forsteElement:
            if (nyNode.element.compareTo(start_node.element) <= -1){
                System.out.println("nyNode: " + nyNode.element + " er viktigere enn " + start_node.element);
                nyNode.neste = start_node;
                start_node.forrige = nyNode;
                start_node = nyNode;
            
            // om b er viktigere eller lik a:
            }
            else {
                System.out.println("nyNode: " + nyNode.element + " er IKKE viktigere enn " + start_node.element);
                nyNode.forrige = storreNode;
                storreNode.neste = nyNode;
            }

            return;
        }

        while (true){
            // kommet til enden av køen.
            if (storreNode == null){
                System.out.println("enden av koen: " + nyNode.element);
                System.out.println(nyNode.element + " er ikke viktigere enn " + storreNode.element);
                storreNode.neste = nyNode;
                nyNode.forrige = storreNode;
                return;
            }

            // a er viktigere enn b
            System.out.println("Sammenlikner " + nyNode.element + " med " + storreNode.element);
            System.out.println("Resultat = " + (nyNode.element.compareTo(storreNode.element)));
            if (nyNode.element.compareTo(storreNode.element) <= -1){
                System.out.println(nyNode.element + " er viktigere enn " + storreNode.element);

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
            // a er ikke viktigere enn b eller lik b
            else {
                System.out.println(nyNode.element + " er IKKE viktigere enn " + storreNode.element);
                storreNode = storreNode.neste;
                
            }
        }
    
    }






}
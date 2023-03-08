class IndeksertListe <E> extends Lenkeliste<E>{


    public void leggTil(int pos, E x){

        Node peker_node = start_node;
        Node forri_node = null;
        Node nyNode = new Node(x);
        int teller = 0;


        // sjekk om oppgitt indeks er ugyldig.  
        sjekk_om_gyldig_index(pos);

         // sjekk om Lenkeliste er helt tom. 
         // Går bare om pos = 0 også pga if sjekken over.
        if (start_node == null){
            start_node = nyNode;
            return;
        }

        // bruker finner node paa pos + noden før. 
        while (teller != pos){

            teller++;
            forri_node = peker_node;
            peker_node = peker_node.neste;
        }

        // Om peker_node er det siste elementet, altså null;
        if (peker_node == null){
            peker_node = nyNode;
            peker_node.forrige = forri_node;
            forri_node.neste = peker_node;
        }

        // Om peker_node er allerede en node. ; 
        else {


            // arv pekerene fra forrige noden
            nyNode.neste = peker_node;
            nyNode.forrige = peker_node.forrige;

            // pek til ny node fra omringende noder.
            if (peker_node.forrige != null){
                peker_node.forrige.neste = nyNode;
            }
            peker_node.forrige = nyNode;
            
            // peker nyNode til null, er det den første i lenketliste.
            // dermed oppdaterer vi start_node.
            if (nyNode.forrige == null){
                start_node = nyNode;
            }
        }
        
        // alt1:
        // peker_node.forrige <-> nyNode <-> peker_node
        // 0                      1          2
        
        // alt2:
        // null<-peker_node->null
        // null<-ny_node<->peker_node
        // -1    0         1

        
        




    }
    public void sett(int pos, E x){
    
        sjekk_om_gyldig_index(pos);
        Node peker_node = finn_node_paa_pos(pos);

        if (peker_node != null){
            peker_node.element = x;
        }
        else {
            throw new UgyldigListeindeks(0);
        }
        
    }
    public E hent(int pos){
        sjekk_om_gyldig_index(pos);
        return finn_node_paa_pos(pos).element;
    }

    public E fjern(int pos){

        Node peker_node = finn_node_paa_pos(pos);
        Node node_som_blir_slettet = peker_node;

        // sjekk at pos er gyldig + du ikke prøver å fjerne fra tom liste.
        sjekk_om_gyldig_index(pos);
        if (peker_node == null){
            throw new UgyldigListeindeks(pos);
        }


        // fra her av, er peker_node alltid en node.


        // sjekk om forrige er null, men ikke neste ...
        if (peker_node.forrige == null && peker_node.neste != null){
            peker_node = peker_node.neste;
            peker_node.forrige = null;
            
            start_node = peker_node; // må være første node...
        }

        // sjekk om neste OG forrige er null
        else if (peker_node.forrige == null && peker_node.neste == null){
            peker_node = null;
        }

        // sjekk om neste er null, men forrige ikke er
        else if (peker_node.forrige != null && peker_node.neste == null){
            peker_node.forrige.neste = null;
            peker_node = null;
        }

        // dersom ikke, har den både noder som neste OG forrige.
        else {
            peker_node.forrige.neste = peker_node.neste;
            peker_node.neste.forrige = peker_node.forrige;
        }
        
        return node_som_blir_slettet.element;

        


        // fra:
        // null <- node1 -> null
        // null    null     null

        // eller fra:
        // null <- node1 <-> node2
        // null <- node2 -> null

        // eller:
        // node1 <-> node2 <-> node3 <-> node4 -> null
        // null  <-  node2 <-> node3 <-> node4 -> null
        // null <- node2 <-> node4 -> null
        

    }




    // egne metoder, bruk for å simplisere. 

    public Node finn_node_paa_pos(int pos){

        Node peker_node = start_node;
        int teller = 0;

        while(teller != pos){
            teller++;
            peker_node = peker_node.neste;
        }
        return peker_node;
    }

    public void sjekk_om_gyldig_index(int pos){
        if (pos > stoerrelse() || pos < 0 ){ 
            throw new UgyldigListeindeks(pos);     
        }
    }
    
}


       
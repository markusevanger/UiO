class IkkeMerPlassException extends Exception {



    IkkeMerPlassException(String id) { // boktittel ... 
    
        super("Det var ikke mer plass for bok" + id);

    }
}
class IkkeMerPlassException extends Exception {



    public IkkeMerPlassException(String id) { // boktittel ... 

        super("Det var ikke mer plass for bok" + id);

    }
}
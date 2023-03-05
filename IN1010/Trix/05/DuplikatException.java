class DuplikatException extends Exception{



    public DuplikatException(String id){
        super("Foelgende proevde aa bli lagt til men er allerede i bokhylle:" + id); 
    }
   
}
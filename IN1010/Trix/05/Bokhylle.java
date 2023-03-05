class Bokhylle {
    private Bok[] boeker;

    public Bokhylle (int antPlasser) {
        boeker = new Bok[antPlasser];
    }

    //Forsoeker aa sette inn en bok paa foerste ledige plass i bokhyllen
    public void settInn(Bok b) throws DuplikatException {

    
        for (int i = 0; i < boeker.length; i++) {
            try{

            
            if (boeker[i] == b){
                throw new DuplikatException();
            }
            
            if (boeker[i] == null) {

                boeker[i] = b;
                return;
            }
        } 
        
        catch(DuplikatException(b.toString())){
            System.out.println("hwhda");
        }
    }
}

    

    public void skrivBoeker() {
        for (Bok b: boeker) {
            if (b != null) {
                System.out.println(b);
            }
        }
    }
}

class Blaa extends Resept {

        public Blaa(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

        public String farge(){
            return "blaa";
    }
        public int prisAaBetale(){
            return (int)Math.round(legemiddel.hentPris()*0.25); // 25% av opprinnelig pris, avrundet. 
        }
}
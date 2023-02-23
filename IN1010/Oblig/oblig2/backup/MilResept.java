class MilResept extends Hvit {

    
    public MilResept( Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) { // uten reit, tar i bruk passende konstruktor
    super(legemiddel, utskrivendeLege, pasientId);
    }

    public int prisAaBetale(){
        
        bruk();
        return 0; // uansett om resepten er gyldig eller ikke, er prisen å betale 0.
}
}
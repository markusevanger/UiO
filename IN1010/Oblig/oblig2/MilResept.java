class MilResept extends Hvit {

    
    public MilResept(int id, Legemiddel legemiddel, Lege utskrivendeLege, int pasientId) { // uten reit, tar i bruk passende konstruktor
    super(id, legemiddel, utskrivendeLege, pasientId);
    }

    public int prisAaBetale(){
        
        bruk();
        return 0; // uansett om resepten er gyldig eller ikke, er prisen å betale 0.
}
}
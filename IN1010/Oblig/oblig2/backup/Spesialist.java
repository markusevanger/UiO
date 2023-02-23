class Spesialist extends Lege implements Godkjenningsfritak {


    private final String kontrollkode;
    public Spesialist(String navn, String kontrollkode){

        super(navn);
        this.kontrollkode = kontrollkode;
    }

    public String hentKontrollkode(){
        return kontrollkode;
    }
}
class SuiteKjokken extends Suite implements Kjokken{

    public SuiteKjokken(int nr, int kvm, int sengeplasser, int kjokkenKvm){
        super(nr, kvm+kjokkenKvm, sengeplasser);
        this.kjokkenKvm = kjokkenKvm;
    }

    public String toString(){
        return "Suite med kjokken";
    }
}
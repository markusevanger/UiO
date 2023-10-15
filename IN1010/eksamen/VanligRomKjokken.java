class VanligRomKjokken extends VanligRom implements Kjokken{

    public VanligRomKjokken(int nr, int kvm, int sengeplasser, int kjokkenKvm){
        super(nr,kvm+kjokkenKvm,sengeplasser);
    }

    @Override
    public String toString() {
        return "Vanlig rom med kjokken";
    }
}
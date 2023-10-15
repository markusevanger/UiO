class EnkeltRom extends Rom{
    
    public EnkeltRom(int nr, int kvm, int sengeplasser){
        super(nr,kvm,sengeplasser);
    }

    @Override
    public String toString() {
        return "Enkelt rom";
    }
}
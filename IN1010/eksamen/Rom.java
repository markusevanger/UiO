abstract class Rom {

    final int nr;
    final int kvm;
    final int sengeplasser;
    boolean ledig = true;
    Rom neste;

    public Rom(int nr, int kvm, int sengeplasser){
        this.nr = nr;
        this.kvm = kvm;
        this.sengeplasser = sengeplasser;
    }

    public void settNesteRom(Rom rom){
        neste = rom;
    }
}
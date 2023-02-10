class Rektangel {

    double lengde;
    double bredde;

  public Rektangel (double l, double b) {   // Konstruktør

    lengde = l;
    bredde = b;

  }

  public void oekLengde (int okning) {    // Oek lengden som angitt

    lengde += okning;
  }

  public void oekBredde (int okning) {    // Oek bredden som angitt

    bredde += okning;
  }

  public void synkLengde(int reduksjon){
    
    lengde -= reduksjon;
}
  public void synkBredde(int reduksjon){

    bredde -= reduksjon;
  }


  public double areal () {     // Beregn mitt areal

    return lengde*bredde;
  }

  public double omkrets () {   // Beregn min omkrets

    return lengde*2+bredde*2;
  }


  public static void main(String[] args){

    Rektangel rek_1 = new Rektangel(2, 4);
    Rektangel rek_2 = new Rektangel(3, 5);

    System.out.println("Rektangel 1 Areal: " + rek_1.areal());
    System.out.println("Rektangel 2 Areal: " + rek_2.areal());

    rek_1.oekLengde(6);
    rek_2.oekBredde(7);

    System.out.println("Rektangel 1 Omkrets etter oekning: " + rek_1.omkrets());
    System.out.println("Rektangel 2 Omkrets etter oekning: " + rek_2.omkrets());

    rek_1.synkLengde(20);
    rek_2.synkBredde(20);

    System.out.println("Rektangel 1 Areal etter tilbakestilling: " + rek_1.areal());
    System.out.println("Rektangel 2 Areal etter tilbakestilling: " + rek_2.areal());
  }

}

"""

Definerer en klasse, dato med egenskapene dag, maaned og aar.
Inneholder metoder for å returnere verdiene av instansvariabelele.

Har også metode for å samle 3 egeneskaper (dag, maaned og aar) i en tekst streng
med / mellom (dd/mm/yr).
Metode som også tar en annen dato og sjekke om den er lik
dato objektet. Returnerer en boolsk verdi av svaret.

"""

# 1. Konstruksjon -------------------------------------------------------------

class Dato:
    def __init__(self, ny_dag, ny_maaned, nytt_aar):

        self._dag     = int(ny_dag)
        self._maaned  = int(ny_maaned)
        self._aar    = int(nytt_aar)


# 2. Simple metoder ------------------------------------------------------------
# Disse metodene kan kalles på for å hente verdien av instansvariabelene.

    def hent_aar(self):
        return self._aar

    def hent_maaned(self):
        return self._maaned

    def hent_dag(self):
        return self._dag


# 3. "Avaserte" metoder --------------------------------------------------------

    #samler instansvariabelen i en "leselig" streng.
    def hent_formatert_dato(self):
        return str(self._dag) + "/" + str(self._maaned) + "/" + str(self._aar) #returnerer strengen.


    #tar en annen dato og sjekker om den er lik self. Er objekt == ny dato ?
    def sjekke_dato(self, annen_dag):
        return self._dag == annen_dag

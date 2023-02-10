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

        self.dag     = int(ny_dag)
        self.maaned  = int(ny_maaned)
        self.aar    = int(nytt_aar)


# 2. Simple metoder ------------------------------------------------------------
# Disse metodene kan kalles på for å hente verdien av instansvariabelene.

    def hent_aar(self):
        return self.aar

    def hent_maaned(self):
        return self.maaned

    def hent_dag(self):
        return self.dag


# 3. "Avaserte" metoder --------------------------------------------------------

    #samler instansvariabelen i en "leselig" streng.
    def hent_formatert_dato(self):
        return str(self.dag) + "/" + str(self.maaned) + "/" + str(self.aar) #returnerer strengen.


    #tar en annen dato og sjekker om den er lik self. Er objekt == ny dato ?
    def sjekke_dato(self, annen_dag):

        status = False

        if self.dag == annen_dag:
            status = True #oppdaterer status om objekt og annen dato er lik.

        return status #returnerer boolsk verdi som

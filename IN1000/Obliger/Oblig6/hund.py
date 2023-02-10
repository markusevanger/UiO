"""

Definerer en klasse hund med egenskapene metthet, alder og vekt.
Hunden kan springe, som reduserer vekten, og spise, som øker vekten.

"""


# 1. Kontruksjon ---------------------------------------------------------------


class Hund:

    def __init__(self, alder, vekt): #konstruer objekt, hent parametre alder og vekt.
        self._metthet = 10  # instansvariabel 1: metthet med startverdi 10.
        self._alder = alder # instansvarabel 2: alder med verdi av parameter alder.
        self._vekt = vekt # instansvarabel 3: vekt med verdi av parameter vekt


# 2. Metoder -------------------------------------------------------------------

    def hent_alder(self): # metode 1: hent verdi av alder
        return self._alder


    def hent_vekt(self): # metode 2: hent verdi av vekt
        return self._vekt


    def hent_metthet(self): # metode 3: hent verdi av metthet
        return self._metthet


    def spring(self): #metode 4: Spring, fører til tap av metthet og eventuelt vekt.

        self._metthet -= 1 # fjern 1 metthet per gang metoden kjøres.

        if self._metthet < 5: # om metthet er under 5,
            self._vekt -= 1 # fjern 1 fra vekt.


    def spis(self, mengde): # metode 5: spis, fører til økt metthet og eventuelt vekt.
        self._metthet += mengde # øk metthet med mengde mat, som er argument fra bruker.

        if self._metthet > 7: # om metthet er over 7,
            self._vekt += 1 # øk vekt med 1.


#######

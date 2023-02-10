from rutenett import Rutenett

"""

Samler metodene fra Rutenett objektet, og danner et rutenett objekt i instansen.

"""



# 1. Konstruktør ---------------------------------------------------------------

class Verden:


    def __init__(self, rader, kolonner):

        self._rutenett = Rutenett(rader, kolonner) # Lager et rutenett objekt med valgt antall rader og kolonner
        self._generasjonsnummer = 0 # Starter i generasjon 0

        self._rutenett.fyll_med_tilfeldige_celler()
        self._rutenett.koble_celler()

        # Kjører fyll_med_tilfeldige_celler og koble_celler i konstruktøren.



# 2. Metoder -------------------------------------------------------------------


    # Kaller på tegn_rutenett og skriver også ut generasjonsnummeret / antall levende.
    def tegn(self):


        for i in range(200):
            print()

            
        self._rutenett.tegn_rutenett()
        print(f"Generasjon: {self._generasjonsnummer}")
        print(f"Antall levende: {self._rutenett.antall_levende()}")



    # Kaller på tell_levende_naboer og oppdater_status på hver celle.
    def oppdatering(self):

        #henter rutenett listen fra rutenett objektet.
        rutenett_som_liste = self._rutenett._rutenett


        # for loop for hver celle som teller levende naboer og legger til i _naboer til hver celle
        for rad in rutenett_som_liste:
            for kolonne in rad:
                kolonne.tell_levende_naboer()

        # kjører oppdater status på hver celle. Sjekker om cellen skal leve eller dø i neste generasjon.
        for rad in rutenett_som_liste:
            for kolonne in rad:
                kolonne.oppdater_status()

        # Må ha to for loops, fordi alle celler må bli telt før vi kan oppdatere statusen.
        # Vis ikke blir blir oppdater_status() delvis basert på antall naboer fra forrige generasjon.

        self._generasjonsnummer += 1 #legger til 1 i generasjonsnummeret.

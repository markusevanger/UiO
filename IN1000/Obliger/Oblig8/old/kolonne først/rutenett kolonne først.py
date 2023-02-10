import random
from celle import Celle

class Rutenett:
    def __init__(self, rader, kolonner):
        self._ant_rader = rader
        self._ant_kolonner = kolonner
        self._rutenett = self._lag_tomt_rutenett()

    def _lag_tomt_rutenett(self):

        rutenett = []

        for rad in range(self._ant_rader):
            rutenett.append(self._lag_tom_rad())

        return rutenett

    def _lag_tom_rad(self):

        rader = []

        for elem in range(self._ant_kolonner):
            rader.append(None)

        return rader




    def fyll_med_tilfeldige_celler(self):

        # for løkke for hver kolonne med nøstet for løkke for hver for rad.
        # Gjør alle kordinater om til celler, der 1/3 av blir levende.


        # visuelt eksempel av koden:
        # A1 A2 A3 A4 <-- for løkke for A,B,C,D.
        # B1 B2 B3 B4       for løkke for A1, A2, A3, A4
        # C1 C2 C3 C4           lager celle for hver rute,
        # D1 D2 D3 D4           der 1/3 får status "levende"





        for kolonne in range(self._ant_kolonner):

            for rad in range(self._ant_rader):
                self.lag_celle(rad, kolonne)



    # Generer celle på oppgitt kordinat. 1/3 av dem får status levende.
    def lag_celle(self, rad, kol):
        self._rutenett[kol][rad] = Celle() #posisjon = nytt celle objekt

        if random.randint(0,2) == 2: # generer tilfeldig tall mellom 0 og 2
            self._rutenett[kol][rad].sett_levende() # sett celle som levende om tall == 2.


    def hent_celle(self, rad, kol):

        if kol < 0 or kol >= self._ant_kolonner:
            return None

        elif rad < 0 or rad >= self._ant_rader:
            return None

        else:
            return self._rutenett[kol][rad]



    def tegn_rutenett(self):

        for i in range(2):
            print()


        index_kolonne = []

        for kolonne in self._rutenett:

            for rad in self._rutenett[len(index_kolonne)]:
                print(rad.hent_status_tegn(), end="")



            index_kolonne.append(kolonne)
            print("")

        for i in range(2):
            print()


    def _sett_naboer(self, rad, kol):
        celle = self.hent_celle(rad, kol) # lagrer referanse til celle.


        for offset_kolonnen in range(-1, 2): #kolonner -1, 0, 1
            for offset_raden in range(-1, 2): # rader -1, 0, 1

                if offset_raden == 0 and offset_kolonnen == 0:
                    pass

                nabo = self.hent_celle(rad + offset_raden, kol + offset_kolonnen)


                if nabo != None:
                    celle.legg_til_nabo(nabo)

    def koble_celler(self):


        for kolonne in range(self._ant_kolonner):

            for rad in range(self._ant_rader):
                self._sett_naboer(rad,kolonne)



    def hent_alle_celler(self):

        alle_instanser = []


        for kolonne in self._rutenett:

            for rad in kolonne:
                alle_instanser.append(rad)


        return alle_instanser

    def antall_levende(self):

        antall_levende = 0
        index_kolonne = []

        for kolonne in self._rutenett:

            for rad in kolonne:

                if rad.er_levende():
                    antall_levende += 1

            index_kolonne.append(kolonne)

        return antall_levende

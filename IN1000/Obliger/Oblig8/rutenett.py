import random
from celle import Celle

"""

Danner et "rutenett" objekt, som egentlig er en liste med lister.
Fyller hver posisjon i hver liste med Celler og har en del metoder for
å sjekke "naboene" til rutene. 

"""




# 1. Konstrukør ----------------------------------------------------------------


class Rutenett:


    def __init__(self, rader, kolonner):
        self._ant_rader = rader
        self._ant_kolonner = kolonner
        self._rutenett = self._lag_tomt_rutenett()
        #              ^ rutenett = kall på funksjon _lag_tomt_rutenett.




# 2. Rutenett konstruksjon -----------------------------------------------------


    #Lager "rutenett" ved å danne en liste med lister.
    def _lag_tomt_rutenett(self):

        rutenett = []


        for rad in range(self._ant_rader): # kjører _ant_rader ganger
            rutenett.append(self._lag_tom_rad())
                            # ^legger til i rutenett et kall på funksjonen _lag_tom_rad


        return rutenett



    #lager ver enkelt kolonne med None som innhold i hver indeks.
    def _lag_tom_rad(self):

        kolonner = []

        #appender None til en liste _ant_kolonner ganger
        for kol in range(self._ant_kolonner):
            kolonner.append(None)

        return kolonner #returnerer listen til _lag_tomt_rutenett




# 3. Fylle celler i rutenett ---------------------------------------------------

    # Fyller alle plasser med en levende eller død celle.
    def fyll_med_tilfeldige_celler(self):



        # for løkke for hver rad med nøstet for løkke for hver for kolonne.
        # Gjør alle kordinater om til celler, der 1/3 av blir levende.


        # visuelt eksempel av koden:
        # A1 A2 A3 A4        <--     Kjører lag_celle på A1, B1, C1, D1
        # B1 B2 B3 B4                Så A2, B2, C2, D2 ...
        # C1 C2 C3 C4
        # D1 D2 D3 D4





        for rad in range(self._ant_rader): # for rad in _ant_rader ganger

            for kolonne in range(self._ant_kolonner): # for kolonne i _ant_kolonner ganger
                self.lag_celle(rad, kolonne)
                # ^ kall på lag celle med nåværende verdi av rad og kolonne som "kordinater"



    # Generer celle på oppgitt kordinat. 1/3 av dem får status levende.
    def lag_celle(self, rad, kol):
        self._rutenett[rad][kol] = Celle() #posisjon = nytt celle objekt

        if random.randint(0,2) == 2: # generer tilfeldig tall mellom 0 og 2
            self._rutenett[rad][kol].sett_levende() # sett celle som levende om tall == 2.




# 4. Naboer og tegning av rutenett ---------------------------------------------


    # Returnerer celle objekt ved oppgitte kordinater.
    def hent_celle(self, rad, kol):

        if rad < 0 or rad >= self._ant_rader:
            return None

        elif kol < 0 or kol >= self._ant_kolonner:
            return None


        # ^ retunerer None om kordinatene er utenfor rutenettet-

        else:
            return self._rutenett[rad][kol]
            # ^ Returnerer riktig objekt ved oppgitte "kordinater".



    # printer til terminal tegn for hver "rute" i rutenettet.
    # gir en visuell represtenasjon av det som egentlig er nøstede lister.
    def tegn_rutenett(self):

        for i in range(2):
            print()
        # ^ gir luft til koden



        for rad in range(self._ant_rader):

            for kolonne in range(self._ant_kolonner):

        #^ går en rute om gangen

                print(self.hent_celle(rad, kolonne).hent_status_tegn(), end="")
                # ^ printer tegn for statusen til cellen for hver rute.      ^fjerner linjeskifter fra enden.

            print("") #nytt linjeskift etter hver rad er skrevet ut.

        for i in range(2):
            print()
        # ^ luft i terminalen.



    # Sjekker de 8 rutene rundt valgt rute, og legger dem til i cellens instansvariabel.
    def _sett_naboer(self, rad, kol):


        celle = self.hent_celle(rad, kol) # lagrer referanse til celle.


        for offset_rad in range(-1, 2): #kolonner -1, 0, 1
            for offset_kol in range(-1, 2): # rader -1, 0, 1

                nabo = self.hent_celle(rad + offset_rad, kol + offset_kol)
                # ^ henter nabo ved å bruke nåværende posisjon og legge til en "offset" på +1, 0 eller -1

                if offset_rad == 0 and offset_kol == 0:
                    pass
                # ^ passer på at den ikke legger til seg selv.

                elif nabo != None: #hent_celle gir None om oppgit celle er utenfor rutenettet.
                    celle.legg_til_nabo(nabo) #legger til nabo i cellens _naboer instansvariabel.


    # kjører _sett_naboer på alle rutene i rutenettet.
    def koble_celler(self):

        for rad in range(self._ant_rader):

            for kolonne in range(self._ant_kolonner):
                self._sett_naboer(rad,kolonne)

        # Rad og kolonne endrer seg i forhold til hvor den er i for loopen.
        # Der rad og kolonne er et heltall som kan brukes til å danne et kordinat.



    # Samler alle cellene i en lang liste. (istedenfor et rutenett)
    def hent_alle_celler(self):

        alle_instanser = []


        for rad in self._rutenett:

            for kolonne in rad:
                alle_instanser.append(kolonne)
                # appender hver celle til en helt ordinær liste.

        return alle_instanser



    # Teller hvor mange levende celler det totalt er i rutenettet
    def antall_levende(self):


        antall_levende = 0


        for celle in self.hent_alle_celler():

                if celle.er_levende():
                    antall_levende += 1

                # sjekker om hvert objekt er levende, og teller den om den er levende.


        return antall_levende

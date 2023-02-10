from sang import Sang

"""

Konstruerer et spilleliste objekt med navn på listen som parameter.
Har metoder som fyller  instansvariabel-listen med sang objekter.
Kan lese fra en fil og legge til sanger fra txt filen.

Har blant annet metoder for å spille sanger og hente alle sangene av en artist.

"""


# 1. Konstruksjon --------------------------------------------------------------

class Spilleliste:
    def __init__(self, listenavn): #konstruktør med listenavn som parameter
        self._sanger = []
        self._navn = listenavn



# 2. Lese fra fil --------------------------------------------------------------

    def les_fil(self, filnavn):

        fil = open(filnavn, "r") #åpner "valgt" fil i lesemodus

        for linje in fil: #for loop for hver linje i filen
            alle_data = linje.strip().split(";") #fjerner /n fra hver linje, og splitter A;B til en liste [A, B]
            en_sang = Sang(alle_data[1], alle_data[0]) # lager et nytt Sang objekt med B som artist, og A som tittel
            self._sanger.append(en_sang) #legger til objektet i _sanger listen.

# 3. Andre metoder -------------------------------------------------------------

    # legger til sang fra bruker som kaller på metoden i listen.
    def legg_til_sang(self, ny_sang):
        self._sanger.append(ny_sang)

    # fjerner en valgt sang av bruker fra listen.
    def fjern_sang(self, sang):
        self._sanger.remove(sang)

    # kjører spill metoden fra klassen Sang på objekt hentet fra bruker.
    def spill_sang(self, sang):
        sang.spill()

    # kjører spill() på alle objektene i listen _sanger.
    def spill_alle(self):

        for sang in self._sanger:
            sang.spill()

    # tar tittel på sang fra bruker og finner objektet om tittelen er i en av Sang objektene i _sanger
    def finn_sang(self,tittel): #

        for sangen in self._sanger:
            if sangen.sjekk_tittel(tittel):
                return sangen #returnerer objektet som matcher tittelen.

    # finner alle sangene av en artist.
    def hent_artist_utvalg(self, artistnavn):
        artist_sanger = [] #ny tom liste

        # sjekker om oppgitt artist er riktig for hver sanger i _sanger
        for sang in self._sanger:
            if sang.sjekk_artist(artistnavn): #if True
                artist_sanger.append(sang) #legger til sangnene i ny liste
        return artist_sanger #returnerer listen etter for loopen er over. 

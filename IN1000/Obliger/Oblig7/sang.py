
"""

Kontruerer et objekt, Sang, med instansvariablene artist og tittel.
Deretter har metoder for å skrive ut, spill av, og sammenlikne instansvariablene med andre.

"""

class Sang:

# 1. """magiske""" metoder -----------------------------------------------------

    def __init__(self, artist, tittel): # initialiserer et nytt objekt med parametrene artist, tittel.

        self._artist = artist #instansvariabel med artist som verdi
        self._tittel = tittel #instansvariabel med tittel som verdi

    def __str__(self): #returnerer en leselig streng når objektet blir printet
        return (f"{self._tittel} av {self._artist}.")

# 2. Metoder -------------------------------------------------------------------


# "Spill" sang
    def spill(self):
        return print("Spiller av " + self._tittel + " av " + (self._artist)) #returnerer en streng med artistnavn og sangtittel av self.


# Sammenlikne artist:
    def sjekk_artist(self, navn): #går gjennom spillelisten og sammenlikner artist med artist fra parameter
        for navn in navn.split(): #splitter navn ("Jahn Teigen") i liste (["Jahn", "Teigen"])
            if navn in self._artist.split(): #sjekker om navn ("Jahn") er samme som instansvariabelen.
                return True
        return False

# Sammenlikne tittel:
    def sjekk_tittel(self, tittel): #sjekker om tittel fra parameter = sang tittel
        return tittel.lower() == self._tittel.lower() #bruker .lower() for å unngå feilmeldinger.


# Sammenlikne artist og tittel:
    def sjekk_artist_og_tittel(self, artist, tittel): #bruker metodene over i en and setning.
        return self.sjekk_tittel(tittel) and self.sjekk_artist(artist)

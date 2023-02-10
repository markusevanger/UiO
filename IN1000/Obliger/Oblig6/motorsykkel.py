"""

Definerer en klasse motorsykkel med egenskapene kilometer kjørt, merke og registeringsnummer.
Har også en metode som skriver ut alle egenskapene til self.

"""

class Motorsykkel: # Definere klassen motorsykkel



# 1. Kontruksjon ---------------------------------------------------------------


    def __init__(self, merke, reg_nummer):
        self._km = 0 #instansvariabel 1: kilometer kjørt er alltid 0 etter kontruksjon.
        self._merke = merke #instansvariabel 2: merke til motorsykkel, parameter fra bruker
        self._reg_nummer = reg_nummer #instansvariabel 3: registeringsnummer til motorsykkel, også parameter fra bruker.



# 2. Metoder -------------------------------------------------------------------


    def kjor(self, km): #metode 1: legge til kilometer kjørt
        self._km += km # tar parameter (heltall) fra bruker og adderer km instansvariabel.

    def hent_kilometerstand(self): #metode 2: hente nåværende verdi av instansvariabelen km.
        return self._km #returnerer nåværende verdi av kilometer instansvariabelen. Kan f.eks brukes til å printe verdi.

    def hent_merke(self): #metode 3: hente nåværende verdi av instansvariabelen merke.
        return self._merke #returnerer nåværende verdi av merke instansvariabelen

    def hent_reg_nummer(self):#metode 4: hente nåværende verdi av instansvariabelen reg_nummer (registeringsnummer).
        return self._reg_nummer #returnerer nåværende veri av reg_nummer instansvariabelen.

    def skriv_ut(self): #metode 5: Skrive ut kilometer, merke og reg_nummer.

        print()
        print("Denne motorsykkelen er en " + self.hent_merke() +  ",") # kjør metode hent_merke på motorsykkelen og print
        print("og har registeringsnummer " + self.hent_reg_nummer() + ".") # kjør metode hent_reg_nummer på motorsykkel og print.
        print("Motorsykkelen har kjørt: " + str(self.hent_kilometerstand()) + "km.") # kjør metode hent_kilometerstand på motorsykkelen og print.

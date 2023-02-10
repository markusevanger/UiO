"""
Dette programmet spør om to navn og plasserer dem i en setning.
Programmet tar også to variabler (tall) og regner ut differansen
mellom dem.
"""

#Hente variabelen navn
navn1=input("Skriv navnet ditt her: ")

#Tallene brukt i differansen
Tall1=6
Tall2=2

#Dette regner ut differansen mellom tall1 og tall 2
Differanse=Tall1-Tall2

#Dette skriver ut til terminalen "Hei + (variabelen navn)"
print("Hei", navn1)

#Dette skriver ut tall1 og tall2. Lager også litt luft i terminalen.
print()
print(Tall1)
print(Tall2)
print()

#Dette skriver ut variablen Differanse
print("Dette er differansen mellom tallene over:", Differanse)

#Dette spør om et nytt navn og lagrer det som variabelen navn2
navn2=input("Skriv ett annet navn: ")

#Lager en ny variabel kalt sammen med en setning som innholder begge navnene.
sammen=navn1+" og "+navn2

#Skriver ut til terminalen setningen med navnene brukt
#for eksempel "Kari og Ola"
print(sammen)

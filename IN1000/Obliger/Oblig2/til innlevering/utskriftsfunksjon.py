"""
Dette programmet spør om navn og sted. Svaret printer den ut
Programmet "repeteres" tre ganger.
"""

#Nøster funksjonene under som "treganger".
def treganger():

#Ber om ett navn og lagrer det som navn.
    navn = input("Skriv inn navn: ")
#Ber om ett sted og lagrer det som sted.
    sted = input("Hvor kommer du fra? ")
#skriver ut variablene navn og sted til terminalen.
    print("Hei, " + navn + "! Du er fra " + sted)
#print() brukes bare for å holde terminalen litt ryddig.
    print()

#kjører nøsten "treganger". Dette er det første programmet kjører.
treganger()
treganger()
treganger()

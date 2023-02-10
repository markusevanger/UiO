"""
Dette programmet tar to datoer og sammenlikner dem.
Er datoene i riktig rekkefølge skriver programmet ut en positiv tilbakemelding
Er de i feil rekkefølge, sender den en negativ tilbakemedling.
print() brukes noen steder for å holde terminalen ryddig

Dette programmet sammelikner verdiene som strenger, som fungerer siden det er
strenger på begge sider.
"""

print()

#Dette spør bruker om dag1, måned1, dag 2 og måned2
Dag1=input("Skriv inn dag 1 her: ")
Måned1=input("Skriv inn måned 1 her: ")
Dag2=input("Skriv inn dag 2 her: ")
Måned2=input("Skriv inn måned 2 her: ")

#Dette skriver til terminalen hvilke datoer bruker har oppgitt
print()
print("Her er datoene du skrev inn: ")
print(Dag1+ "/" + Måned1)
print(Dag2+ "/" + Måned2)
print()

#Sammenlikner Måned1 med Måned2, er måned 2 større, printer programmet ut "Bra!"
if Måned1 < Måned2:
    print("Bra, Riktig rekkefølge! :D")

#Om månedene er like derimot, sammenlikner programmet dagene istedenfor.
elif Måned1 == Måned2:

#Er dag2 større printer den ut riktig. Om ikke hopper den til neste linje.
#Er dag1 større, printer den ut feil rekkefølge. 
        if Dag1 < Dag2:
            print("Bra, riktig!")
        if Dag1 > Dag2:
            print("Feil rekkefølge...")

#Er måned1 større enn måned2, printer programmet en feilmelding
if Måned1 > Måned2:
    print("Feil rekkefølge! :(")

#Er månedene like, sammenlikner programmet dagene istedenfor.
#Er dagene også like, skriver programmet "Datoene er de samme!"
elif Måned1 == Måned2:
    if Dag1 == Dag2:
        print("Datoene er de samme!")

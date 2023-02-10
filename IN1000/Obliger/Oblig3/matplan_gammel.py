
#Definerer Hvem beboerne er, slik at man lett kan se og endre hvem de er.

#Bytt til lister i frkst, lunsj, middg.


beboer1 = "Oda"
beboer2 = "Markus"
beboer3 = "Sofie"

#/////////////////////////////////////////////////////////////////

# Denne delen definerer alle måltidene til b1 (beboer1), b2 og ,b3
# Lagres som vanlig variabel, slik at den kan lett endres senere.

b1_frkst = "Spiser ikke frokost"
b1_lunsj = "Egg og avokado"
b1_middg = "Spagetthi"

b2_frkst = "Toast"
b2_lunsj = "Middags rester"
b2_middg = "Kylling og ris"

b3_frkst = "Knekkebrød og ost"
b3_lunsj = "Knekkebrød og avokado"
b3_middg = "Taco"


#Legger legger til b1s måltider i et dictionary b1_måltider
b1_måltider = {}

b1_måltider["Frokost"] = b1_frkst
b1_måltider["Lunsj"] = b1_lunsj
b1_måltider["Middag"] = b1_middg

#Legger legger til b2s måltider i et dictionary b2_måltider
b2_måltider = {}

b2_måltider["Frokost"] = b2_frkst
b2_måltider["Lunsj"] = b2_lunsj
b2_måltider["Middag"] = b2_middg

#Legger legger til b3s måltider i et dictionary b3_måltider
b3_måltider = {}

b3_måltider["Frokost"] = b2_frkst
b3_måltider["Lunsj"] = b3_lunsj
b3_måltider["Middag"] = b3_middg

#Samler dictionary b1_måltider, b2_måltider og b3_måltider i en stor dictionary
#Bruker beboer variabelen fra før til å definere key values (nøkkelverdier).

beboere = {}

beboere[beboer1] = b1_måltider
beboere[beboer2] = b2_måltider
beboere[beboer3] = b3_måltider

# /////////////////////////Prosedyrer//////////////////////////////

# Denne prosedyren gir en hilsen og henter hvem som bor på sykehjemmet
# Bruker tjenesten .keys() til å hente kun nøkkelverdiene.

def oversikt():
    print()
    print("Heisann!")
    print("Her er oversikten på de som bor sykehjemmet nå: ")
    print(beboere.keys())
    print()

# Spør

def maaltider():
    svar_navn = input("Skriv inn en av beborne her: ")
    print()

    if svar_navn == "Oda":
        x = beboere.get("Oda")
        print(x)
    elif svar_navn == "Markus":
        y = beboere.get("Markus")
        print(y)
    elif svar_navn == "Sofie":
        z = beboere.get("Sofie")
        print(z)
    else:
        print()
        print("Den beboeren er ikke registrert enda! Prøv igjen: ")
        maaltider()

oversikt()
maaltider()


"""
Skriftlig oppgave:

a: Jeg ville brukt et dictionary slik at brukernavn og fulltnavn henger sammen.
I en liste eller mengde er det ikke mulig å styr på hvilke brukernavn som henger sammen.
Er det kun brukernavn, kan vi bruke en liste.

b: Her ville jeg også brukt et dictionary for å holde styr på hvem som har fått hvilke poeng.
Her gjelder samme begrunnelse som på oppgave a.

c: Her ville jeg brukt en liste. En liste kan holde oversikten, sorteres alfabetisk og
kan ha flere med samme navn. Det er defor heller ikke en mengde.

d: For allergier passer en gjerne mengde. Da trenger vi ikke 

"""

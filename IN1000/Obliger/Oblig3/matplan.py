"""

Programmet lagrer informasjon om tre beboeres måltider i løpet av en dag.
Måltidene er lagret i lister som innholdsverdi og er knyttet til et navn som nøkkelverdi.
Programmet tar et navn og bruker .get tjenesten til å søke og hente listene i ordboken.

"""



# master ordbok som inneholder navn som nøkkelverdier og lister over måltidene.
mstr_ordbok = {

"Oda" : ["Ingen frokost", "Ristet brød til lunsj", "Spagetthi til middag."],
"Markus" : ["Toast til frokost", "Middagsrester til lunsj", "Kylling og ris til middag."],
"Sofie" : ["Knekkebrød til frokost", "Knekkebrød til lunsj", "Taco til middag."]

 }

# kort prosedyre som henter nøkkelverdiene i ordboken over.
# prosedyren gjør .keys output om til en liste slik at terminalen blir ryddigere.
# ^(brukte denne som referanse: https://www.geeksforgeeks.org/python-get-dictionary-keys-as-a-list/)

def oversikt():
    print()
    print("Heisann!")
    print("Her er oversikten på de som bor sykehjemmet nå: ")
    print(list(mstr_ordbok.keys()))
    print()

# prosedyre som spør bruker om input og bruker .get tjenesten til å hente verdier.
def maaltider():
    svar_navn = input("Skriv inn en av beborne her: ")
    print()

    if svar_navn in mstr_ordbok:
        print(mstr_ordbok.get(svar_navn))

    else:
        print()
        print("Den beboeren er ikke registrert enda! Prøv igjen: ")
        maaltider()


# her kjøres prosesdyrene:
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

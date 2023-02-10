"""

Skriv et inventar program som holder oversikt over hvilke varer som er hvor i
et varehus.

For eksempel ligger Stoler i Hylle A.

Programmet skal kunne både søke hva som ligger i hylle A og
hvilken hylle Stoler ligger i.

"""

# dictionary med posisjoner til forskjellige møbler.
inventory = {

"Stoler"    : "A",
"Sofaer"    : "B",
"Skuffer"   : "C",
"Skap"      : "D",
"Bord"      : "E",
"Diverse"   : "F"

}


# prosedyre som spør hvilken hvilken funksjon av programmet som skal brukes.
def intro():
    print()
    print("Heisann! Velkommen til lageret")
    print("Hva ønsker du å gjøre?")
    print()
    print("Jeg ønsker å finne hvor en gjenstand er  (1)")
    print("Jeg ønsker å vite hva som er i en hylle  (2)")
    print()
    a = input("Skriv her (1/2): ")

    if a == "1":
        hvor_er()
    elif a == "2":
        hva_er()
    else:
        print("prøv igjen: ")
        intro()



# Prosedyre som tar en nøkkelverdi og gir tilhørende innholdsverdi
def hvor_er():

    # printer ut alle nøkkelverdiene som er gyldige.
    print()
    print("Her er en oversikt over hva vi har:")
    print(list(inventory.keys()))
    print()


# tar nøkkelverdi som input og henter inholdsverdien. Skrives ut til terminalen.
# else: bruker variabelen svar til å gi en feil melding og spør om prosedyren skal kjøre om igjen.

    svar = input("Skriv inn noe vi har på lager, så finner jeg posisjonen for deg: ")

    if svar in inventory:
        print()
        print(svar + " finner du her: Hylle "  + str(inventory.get(svar)))

    else:
        x = input("Vi har desverre ikke " + svar + " på lager. Vil du prøve på nytt? (ja/nei):")

        if x == "ja":
            print()
            hvor_er()
        else:
            print("Ha en fin dag!")
            print()

# Denne prosedyren gjør et slags omvendt søk i ordboken ved å bruke flere tjenester (bedre forklart senere)
def hva_er():

    # ber om input og lagrer i variabel svar
    svar = input("Skriv en hylle (A-F): ")
    svar = svar.upper()

    # sjekker om svar ligger i innholdsverdiene til listen inventory.
    if svar in inventory.values():

        # Gjør om nøkkelverdier og innholdsverdier til ulike lister
        # bruker posisjonen av innholdsverdier til å søke i nøkkelverdier

        print()
        print("I hylle " + svar + " finner du: "  + list(inventory.keys())[list(inventory.values()).index(svar)])

        # ^trodde en slik løsning var lettere da jeg begynte, men fikk mye hjelp her:
        # https://stackoverflow.com/questions/8023306/get-key-by-value-in-dictionary

    # Spør om bruker vil prøve på nytt.
    else:
        x = input("Den hyllen har vi ikke. Vil du prøve igjen? (ja/nei): ")

        if x.lower() == "ja":
            print()
            hva_er()
        else:
            print("Ha en fin dag!")
            print()

# her kjører koden / prosedyrene.
intro()

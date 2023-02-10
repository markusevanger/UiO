"""
Oppgavetekst:
Skriv ett quiz program som tar i bruk if statements.
Programmet burde også kunne spør spørsmålet om igjen om
svaret er feil.


Forklaring:
Dette er et quiz program som spør spørsmål om blidnern
Det bruker if statements for å sjekke om svaret er riktig
og om svaret ikke er riktig bruker kjører programmet en tilbakemelding
og spør spørsmålet på nytt

"""

#Introduksjon. Bruker mange blanke print() for å skape mye mellomrom
def velk():
    print()
    print()
    print("Velkommen til BLINDERNS BESTE QUIZ!!")
    print()
    print("*      * ")
    print("O  *    O")
    print("  \___/  ")
    print(" * *    *")
    print()
    print()

#Første spørsmål spør om navnet til brukeren og gir en personalisert hilsen
def spm0():
    navn = input("Men først, hva heter du? ")
    print("Hei " + navn + "!" )
    print()

#Spør om brukeren er klar, om svaret ikke er ja spør den spørsmålet på nytt.
def spm1():
    svar1 = input("Er du klar? (ja/nei) ")

    if svar1.lower() == "ja":
        print("Så bra, da setter vi i gang :D ")
    else:
        print("nei vell D: Vi prøver igjen: ")
        spm1()

#Ber om et svar alternativ, er svaret riktig fullfører prosedyren og koden forsetter.
#Er svaret feil, gir programmet beskjed og spør spørsmålet på nytt.
def spm2():
    print()
    print("Når ble UiO grunnlagt?")
    print("a: 1995")
    print("b: 1800 ett eller annet")
    print("c: 1811")
    print()

    svar2 = input("Skriv svaralternativ (a, b eller c) her: ")

    if svar2.lower() == "c":
        print("nice mann")
    else:
        print()
        print("feil svar! prøv igjen: ")
        spm2()

#Helt likt spm2()
def spm3():
    print()
    print("Hvor mange etasjer er IFI")
    print("a: 3 etasjer")
    print("b: 7 etasjer")
    print("c: 8 etasjer")
    print()

    svar3 = input("Skriv svaralternativ (a, b eller c) her: ")

    if svar3.lower() == "c":
        print()
        print("whoooo!!!")
        print("God jobba, her kommer siste spørsmål! ")
        print()
    else:
        print()
        print("feil svar! prøv igjen: ")
        spm3()

#Likt spm3()
def spm4():
    print()
    print("Hvor mange linjer er det på IFI? (inkludert årsenhet) ")
    print("a: 4 linjer")
    print("b: 6 linjer")
    print("c: 7 etasjer")
    print("d: 7 linjer")
    print()

    svar4 = input("Skriv svaralternativ (a, b, c eller d) her: ")

    if svar4.lower() == "d":
        print()
        print("whoooo!!!")
        print("Du er god! Alt riktig. ")
        print()

    else:
        print()
        print("feil svar! prøv igjen: ")
        spm4()



# Her starter den faktiske koden, som kaller bare inn prosedyrene med spørsmålene.
velk()
spm0()
spm1()
spm2()
spm3()
spm4()

print()
print("quizen er nå over :D ")
print()

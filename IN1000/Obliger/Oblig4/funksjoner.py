
def adder(tall1, tall2):
    summen = tall1 + tall2
    return summen


print(adder(5,2))
print(adder(8,13))


def tellForekomst(minTekst, minBokstav):

    telling = 0

    for x in minTekst:
        if minBokstav == x:
            telling += 1

    return telling


streng  = input("Skriv inn en tekst streng: ")
bokstav = input("Skriv inn en bokstav: ")


print("Her er antall " + bokstav + " i strengen: " + str(tellForekomst(streng, bokstav)))

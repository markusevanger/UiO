"""

Dette programmet tar to tall og regner ut sum, differanse og dividenden av tallene.

Deretter tar programmet inn et heltall som gjøres om til Cm fra tommer

Sum, differanse, dividend og Cm printes ut til terminalen

"""

def addisjon(tall1, tall2):#prosedyre som adderer to tall og returnerer sum
    sum = tall1 + tall2
    return  sum


def subtraksjon(tall1, tall2): #prosedyre som subtraherer to tall og returnerer sum
    sum = tall1 - tall2
    return sum

def divisjon(tall1, tall2): #prosedyre som deler to tall og returnerer sum.
    sum = tall1 / tall2
    return sum


def tommerTilCm(antallTommer): #prosedyre som sjekker om tall er over 0
    assert antallTommer > 0
    return antallTommer * 2.54

def skrivBeregninger(): # Tar to tall og bruker dem i prosedyrene over

    tall1 = float(input("Skriv inn ett tall: "))
    tall2 = float(input("Skriv inn ett annet tall: "))

    print()

    print("Utregninger:")
    print("Summen er: " + str(addisjon(tall1, tall2)))
    print("Differansen er " + str(subtraksjon(tall1, tall2)))
    print("Dividenden er " + str(divisjon(tall1, tall2)))

    print()

    tommer = float(input("Skriv inn tommer: "))
    print("Konvertering til Cm " + str(tommerTilCm(tommer)))

    print()


# Sjekker at alt går opp:

assert addisjon(8, 7)       ==  15
assert addisjon(-5, -3)     == -8
assert addisjon(8, -3)      ==  5

assert subtraksjon(8,7)     ==  1
assert subtraksjon(-5, -3)  == -2
assert subtraksjon(8, -3)   ==  11

assert divisjon(8,7)        ==  1.1428571428571428
assert divisjon(-5, -3)     ==  1.6666666666666667
assert divisjon(8, -3)      == -2.6666666666666665


# Kjører prosedyren
skrivBeregninger()

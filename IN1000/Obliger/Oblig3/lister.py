#1 /////////////////////////////////////////////////////////////////////////////

#definerer liste en med 3 sifre.
liste1 = [1, 2, 3]

#legger til tallet 4 på slutten av liste1
liste1.append(4)
print(liste1)
print()


#2 //////////////////////////////////////////////////////////////////////////////

#definerer en liste "navn" som er tom.
navn = []

#en prosedyre som spør om et navn og legger det til i listen navn.
def spm():
    svar = input("Skriv et navn her: ")
    navn.append(svar)

#spør spørsmål 4 ganger.
spm()
spm()
spm()
spm()

#skriver ut listen etter programmet er ferdig.
print(navn)

#sjekker "Markus" dukker opp en eller flere ganger og svarer tilsvarende.
if "Markus" in navn:
    print("Du husket meg!")
else:
    print("Glemte du meg? D:")


#3 /////////////////////////////////////////////////////////////////////////////

#summerer verdiene fra liste1 (ligger øverst) og printer ut sum.
sum = liste1[0]+liste1[1]+liste1[2]+liste1[3]
print()
print("summen er: " + str(sum))

#regner ut produktet av verdiene i liste1, og printer ut.
prdkt = liste1[0]*liste1[1]*liste1[2]*liste1[3]
print("produktet er: " + str(prdkt))


#definerer liste2 som en tom liste
liste2 = []

#legger til verdiene fra produkt og sum utregningen over.
liste2.append(sum)
liste2.append(prdkt)

#printer ut en formel til terminalen for å holde den oversiktlig.
print(str(liste2) + " + " + str(liste1) + " = ")

#legger sammen liste1 og liste2 i en ny liste, liste3
liste3 = liste1 + liste2

#skriver ut liste3 til terminalen
print(liste3)
print()

#fjerner de to bakerste sifrene fra liste3.
liste3.pop()
liste3.pop()

#skriver ut liste3 en siste gang etter den ble endret.
print(liste3)

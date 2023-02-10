"""

Dette programmet henter 5 reisemål i listen "steder",
5 klesplagg i listen "klesplagg"og 5 avreisedatoer i listen avreisedatoer.

Deretter samler programmet listene inn i en stor liste, "reiseplan".
Reiseplan bruker nøstede lister.

Deretter spør programmet om bruker vil søke i listen steder,
klesplagg eller avreisedatoer. Når liste er valgt,
skriver bruker hvilken indeks som skal søkes.

"""

# 1. Lage liste reisemål: ------------------------------------------------------

steder = [0, 1, 2, 3, 4] # Forhåndsbestemt posisjoner slik at for loop kjører 5 ganger.
index = 0 # Indeks defineres som 0 for at følgende kode skal fungere.

# *
for elem in steder: # kjører en gang for hvert element i listen "steder"
    svar = input("Skriv inn et reisemål: ") # ber om reisemål og lagrer som svar.
    steder[index] = svar #lagrer svar i posisjon index til listen steder.
    index += 1 # øker index med en for hver gjennomkjøring.


# 2. Lage liste klesplagg: -----------------------------------------------------

klesplagg       = [0, 1, 2, 3, 4] # Samme som listen steder
index           =  0 # Index blir gjort til null igjen.

# Følgende kode følger samme prinsipper som over. (se * i punkt 1.)
for elem in klesplagg:
    svar = input("Skriv inn et klesplagg: ")
    klesplagg[index] = svar
    index += 1

# 3. Lage liste avreisedatoer: -------------------------------------------------

# Denne koden følger prinsippene til koden i punkt 2.

avreisedatoer   = [0, 1, 2, 3, 4]
index           =  0

for elem in avreisedatoer:
    svar = input("Skriv inn avreisedatoer: ")
    avreisedatoer[index] = svar
    index += 1


# 4. Samle lister inn i nøstetliste: -------------------------------------------


# Samler listene steder, klesplagg og avreisedatoer inn i listen reiseplan
# (som nøstede lister).

reiseplan = [steder] + [klesplagg] + [avreisedatoer]

for elem in reiseplan: # kjører 3 ganger (tre lister i reiseplan)
    print(elem)


# 5. "Søking" i reiseplan: -----------------------------------------------------


def sook(): #prosedyre slik at koden kan kjøres om igjen.

    print()

    # Lagrer heltall som liste_index1.
    liste_index1 = int(input("Skriv inn 0, 1 eller 2: "))

    # Sjekker om liste_index1 er mellom 0 og 2.
    if liste_index1 >= 0 and liste_index1 <= 2:

        # if true, ber om heltall lagret som liste_index2.
        liste_index2 = int(input("Skriv inn 0, 1, 2, 3 eller 4: "))

        # sjekker om liste_index2 er mellom 0 og 4.
        if liste_index2 >= 0 and liste_index2 <= 4:

            # if true,
            # print: posisjon til liste_index2 i liste_index1 i listen reiseplan
            print(reiseplan[liste_index1][liste_index2])

        

        # om liste_index2 er over 4 eller under 0, kjører sook() omigjen.
        else:
            print("Ugyldig input!")
            sook()
    else: # om liste_index1 er over 2 eller under 0, kjører sook() omigjen.
        print("ugyldig input!")
        sook()

sook()

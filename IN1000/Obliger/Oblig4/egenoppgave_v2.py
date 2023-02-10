
"""

Skriv et program som henter en liste med navn og deretter bruker en for loop
til å la bruker legge inn en tilhørende fødselsdato. Programmet skal deretter
la bruker kunne bruke navnene til å finne ut når de har bursdag.

"""


# 1. Hente navn-----------------------------------------------------------------

print()
print("Heisann!")
navn = [] # ny tom liste
navn_bursdager = {} # ny tom ordbok


# while loop som bruker .append() til å legge til navn i listen "navn".
while str(0) not in navn: #kjører helt til bruker skriver inn 0 istedenfor et navn.

    navn.append(input("Skriv inn navnet på noen du kjenner (Skriv 0 for å avslutte): "))
    print("Her er oversikten så langt: " + str(navn))
    print()

navn.pop() #fjerner siste verdi fra listen navn, som alltid er 0.


# 2. Hente bursdags dato -------------------------------------------------------

print()
print("Her er oversikten over navnene: ")
print(navn) # oversikt over navnene som er lest inn.
print()

# for loop som tar hvert av navnene og kobler det opp med en dato som bruker skriver inn.
for elem in navn:

    dato = input("Når har " + elem + " bursdag? (dd/mm/yy): ") # henter dato fra bruker
    navn_bursdager[elem] = dato # legger navn og dato sammen i ordbok "navn_bursdager"


# 3. Søke i "database" ---------------------------------------------------------

print()
print("For å søke i databasen trenger du nå bare å skrive inn ett navnene under: ")
print(list(navn_bursdager.keys())) #Gir oversikt (igjen) over mulige søk
print()

svar = True # defineres slik at følgende while loop kjører.

while svar == True: #kunne også kjørt som prosedyre, men valgte while loop pga oppgave tema.
    navn = input("Skriv navn her: ")
    print(navn + " har bursdag " + navn_bursdager.get(navn)) # bruker .get til å hente innholdsverdi av "navn"
    print()

    spm = input("Ønsker du å finne bursdagen til noen andre? (ja/nei): " ) # Spør om koden skal kjøre om igjen
    print()

    if spm == "ja":
        svar = True # while loop kjører omigjen.
    else:
        print()
        print("Ha en fin dag!")
        svar = False #while loop avsluttes og programmet er ferdig.

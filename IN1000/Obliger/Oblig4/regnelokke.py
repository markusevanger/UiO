
"""

Dette programmet legger til tall som brukeren skriver inn og legger dem til i en liste.
Programmet spør helt til brukeren skriver inn tallet 0, ved bruk av en while loop.

Så summerer programmet sifferene i listen med en for loop

Deretter finner programmet ut hvilket tall som er størst og minst, også ved bruk av for-loops.


"""


# 1. LAGE LISTE: ---------------------------------------------------------------


# Definerer tall som 1, slik at while loopen kjører første ganng
# Lager en tom liste med navn liste.
tall = 1
liste = []

# while løkke som spør om heltall og legger til i liste.

while 0 not in liste: # Kjører helt til tall = 0
    tall = int(input("Skriv inn heltall:")) # Ber om heltall og lagrer i variabel tall.
    liste.append(tall) # Legger til på slutten i "liste".
    print(liste) # Skriver ut listen, så langt.

# Etter while løkken er avlsuttet:
liste.pop() # Fjerner det siste sifferet i listen, som alltid er 0.
# Fjerner 0, om ikke er 0 alltid det minste tallet i listen.



# 2.  SUMMMERING: --------------------------------------------------------------


# Definerer pos som 0 og minSum som 0 slik at kommende setninger er gyldige.
pos = 0
minSum = 0

# Summerer liste ved å ta første siffer og plusse på andre siffer.
# Lagrer som sum og plusser tredje siffer ... osv

for elem in liste: # Bruker for loop til å kjøre en gang for hver verdi i liste.
    minSum += liste[pos] #eks: minSum (2) + pos2 i liste (4) = 6 = minSum
    pos +=1 # Øker posisjonsverdien slik at neste kjøring bruker neste siffer i liste.

print()
print("Dette er summen av listen din: " + str(minSum)) # printer minSum etter for loop er ferdig.
print()



#3. FINNE MAX OG MINIMUM: ------------------------------------------------------


# Følgende kode finner det største tallet i liste.

max = liste[0] # Setter verdien max til verdien av posisjon 0 i listen
# Gjør kommende for loop gyldig.

for elem in liste: # Bruker for loop til å kjøre en gang for hver verdi i liste.
    if elem > max: # Er elem større enn nåværende verdi av max:
        max = elem # endre verdien av max til verdien av elem.


# Følgende kode finner det minste tallet i liste.
# Bruker samme logikk som over, men sjekker istedenfor om elem er mindre enn nåværende min.

min = liste[0]

for elem in liste:
    if elem < min:
        min = elem


# Skriver ut til terminalen verdiene.
print("Her er det største tallet i listen din: " + str(max))
print("Her er det minste tallet i listen din:  " + str(min))
print()

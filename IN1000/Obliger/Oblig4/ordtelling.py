"""

Dette programmet tar en setning og skriver ut hvor mange instanser
av hvert ord det er (inkludert punktum osv. ). Det skriver også ut hvor mange bokstaver det er i
hvert ord i setningen.

"""



# 1. Antall bokstaver ----------------------------------------------------------
#  prosedyre som teller antall bokstaver i et ord og returnerer det som heltall)
def antall_bokstaver(ord):
    return (len(ord)) # tar argument ord, gjør om til liste, returnerer lengden av listen.



# 2. Ordbok --------------------------------------------------------------------
# prosedyre som splitter en setning inn i ord og teller hvor mange av hvert ord.
# Deretter legger antall ord inn i en ordbok som innholdsverdi med ord som nøkkelverdi.

def set_til_ordbok(setning): #setning er argument som hentes når koden kjøres.

    liste = setning.split() #splitter setning i en liste basert på mellomrom.
    ordbok = {} # ny tom ordbok

    for elem in liste: # for loop basert på "liste" med hvert ord i setningen.
        if elem not in ordbok.keys(): # om elem (ord) ikke er i nøkkelveridene;
            ordbok[elem] = 1 # if true, legg til elem i ordbok med innholdsverdi som 1.

        elif elem in ordbok.keys(): # om elem er i nøkkelveridene til ordbok;
            ordbok[elem] = (ordbok.get(elem) + 1) # if true; hent innholdsverdi til elem i ordbok og legg til 1.

    return ordbok # returnerer ordbok når for loopen er over.



# 3. Output til terminal -------------------------------------------------------
# Denne delen av koden bruker funksjonene over til å skrive ut diverse informasjon.
# Her starter python å lese koden:

setning = input("Skriv inn en setning: ") # Ber bruker om setningen.
ordbok = set_til_ordbok(setning) # Sender "setning" til prosedyre set_til_ordbok og lagrer som ordbok
# ^lagrer som variabel for lettere oversikt i koden som kommer.


print("Det er " + str(len(setning.split())) + " unike ord i setningen din.")
#^ bruker split tjeneste til å lage liste over alle over, deretter sjekker lengden av listen.

print()


# For loop som kjører for hvert ord i ordboken / setningen.

for elem in ordbok: # kjører en gang for hver nøkkelverdi.
    print("Ordet " + elem + " forekommer: " + str(ordbok.get(elem)) + " ganger, og har " + str(antall_bokstaver(elem)) + " bokstaver.")
    # ^ tar i bruk prosedyrene over til å finne antall ganger ord forekommer og antall bokstaver i hvert ord.
    # kjører ordbok.keys() antall ganger

print()

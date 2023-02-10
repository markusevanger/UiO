"""

Leser to .csv filer og sammenlikner dem, om temperaturen i en fil er større enn
i den andre filen, overskrives verdien og bruker får beskjed om ny temperatur rekord.

"""


# 1: lager ordbok ut av csv filen ----------------------------------------------


def lagOrdbok(filnavn):

    ordbok = {} # tom ordbok.

    fil = open(filnavn, "r") #åpner fil i lesemodus

    for linje in fil: #for loop som går linje til linje
        data = linje.strip().split(",") # "rensker" linjen, fjerner linje skift og spliter ved komma. data er en liste.
        maaned = data[0] #posisjon 0 i data er nøkkelverdi
        temp = float(data[1]) #posisjon en er innholdsverdi
        ordbok[maaned] = temp #legger til ordbok med nøkkelverdi som maaned og innholdsverdi som temp

    return ordbok #returnerer ordbok etter for loop er over.



# 2: sjekker om det har kommet ny rekord ---------------------------------------


def rekorder(ordbok, filnavn): #ordbok og filnavn som parameter

    fil = open(filnavn, "r") #åpner fil i lesemodus

    for linje in fil: #for loop for hver linje i filen
        data = linje.strip().split(",") # "rensker" linje til = liste [måned0, dato1, temp2]

        maaned   =   data[0]
        dato     =   data[1]
        temp     =   float(data[2]) #float slik at temperaturen beholder komma


        # if sjekk som sjekker om tall i fil_1 er større en i fil_2.
        if temp > ordbok[maaned]:
            print("Ny varmerekord på " + dato + " " + maaned + ": " + str(temp) + " celcius. (gammel rekord var " + str(ordbok[maaned]) + " celsius)")
            ordbok[maaned] = temp #oppdaterer ordbok

    print()
    return ordbok #retunrerer oppdatert ordbok.

# 3: Samler koden til utskrift -------------------------------------------------

def main():
    print()
    ordbok = lagOrdbok("max_temperatures_per_month.csv")
    ny_ordbok = rekorder(ordbok, "max_daily_temperature_2018.csv")

    for elem in ny_ordbok: #skriver ut ordbok til terminal ryddig.
        print(str(elem) + " " + str(ny_ordbok[elem]))

    print()


main() #kjører main()

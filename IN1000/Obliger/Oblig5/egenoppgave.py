"""

Lag et programet som skriver et uspesifisert antall tall til en tekst fil.
Deretter skal tallet lese hvor mange av hvert tall, og skrive dem inn i en ordbok.
Sammenlign deretter innholdsverdien for å finne det tallet som forekommer mest,
og det tallet som forekommer minst


"""

# 1: Skrive tall til txt--------------------------------------------------------

import random #importerer randint, som brukes til å skrive tallene.

def skrive_tilfeldig_til_fil(grense):

    fil = open("tall.txt", "w") #åpner tall.txt i skrivemodus.
    teller = 0 # definerer teller som 0, før while loopen.
    prosent = 0 #definerer prosent som 0, slik at prosentelleren fungerer.


# while løkke som skriver tilfeldig tall til txten, deretter linjeskift og nytt tall.

    while teller < grense: # while løkke som stopper når teller har nådd grense (definert av bruker).
        fil.write(str(random.randint(0,9))) #skriver tilfeldig tall mellom 0 og 9
        fil.write("\n") # linjeskift
        teller += 1 #øk teller med 1

# prosent teller som hjelper med å holde oversikt om bruker ønsker å ha en høy grense.
        if int(teller/grense*100) == prosent: # teller/grense*100, formel for å finne prosent. Runder av til heltall.
            print((str(int(teller/grense*100)) + "%")) #print prosent + %
            prosent += 10 # øk prosent med 10,

            #neste gang prosent printes, er når den er 10% høyere.

    fil.close() #lukker filen etter while løkken er slutt.



# 2: Telle tall i fil ---------------------------------------------------------


def telle_tall():

    ordbok = {} # definerer tom ordbok
    fil = open("tall.txt", "r") #åpner fil i lesemodus.

    #definerer variabelene 0 til 9 som 0.
    siffer_0 = 0
    siffer_1 = 0
    siffer_2 = 0
    siffer_3 = 0
    siffer_4 = 0
    siffer_5 = 0
    siffer_6 = 0
    siffer_7 = 0
    siffer_8 = 0
    siffer_9 = 0


    # for loop som sjekker linje for linje i tekst filen, og teller for hvert siffer
    # i filen.
    for linje in fil:
        tall = int(linje.strip()) # .strip fjerner linjeskift (\n) fra linjen

        if tall == 0: # er tallet på linjen 0;
            siffer_0 += 1 # tell +1
            ordbok[tall] = siffer_0 #legg til i ordbok.

        elif tall == 1: # samme som over.
            siffer_1 += 1
            ordbok[tall] = siffer_1

        elif tall == 2: # ^^...
            siffer_2 += 1
            ordbok[tall] = siffer_2

        elif tall == 3:
            siffer_3 += 1
            ordbok[tall] = siffer_3

        elif tall == 4:
            siffer_4 += 1
            ordbok[tall] = siffer_4

        elif tall == 5:
            siffer_5 += 1
            ordbok[tall] = siffer_5

        elif tall == 6:
            siffer_6 += 1
            ordbok[tall] = siffer_6

        elif tall == 7:
            siffer_7 += 1
            ordbok[tall] = siffer_7

        elif tall == 8:
            siffer_8 += 1
            ordbok[tall] = siffer_8

        elif tall == 9:
            siffer_9 += 1
            ordbok[tall] = siffer_9

        else:
            print("Oisann! Noe funka ikke :(")

    return ordbok #returnerer ferdig bygget ordbok.

    # kunne nok blitt gjort bedre ser jeg nå i ettertid, men koden fungerer :)



# 3: Sjekke største tall -------------------------------------------------------


def hvilket_tall_er_storst(ordbok): # ordbok fra punkt 2 som parameter.

    max = 0 #definerer max som null i starten

    for elem in ordbok: # for hvert element i nøkkelverdiene i ordbok:

        if int(ordbok[elem]) >= max: #sjekk om innholdsverdien er større enn max
            max = elem # if true, opdater max til elem.
        else:
            pass # om ikke, prøv igjen.

    return max #retuner verdien max.

def hvilket_tall_er_minst(ordbok): #ordbok fra punkt 2 som parameter

    min = ordbok[list(ordbok.keys())[0]] # min = innholdsverdien til den første nøkkelverdien i ordboka.

    for elem in ordbok: # samme prinsipp som max, men sjekker om tallet er mindre.

        if int(ordbok[elem]) <= min:
            min = elem
        else:
           pass

    return min #retunerer min





# Her starter koden å kjøre:

# 4: Kodesveising: -------------------------------------------------------------


def main():

    print()
    print("Heisann! ")
    print("Pass på at du har en  ´tall.txt´ fil i samme mappe som programmet :D")
    grense = int(input("Skriv inn hvor mange tall du vill programmet skal generere: ")) # Ber om grense fra bruker



    skrive_tilfeldig_til_fil(grense) #skriver antall tall til fil, avgrenset basert på brukers input.
    ordbok = telle_tall() #definerer ordbok som funksjonen telle_tall()
    max = int(hvilket_tall_er_storst(ordbok)) # max = funksjonen for å finne størst tall.
    min = int(hvilket_tall_er_minst(ordbok)) # min = funksjonen for å finne minst tall.


    print("Skrev " + str(grense) + " tall til tekst.txt...") # gir bruker tilbakemelding på input ...
    print()
    print("Det er flest " + str(max) + "ere i txt filen (" + str(max) + " forekommer " + str(ordbok[max]) + " ganger).") # samler informasjonen i en setning.
    print("Det er minst " + str(min) + "ere i txt filen (" + str(min) + " forekommer " + str(ordbok[min]) + " ganger).") # ^^
    print()
    print(ordbok) # printer ordbok tilslutt for absolutt oversikt.
    print()

# kjører programmet:
main()

"""

Bruker klassen Dato til å lage en ny dato, med egenskapene dag, maaned og aar.

Programmet sjekker om datoen er loenningsdag eller starten av en ny maaned. Lagrer
datoene i en tekst streng og skriver det ut.

"""


from dato import Dato #henter klassen Dato fra filen dato(.py)


def hovedprogram():

    dato = Dato(15, 8, 2003) #kontruerer nytt dato objekt: 15, 8, 2003
    datostr = dato.hent_formatert_dato() #bruker hent_formatert_dato metoden til å lagre dato som streng.
    #^ "15/8/2003"


    print()
    print(datostr) #skriver ut streng av datoen.
    undersoeke_dato(dato) #sjekker om dato objektet er 15 eller 1 (se neste under)
    print()

def undersoeke_dato(dato):

    if dato.sjekke_dato(1) == True: #bruker 1 som parameter i sjekke_dato metoden
    #       ^metoden sjekker om 1 == dato objektet. Utnytter boolsk returverdi av metoden.
        print("Ny maaned, nye muligheter!")

    elif dato.sjekke_dato(15) == True: #samme som over, men med 15 som parameter.
        print("Loenningsdag!")
    else:
        print("Det er ingenting spesielt som skjer idag.") #restesetning.



hovedprogram()

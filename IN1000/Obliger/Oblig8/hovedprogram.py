from verden import Verden

"""

Program som lar bruker bruke objektet verden (og dermed rutenett og celle)
Lar bruker velge størrelsen av rutenettet og gir dem en enkel måte å kjøre programmet.

"""



# 1. Hovedprogram --------------------------------------------------------------
def hovedprogram():


    for i in range(200):
        print()
    # ^ luft i terminalen

    print("Heisann! Velkommen til Game of Life!")

    for i in range(2):
        print()






    rader = int(input("Hvor mange rader skal kartet ditt være?: ")) #ber om antall rader
    kolonner = int(input("Hvor mange kolonner skal kartet ditt være?: ")) # ber om antall kolonner




    for i in range(200):
        print()




    print(f"Da er kartet ditt {rader} x {kolonner} stort!")
    print()
    print()
    input("Trykk enter for å starte programmet!")



    verden = Verden(rader, kolonner) # Danner et verden objekt med rader og kolonner som argument.
    verden.tegn() # Kaller på tegn verden.





    x = "yo"

    while x != "q": #while loop som kjører helt til q er skrevet inn.
        x = input("Trykk enter for aa fortsette, q for å stoppe: ")

        verden.oppdatering()
        verden.tegn()

        # oppdaterer og tegner verdenen hver gang bruker trykker enter.


    print()
    print("Programmet er stoppet!")
    print()
#starte hovedprogrammet
hovedprogram()

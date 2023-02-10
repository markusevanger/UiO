from verden import Verden

def hovedprogram():
    verden = Verden(30, 30)
    verden.tegn()

    x = "lolol"

    while x != "q":
        x = input("Trykk enter for aa fortsette, q for å stoppe: ")
        verden.oppdatering()
        verden.tegn()



# starte hovedprogrammet
hovedprogram()

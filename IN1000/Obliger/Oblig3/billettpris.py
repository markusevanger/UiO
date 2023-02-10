def alderspm():

    alder = int(input("Hvor gammel er kjøperen? "))
    billettpris = 0

    if alder <= 17:
        billettpris = 30
    elif alder >= 63:
        billettpris = 35
    elif alder > 17:
        billettpris = 50

    print()
    print("Du er " + str(alder) + " år gammel.")
    print("Billettprisen din er " + str(billettpris))
    print()

alderspm()

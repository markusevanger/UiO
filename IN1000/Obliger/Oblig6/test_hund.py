"""

Bruker klassen Hund til å lage en hund. Hunden kan springe så mange ganger bruker ønsker
og spise så mye bruker ønsker. Programmet passer på at om hunden springer eller
spiser for mye, dør den.

"""


# 1. Lage hund -----------------------------------------------------------------

from hund import Hund # importerer klassen Hund fra filen Hund(.py).

def hovedprogram():

    alder =  5 #definerer startalder til hunden
    vekt = 20 #definerer startvekten til hunden

    spanskHund = Hund(alder, vekt) # lager hunden med oppgitte argumenter.

    print()
    print("Hunden veier nå", str(vekt), "kg.") #Gir bruker oversikt over hvor mye hunden veier.


# 2. Springe -------------------------------------------------------------------

    ganger = int(input("Hvor mange ganger skal hunden løpe?: ")) #ber bvruker oppgi hvor mange ganger den skal løpe.
    print()


    for elem in range(ganger): #for loop som kjører antall ganger bruker ønsker hunden skal løpe
        spanskHund.spring() #kjører funksjonen for hver loop.

    if spanskHund.hent_vekt() <= 0: #er vekten 0 eller mindre,
        print("Du drepte hunden.") #er hunden dø, og programmet over.

    else:

        print("Hunden veier nå", spanskHund.hent_vekt(), "kg, etter å ha løpt", str(ganger), "ganger.")
        #^ Gir oversikt over hvor mye hunden har løpt og hva den veier etter antall ganger.

# 3. Spise ----------------------------------------------------------------------

        mengde = int(input("Hvor mye skal hunden spise? ")) # ber bruker om mengden mat hunden skal spise.
        spanskHund.spis(mengde) # gir hunden så mye mat som bruker ønsker.


        if spanskHund.hent_vekt() < 40: # er hunden i ca riktig vekt, får vi siste oversikt over vekten.
            print("Hunden veier nå", spanskHund.hent_vekt(), "kg")
        else:
            print("Hunden er død. Du ga den for mye å spise.") #er vekten over 40 kg har du gitt hunden for mye å spise.

        print()


hovedprogram()

class Celle:


    """

    Daner et celleobjekt som kan ha status død eller levende.
    Cellen kan også ha oversikt på opptil 8 naboer rundt seg i et rutenett.

    Basert på om naboene er levende eller døde og hvor mange det er, kan statusen
    til cellen oppdateres fra død til levende eller levende til død.

    """




    # 1. Konstruktør -----------------------------------------------------------


    def __init__(self):
        self._status = "doed" #Starter med status doed.
        self._naboer = [] #tom liste som skal holde nabo-objektene.
        self._ant_levende_naboer = 0 #hvor mange av naboene som er levende




    # 2. Endre status ----------------------------------------------------------


    # Endre status til "doed"
    def sett_doed(self):
        self._status = "doed"



    # Endre status til "levende"
    def sett_levende(self):
        self._status = "levende"



    # Bruk nabo parameter og legg til i listen self._naboer.
    def legg_til_nabo(self, nabo):
        self._naboer.append(nabo)




    # 3. Andre metoder/funksjoner ----------------------------------------------


    # Metode for å returnere boolsk verdi for statusen til cellen
    def er_levende(self):
        if self._status == "levende":
            return True
        else:
            return False



    #returnerer tegn som representerer om figuren er levende eller død.
    def hent_status_tegn(self):
        if self.er_levende():
            return "O"
        else:
            return "."




    # 4. Telling og oppdatering ------------------------------------------------


    # Metode som sjekker hvor mange av naboene til cellen som er levende
    def tell_levende_naboer(self):

        teller = 0


        # kalles når self._naboer har fylt opp listen med alle sine naboer
        for elem in self._naboer:
            if elem.er_levende(): #kaller på er_levende() funksjonen over
                teller += 1 #teller +1 om naboen er_levende() returnerer True.


        self._ant_levende_naboer = teller



    # Oppdaterer self._status etter noen regler i spillet.
    def oppdater_status(self):



        if self.er_levende():

            if self._ant_levende_naboer < 2:
                self.sett_doed()
            elif self._ant_levende_naboer > 3:
                self.sett_doed()

            # ^  setter cellen som død om den er allerede levende og har
            #    mindre enn 2 naboer eller mer enn 3 naboer.


        else:

            if self._ant_levende_naboer == 3:
                self.sett_levende()

            # ^ Setter cellen som levende om den er død og
            #   har presist 3 levende naboer.

class Celle:
    # Konstruktør
    def __init__(self):
        self._status = "doed"
        self._naboer = []
        self._ant_levende_naboer = 0

    def sett_doed(self):
        self._status = "doed"

    def sett_levende(self):
        self._status = "levende"

    def legg_til_nabo(self, nabo):
        self._naboer.append(nabo)

    def er_levende(self):
        if self._status == "levende":
            return True
        else:
            return False

    def hent_status(self):
        pass

    def hent_status_tegn(self):
        if self.er_levende():
            return "O"
        else:
            return "."

    def tell_levende_naboer(self):

        teller = 0

        #print(self._naboer) #<----
        for elem in self._naboer:
            if elem.er_levende():
                teller += 1

        #print(teller) #<----
        self._ant_levende_naboer = teller

    def oppdater_status(self):

        if self.er_levende():
    

            if self._ant_levende_naboer < 2:
                self.sett_doed()
            elif self._ant_levende_naboer > 3:
                self.sett_doed()

        else:

            if self._ant_levende_naboer == 3:
                self.sett_levende()

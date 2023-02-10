from random import randint
from celle import Celle

class Rutenett:
    def __init__(self, rader, kolonner):
        self._ant_rader = rader
        self._ant_kolonner = kolonner
        self._rutenett = self._lag_tomt_rutenett()

    def _lag_tomt_rutenett(self):

        rutenett = []

        for rad in range(self._ant_rader):
            rutenett.append(self._lag_tom_rad())

        return rutenett

    def _lag_tom_rad(self):

        rader = []

        for elem in range(self._ant_kolonner):
            rader.append(None)

        return rader


    def fyll_med_tilfeldige_celler(self):
        pass

    def lag_celle(self, rad, kol):
        pass

    def hent_celle(self, rad, kol):
        pass

    def tegn_rutenett(self):
        pass

    def _sett_naboer(self, rad, kol):
        pass

    def koble_celler(self):
        pass

    def hent_alle_celler(self):
        pass

    def antall_levende(self):
        pass

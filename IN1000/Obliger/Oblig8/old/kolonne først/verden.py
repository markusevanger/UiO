from rutenett import Rutenett

class Verden:
    def __init__(self, rader, kolonner):
        self._rutenett = Rutenett(rader, kolonner)
        self._generasjonsnummer = 0

        self._rutenett.fyll_med_tilfeldige_celler()
        self._rutenett.koble_celler()

    def tegn(self):
        self._rutenett.tegn_rutenett()
        print(f"Generasjon: {self._generasjonsnummer}")
        print(f"Antall levende: {self._rutenett.antall_levende()}")

    def oppdatering(self):

        rutenett_som_liste = self._rutenett._rutenett

        for kolonne in rutenett_som_liste:
            for rad in kolonne:
                rad.tell_levende_naboer()

        for kolonne in rutenett_som_liste:
            for rad in kolonne:
                rad.oppdater_status()

        self._generasjonsnummer += 1

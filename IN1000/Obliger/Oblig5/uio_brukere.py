"""

Dette programmet ber om prefix og suffix (Fullt navn og ønsker epost adresse)
Deretter tar den informasjonen og gjør den om til en epost adresse. prefix og
suffix blir lagret inn i en ordbok, som kan holde flere brukernavn og eposter.



"""



# 1: Lage brukernavn -----------------------------------------------------------


def lagBrukernavn(fullt_navn):


    fullt_navn = fullt_navn.split() #tar fullt navn og splitter inn i liste:
    # for eksempel "Markus Evanger" --> ["Markus", "Evanger"]

    brukernavn = fullt_navn[0] + fullt_navn[1][0] #brukernavn = markus + e (første bokstav i andre element i listen.)

    return brukernavn.lower() #returner brukernavn i små bokstaver.



# 2: Lage epost ----------------------------------------------------------------


def lagEpost(prefix, suffix): # henter parametre prefix (brukernavn) og suffix (adresse)

    epost = prefix + "@" + suffix # kombinerer brukernavn@epost i en streng

    return epost #returnerer epost



# 3: Skrive ut eposter ---------------------------------------------------------


def skrivUtEposter(ordbok): #henter ordbok med prefix som nøkkelverdi og suffix som innholdsverdi.

    index = 0 #

    for elem in ordbok: #for hvert elem in ordboken
        print(lagEpost(list(ordbok.keys())[index], ordbok[elem]))
        #^skriv ut med bruk av prosedyren 2: skrivUtEposter. Bruk prefix og suffix som argument.
        index += 1 # øk index med 1



# 4: Kodekjøring ---------------------------------------------------------------

def main():
    a = True # lar while loopen kjøre
    ordbok = {} # tom ordbok

    while (a == True):
        print()
        print(" --> Skriv inn i for å legge til epost, p for å skrive ut, og s for å avslutte. <-- ")
        svar = input("Skriv inn i, p eller s: ") #be om input fra bruker

        if svar.lower() == "i": # if i;
            prefix      = input("Skriv inn hele navnet ditt: ") #be om fullt navn, lagre som prefix
            suffix      = input("Skriv inn hvilken epost suffix du vil ha: ") # be om epost, lagre som suffix

            brukernavn  =    lagBrukernavn(prefix) # lagre brukernavn som funksjonen lagBrukernavn med prefix som argument
            epost       =    lagEpost(brukernavn, suffix) # lagre epost som funksjonen lagEpost med suffix som argument.

            ordbok[brukernavn] = suffix #skrive til ordboka brukernavn som nøkkelverdi og suffix som verdi


        elif svar.lower() == "p": # if p;
            skrivUtEposter(ordbok) # kjør funksjonen skrivUtEposter med ordbok som argument.

        elif svar.lower() == "s": # definerer a som false, som avslutter while loopen.
            a = False
            print("Hadebra!")



main() #kjører funksjonen over. 

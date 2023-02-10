def minFunksjon(): #legg til a som parameter for å få kode til å fungere

       for x in range(2): # for hvert tall i liste [0,1]

           c=2 # c = 2
           print(c) # skriver ut c ("2")
           c += 1 #c =+ 1, c er nå 3.
           b = 10 # b er nå 3
           b += a # b+= a er ???
           print(b) # printer veriden til b ("???")

       return(b) # * returnerer verdien til b


def hovedprogram():

       a    = 42 # a er 42
       b    =  0 # b er 0

       print(b) # print (b), skriver "0"


       b = a # b er nå 42
       a = minFunksjon() # a er nå funksjonen av minFunksjon.
       #^legg til a som argument for å få koden til å fungere
       print (b)
       print (a)


hovedprogram() #kjører prosedyren hovedprogram


"""

Først defineres minFunksjon(), uten noen parametre. Deretter defineres hovedprogram,
uten noen parametre. Deretter kjører hovedprogram().

I hovedprogram blir a definert som heltallet 42 og b som heltall 0.
Deretter blir b printet til terminalen ("0"). Deretter blir b definert som a.
b er nå 42. Deretter blir a definert til verdien av funksjonen minFunksjon().

Her starter minFunksjon() å kjøre.
    Først kjører en for loop med x som variabel i en liste som er [0, 1]
    For hvert kjør skjer dette:
        definer c som 2
        printer 2 til terminalen ("2")
        bytter definisjon av c til c = c + 1
        Deretter definerer vi b som 10

    Her feiler koden:
        b = b + a
        Denne delen av koden feiler fordi a er ikke definert lokalt i denne prosedyren.
        En måte for å fikse det kan være å legge til a som parameter i minFunksjon(a)
        Legger vi også til a i kallet på prosedyren bruker vi a variablen som ligger
        lokalt i hovedprogram().

        Vi bruker denne løsningen videre:

        b = b + a er nå med andre ord b = 10 + 42
        deretter printer vi b til terminalen ("52")
        Deretter returnerer vi verdien til b til det opprinnelige kallet på prosedyren.

i hovedprogram() er nå a lik heltallet 52
programmet skriver ut en siste gang b (42)
og en gang a (52)

"""

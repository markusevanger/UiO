"""

Bruker klassen Motorsykkel til å bygge 3 motorsykler. Endrer egenskapene på en
av motorsykklene og skriver ut egenskapene etterpå. 

"""



from motorsykkel import Motorsykkel #importer klassen Motorsykkel fra filen motorsykkel(.py)



def hovedprogram():

    sykkel1 = Motorsykkel("BMW", "NO00001") # Lag objekt sykkel 1 der merke er BMW og reg_nummer er NO00001. Motorsykkel() er klassen
    sykkel2 = Motorsykkel("Suzuki", "NO00002" ) # Lag objekt sykkel2 der merke er Suzuki og reg_nummer er NO00002.
    sykkel3 = Motorsykkel("Honda", "NO00003") # Lag objekt sykkel3 der merke er Honda og reg_nummer er NO00003.


    sykkel3.kjor(10) #bruk metoden .kjor() på sykkel3. Oppdaterer instansvariabelen km i sykkel3 med +10


    sykkel1.skriv_ut() #kjør skriv_ut() metoden på sykkel 1
    sykkel2.skriv_ut() #kjør skriv_ut() metoden på sykkel 2s
    sykkel3.skriv_ut() #kjør skriv_ut() metoden på sykkel 3

    print()


hovedprogram()

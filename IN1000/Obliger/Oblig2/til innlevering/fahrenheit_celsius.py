"""
Dette programmet ber brukeren om en fahrenheit verdi og gjør den om til celsius.
"""

#Spør brukeren om et input, i dette tilfelle Fahrenheit. Bruker int så input er heltall og ikke streng.
fahr = int(input("skriv inn fahrenheit: "))

#Skriver ut input i en setning. Bruker også str
print("temperatur: " + str(fahr) + "°F")
print()

#Regner ut celsius ut ifra formelen og lagrer i variabelen cels
cels = (fahr-32)*5/9

#Skriver ut celsius
print("temperatur i celsus: " + str(cels) + "°C")

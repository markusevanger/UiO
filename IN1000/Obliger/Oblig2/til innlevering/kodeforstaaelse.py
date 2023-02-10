"""
Programmet vil ikke kjøre fordi:
1.  b er en integer og den blandes med en streng.
    For å fikse det må vi skrive str(b) i den siste kodelinja.
    Dette gjør b om til en streng.

2.  print er ikke innrykket,
    Innrykk er måten python viser at linjer henger sammen.
    Dermed, for python, virker det som det ikke følger noe etter if linja.

"""
#Dette er den originale koden som ikke fungerer.

a = input("Tast inn et heltall! ")
b = int(a)
if b < 10:
print (b + "Hei!")


#Slik skal koden se ut for å fungere

a = input("Tast inn et heltall! ")
b = int(a)
if b < 10:
    print (str(b) + " Hei!")

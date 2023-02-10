
#Her er ordboken over varene i butikken
mat = {

"melk" : 14.90,
"brød" : 24.90,
"yoghurt" : 12.90,
"pizza" : 39.90

}

#Skriver ut oversikten til terminalen
print()
print("Her er maten og prisene vi har (kr).")
print(mat)
print()

#Ber om to varer og hvilken pris de har.
vare1 = input("Ny vare 1: ")
pris1 = input("Pris på vare 1: ")

vare2 = input("Ny vare 2: ")
pris2 = input("Pris på vare 2: ")

#Legger til varene og hvilken pris de har (vare=nøkkelord, pris=verdi )
mat[vare1]=pris1
mat[vare2]=pris2

#Skriver ut den nye listen. 
print()
print("Her er den nye oversikten:")
print(mat)

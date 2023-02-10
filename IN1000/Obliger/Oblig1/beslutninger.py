"""
Dette programmet spør om bruker vil ha brus og gir
tilbakemelding basert på responsen ja eller nei.
Er svaret ikke ja eller nei, gir den en feilmelding.
"""

#Skriver ut "Hei!", med litt mellomrom over
print()
print("Hei!")

#Spør om bruker vil ha brus, og lagrer svaret som svar i variabelen "svar".
svar = input("Vil du ha brus? (ja/nei): ")
print()

#Om svaret er ja, skriver programmet ut "Her har du en brus!" til terminalen.
if svar == "ja":
    print("Her har du en brus!")

#Er svaret nei, kommer det et svar. Passer ikke svaret hopper svaret til neste linje.
elif svar == "nei":
    print("Den er grei :(")

else:
    print("Det forstod jeg ikke helt!")

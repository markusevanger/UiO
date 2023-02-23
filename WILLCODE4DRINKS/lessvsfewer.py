
# count nouns = katter, hunder <c>
# mass nouns = vann ... kan ikke bli telt. <m>

# <c> or <m> = begge

# first line:
# n = number of nouns
# p = number of phrases

# following lines:
# noun


dict = {

    "c" : ["number of", "fewest", "more", "fewer", "many", "few"],
    "m" : ["amount of", "most", "least", "more", "less", "much", "little"]
}


np = input().strip().split(" ") # 4 5

n = int(np[0]) # 4
p = int(np[1]) # 5
 
nouns = {}
liste = []

for i in range(n): # for i in range 4
    noun = input().strip().split(" ") 
    nouns[noun[0]] = noun[1] #nouns {people : c}


for i in range(p): # people er c, er less c? for i in range 5
    
    phrase = input().strip().split(" ") #less people
    liste.append(phrase)


for i in liste:
    
    if len(i) > 2: 
        i[0] = i[0] + " " + i[1]
        i.pop(1)

    
    if i[0] in dict[nouns[i[1]]]:
        print("Correct!")

    else:
        print("Not on my watch!")


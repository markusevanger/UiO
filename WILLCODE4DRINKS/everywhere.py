antall_r = int(input())

for r in range(antall_r):
    
    liste = []
    antall_b = int(input())

    for b in range(antall_b):
        by = input()
        liste.append(by)
    
ting = set(liste)
print(len(ting))
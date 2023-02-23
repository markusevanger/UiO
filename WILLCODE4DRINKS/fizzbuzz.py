

inp = input()
inp = inp.strip().split(" ")

x = int(inp[0])
y = int(inp[1])
n = int(inp[2])




for i in range(1, n+1):
    
    if i%x == 0 and i%y == 0:
        print("FizzBuzz")
    elif i%x == 0:
        print("Fizz")
    elif i%y == 0:
        print("Buzz")
    else:
        print(i)
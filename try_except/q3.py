import os
os.system("cls")

while True:
    try:
        num = int(input("Digite o número pra tabuada -->> "))
        
        for i in range(1, 11):
            print(f"{num} x {i} = {num * i}")
        break
    except :
        print("Dado inválido. Por favor, digite um número inteiro.")
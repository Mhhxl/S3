import os
os.system('cls || clear')


nomes = []

for i in range (5):
    nome = input("Digite seu nome -->> ")
    nomes.append(nome)
    
    nomes.sort()
    
print(f"Os nomes em ordem alfabética ")
print(nomes)


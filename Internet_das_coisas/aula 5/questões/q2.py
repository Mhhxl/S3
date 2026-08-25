import os
from random import choice

nomes = []

for i in range(10):
    nome = input("Digite um nome -->> ")
    nomes.append(nome)
    

print(f"o nome escolhido foi {choice(nomes)}")
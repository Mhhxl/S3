import os
os.system('cls || clear ')

numeros = []

while True:
    num = int(input(f"Digite o número:"))
    if num != 0:
        numeros.append(num)
    else:
        break
    
soma = sum(numeros)

print(f"A soma de todos os números dentro do vetor é = {soma}")



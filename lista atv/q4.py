import os
os.system("cls || clear ")

numeros = [12, 7, 9, 20, 31, 44, 18, 5]


pares = 0
impares = 0


for numero in numeros:
    if numero % 2 == 0:
        pares += 1
    else:
        impares += 1


print(f"Quantidade de números pares: {pares}")
print(f"Quantidade de números ímpares: {impares}")
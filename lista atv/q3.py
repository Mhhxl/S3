import os
os.system("cls || clear ")


numeros = []


for i in range(6):
    numero = int(input(f"Digite o {i + 1}º número inteiro: "))
    numeros.append(numero)


soma = sum(numeros)
maior = max(numeros)
menor = min(numeros)
numeros.sort() 


print("\n--- Resultado da Análise ---")
print(f"Soma de todos os números: {soma}")
print(f"Maior valor digitado: {maior}")
print(f"Menor valor digitado: {menor}")
print(f"Números em ordem crescente: {numeros}")
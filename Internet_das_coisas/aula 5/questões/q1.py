import os
os.system('cls || clear ')

numeros = []
positivos = 0
negativos = 0



for i in range(10):
    num = int(input("Digite o número -->> "))
    numeros.append(num)
    
    if num >= 0:
        positivos += 1
    else:
        negativos += 1

soma =  sum(numeros)

print(f"Quantidade de números positivos = {positivos}")
print(f"Quantidade de números negativos = {negativos}")
print(f"A soma dos números dentro do vetor é = {soma}")
        
        
    
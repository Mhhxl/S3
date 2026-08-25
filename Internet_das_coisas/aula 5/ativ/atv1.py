# arrays em python, eu foquei tanto em java q tenho esquecido como é a sintaxe de python 


import os
os.system('cls || clear')

temperaturas = []

for i in range(5):
    temp = float(input(f"Digite a {i+1}° temperatura -->> "))
    temperaturas.append(temp)
    
media = sum(temperaturas) / len(temperaturas) 
menor = min(temperaturas)
maior = max(temperaturas)


print(f'A média dos valores das temperaturas é = {media}ºC')
print(f"A maior temperatura do dia é = {maior}ºC ")
print(f"A menor temperatura do dia é = {menor:.2f}ºC ")

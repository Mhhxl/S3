import os

notas = []

for i in range(8):
    n = float(input(f"Digite a {i +1}º nota -->> "))
    notas.append(n)
    
media = sum(notas)/len(notas)

for espiao in notas:
    if (espiao >= media):
        print(espiao,end='-')

print(f'\n A média da turma é {media:.1f}')  
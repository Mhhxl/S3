import os
os.system("cls || clear ")

notas = []


while True:
    nota = float(input("Digite uma nota (ou -1 para encerrar): "))
    
    if nota == -1:
        break
        
    notas.append(nota)


if len(notas) > 0:

    print("\n--- Notas Cadastradas ---")
    for idx, n in enumerate(notas, 1):
        print(f"Nota {idx}: {n}")


    quantidade = len(notas)
    soma = sum(notas)
    media = soma / quantidade
    maior = max(notas)
    menor = min(notas)


    notas.sort(reverse=True)


    print("\n--- Análise Final ---")
    print(f"Quantidade de notas: {quantidade}")
    print(f"Média das notas: {media:.2f}")
    print(f"Maior nota: {maior}")
    print(f"Menor nota: {menor}")
    print(f"Notas em ordem decrescente: {notas}")
else:
    print("\nNenhuma nota foi cadastrada.")
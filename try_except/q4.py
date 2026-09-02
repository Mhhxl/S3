import os
os.system("cls")

while True:
    try:
        soma = 0
        for i in range(3):
            nota = int(input(f"Digite a nota {i + 1}° -->> "))
            soma += nota
        media = soma / 3
        print(f"A média das notas é: {media:.2f}")
        if media >= 7:
            print("Aluno aprovado!")
            break
        elif media >= 5:
            print("Aluno em recuperação.")
            break
        else:
            print("Aluno reprovado.")
        break
    except:
        print("Dado inválido. Por favor, digite um número válido.")
import os
os.system("cls || clear ")
import random



numero_secreto = random.randint(1, 20)
tentativas = 0

print("--- Jogo de Adivinhação ---")
print("Tente adivinhar o número secreto entre 1 e 20!")

while True:
    palpite = int(input("\nDigite o seu palpite: "))
    tentativas += 1

    if palpite < numero_secreto:
        print("O número secreto é MAIOR.")
    elif palpite > numero_secreto:
        print("O número secreto é MENOR.")
    else:
        print(f"\nParabéns! Você acertou o número {numero_secreto}!")
        print(f"Total de tentativas: {tentativas}")
        break
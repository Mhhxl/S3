import os
os.system("cls")

while True:
    try: 
        num1= int(input("Digite o primeiro número: "))
        num2= int(input("Digite o segundo número: "))
        
        soma = num1 + num2
        print(f"A soma dos números é: {soma}")
        break
    except ValueError:
        print("Dado inválido. Por favor, digite números inteiros.")
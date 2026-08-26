import os
import time
os.system("cls || clear ")

def limpar():
    os.system("cls || clear")

while True:
    senha = input("Cadastre a senha")
    if (len(senha) == 4 and senha.isdigit()):
        print('Senha cadastrada com Sucesso')
        break
    else:
        print("Senha inválida ")
        time.sleep(3)
        limpar()
import os
os.system("cls || clear")

convidados = []


while True:
    nome = input("Digite o nome do convidado (ou 'fim' para encerrar): ")
    

    if nome.lower() == 'fim':
        break
        
    convidados.append(nome)


convidados.sort()


print("\n--- Lista de Convidados ---")
print(f"Lista organizada em ordem alfabética: {convidados}")
print(f"Total de convidados cadastrados: {len(convidados)}")
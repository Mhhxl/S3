import os
os.system("cls || clear")
produtos = []


for i in range(5):
    produto = input(f"Digite o nome do produto {i + 1}: ")
    produtos.append(produto)


print("\nLista completa de produtos cadastrados:")
print(produtos)

print(f"\nQuantidade total de produtos cadastrados: {len(produtos)}")
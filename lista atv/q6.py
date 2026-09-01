import os
os.system("cls || clear")


tarefas = []

while True:
    
    
    opcao = input("""==MENU== 
    1- Adicionar tarefas
    2- Remover tarefas
    3- Mostrar tarefas 
    4- Sair
    --->> """)

 
    if opcao == '1':
        nova_tarefa = input("Digite a tarefa a ser adicionada: ")
        tarefas.append(nova_tarefa)
        print(f"Tarefa '{nova_tarefa}' adicionada com sucesso!")

    
    elif opcao == '2':
        if len(tarefas) == 0:
            print("A lista está vazia! Não há tarefas para remover.")
        else:
            tarefa_remover = input("Digite o nome exato da tarefa que deseja remover: ")
            if tarefa_remover in tarefas:
                tarefas.remove(tarefa_remover)
                print(f"Tarefa '{tarefa_remover}' removida com sucesso!")
            else:
                print("Tarefa não encontrada na lista.")

    
    elif opcao == '3':
        if len(tarefas) == 0:
            print("Nenhuma tarefa cadastrada no momento.")
        else:
            print("\nLista de Tarefas:")
            for i, tarefa in enumerate(tarefas, 1):
                print(f"{i}. {tarefa}")

    
    elif opcao == '0':
        print("Encerrando o Gerenciador de Tarefas. Até logo!")
        break

    #
    else:
        print("Opção inválida! Digite um número de 0 a 3.")
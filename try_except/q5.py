try:
    
    saldo = float(input("Digite seu saldo: "))
    saque = float(input("Digite o valor do saque: "))

    
    if saldo < 0 or saque <= 0:
        print("Erro: digite apenas valores numéricos positivos e um valor de saque maior que zero!")
    
    elif saque > saldo:
        print("Saldo insuficiente!")
    else:
    
        saldo_restante = saldo - saque
        print("Saque realizado com sucesso!")
        print(f"Saldo restante: {saldo_restante:.2f}")

except ValueError:
    
    print("Erro: digite apenas valores numéricos!")
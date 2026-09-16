import customtkinter as ctk

ctk.set_appearance_mode('Dark')

janela = ctk.CTk()
janela.geometry('500x480')  
janela.resizable(False, False)
janela.title("Calculadora de Viagem")


try:
    janela.iconbitmap("ExecutiveCar_Black_icon-icons.com_54904.ico")
except Exception:
    pass


def calcular():
    try:
        # Substitui vírgula por ponto para aceitar números decimais nos dois formatos
        dist = float(distancia.get().replace(',', '.'))
        cons = float(consumo.get().replace(',', '.'))
        preco = float(precoCombustivel.get().replace(',', '.'))

        if cons <= 0:
            resultado.configure(text="O consumo deve ser maior que zero!", text_color="red")
            return

    
        litros_necessarios = dist / cons
        custo_total = litros_necessarios * preco

    
        resultado.configure(
            text=f"Total: R$ {custo_total:.2f}\n(Consumo: {litros_necessarios:.1f} Litros)",
            text_color="#4D28F0"
        )
    except ValueError:
    
        resultado.configure(text="Preencha todos os campos apenas com números!", text_color="red")

# Corpo da janela
titulo = ctk.CTkLabel(janela,
                    text='Calculadora de Viagem',
                    text_color='#4D28F0',
                    font=('Arial', 30))
titulo.pack(pady=(20, 0))

distancia = ctk.CTkEntry(janela,
                    width=400,
                    height=40,
                    border_color='#4D28F0',
                    placeholder_text='Digite a distância da viagem em KM')
distancia.pack(pady=15)

consumo = ctk.CTkEntry(janela,
                    width=400,
                    height=40,
                    border_color='#4D28F0',
                    placeholder_text='Digite o consumo do seu veículo (km/L)')
consumo.pack(pady=15)

precoCombustivel = ctk.CTkEntry(janela,
                    width=400,
                    height=40,
                    border_color='#4D28F0',
                    placeholder_text='Digite o valor atual do combustível (R$)')
precoCombustivel.pack(pady=15)

# Adicionado command=calcular para vincular o botão à função
botaoCalcular = ctk.CTkButton(janela,
                            width=200,
                            height=40,
                            text='Calcular Gasto',
                            fg_color='#4D28F0',
                            text_color='White',
                            cursor='hand2',
                            font=('Arial', 18),
                            command=calcular)
botaoCalcular.pack(pady=15)


resultado = ctk.CTkLabel(janela,
                        text="",
                        font=('Arial', 18, 'bold'))
resultado.pack(pady=10)

janela.mainloop()
import customtkinter as ctk
from tkinter import messagebox

ctk.set_appearance_mode("Dark")
ctk.set_default_color_theme("blue")

class ReservaHotel(ctk.CTk):
    def __init__(self):
        super().__init__()

        # Configuração da Janela
        self.title("Sistema de Reserva de Hotel")
        self.geometry("450x550")
        self.configure(fg_color="#222222")
        self.resizable(False, False)


        YELLOW_COLOR = "#FFFF00"
        DARK_BG = "#2D2D2D"

        # Título
        self.label_titulo = ctk.CTkLabel(
            self, 
            text="Reserva de Hotel", 
            font=("Arial", 28, "bold"),
            text_color=YELLOW_COLOR
        )
        self.label_titulo.pack(pady=(25, 20))

        #Nome do Hóspede
        self.entry_nome = ctk.CTkEntry(
            self,
            placeholder_text="Digite o nome do hóspede",
            placeholder_text_color="#888888",
            fg_color=DARK_BG,
            text_color="#FFFFFF",
            border_color=YELLOW_COLOR,
            border_width=2,
            corner_radius=10,
            width=360,
            height=40,
            font=("Arial", 14)
        )
        self.entry_nome.pack(pady=10)

        #Quantidade de Diárias
        self.entry_diarias = ctk.CTkEntry(
            self,
            placeholder_text="Digite a quantidade de diárias",
            placeholder_text_color="#888888",
            fg_color=DARK_BG,
            text_color="#FFFFFF",
            border_color=YELLOW_COLOR,
            border_width=2,
            corner_radius=10,
            width=360,
            height=40,
            font=("Arial", 14)
        )
        self.entry_diarias.pack(pady=10)

        #Valor da Diária
        self.entry_valor = ctk.CTkEntry(
            self,
            placeholder_text="Digite o valor da diária (R$)",
            placeholder_text_color="#888888",
            fg_color=DARK_BG,
            text_color="#FFFFFF",
            border_color=YELLOW_COLOR,
            border_width=2,
            corner_radius=10,
            width=360,
            height=40,
            font=("Arial", 14)
        )
        self.entry_valor.pack(pady=10)

        # Botão de Cálculo
        self.btn_calcular = ctk.CTkButton(
            self,
            text="CALCULAR HOSPEDAGEM",
            fg_color=YELLOW_COLOR,
            hover_color="#E6E600",
            text_color="#000000",
            font=("Arial", 14, "bold"),
            corner_radius=10,
            width=240,
            height=42,
            command=self.calcular_hospedagem
        )
        self.btn_calcular.pack(pady=(20, 10))

    def formatar_moeda(self, valor: float) -> str:
        """Converte valor numérico float para formato moeda (R$ X.XXX,XX)."""
        return f"R$ {valor:,.2f}".replace(",", "X").replace(".", ",").replace("X", ".")

    def calcular_hospedagem(self):
        try:
            nome = self.entry_nome.get().strip()
            diarias = int(self.entry_diarias.get())
            valor_diaria = float(self.entry_valor.get().replace(",", "."))

            # Validação para impedir valores nulos ou negativos
            if diarias <= 0 or valor_diaria <= 0:
                raise ValueError("Os valores devem ser maiores que zero.")

            # Cálculos das diárias e descontos
            hospedagem = diarias * valor_diaria
            desconto = hospedagem * 0.10 if diarias >= 5 else 0.0
            total = hospedagem - desconto

            # Formatação do texto do pop-up
            hospede_str = f"Hóspede: {nome}\n\n" if nome else ""
            desconto_str = f"Desconto (10%): {self.formatar_moeda(desconto)}\n" if desconto > 0 else "Desconto: Sem desconto\n"

            mensagem = (
                f"{hospede_str}"
                f"Diárias: {diarias}\n"
                f"Valor da Hospedagem: {self.formatar_moeda(hospedagem)}\n"
                f"{desconto_str}"
                f"-----------------------------\n"
                f"Total a Pagar: {self.formatar_moeda(total)}"
            )

            # Exibe o resumo do cálculo 
            messagebox.showinfo("Resumo da Reserva", mensagem)

        except ValueError:
            messagebox.showerror(
                "Erro de Digitação",
                "Por favor, insira números válidos maiores que zero para diárias e valor."
            )

if __name__ == "__main__":
    app = ReservaHotel()
    app.mainloop()
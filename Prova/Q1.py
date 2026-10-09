import customtkinter as ctk
from tkinter import messagebox

ctk.set_appearance_mode("Dark")
ctk.set_default_color_theme("blue")

class ResultadoAcademico(ctk.CTk):
    def __init__(self):
        super().__init__()

        # Configuração da Janela
        self.title("Resultado Acadêmico")
        self.geometry("450x520")
        self.configure(fg_color="#222222")
        self.resizable(False, False)

        # Paleta de Cores e Estilos Globais
        YELLOW_COLOR = "#FFFF00"
        DARK_BG = "#2D2D2D"

        # Título
        self.label_titulo = ctk.CTkLabel(
            self, 
            text="Resultado Acadêmico", 
            font=("Arial", 28, "bold"),
            text_color=YELLOW_COLOR
        )
        self.label_titulo.pack(pady=(25, 20))

        # Campo: Nome do Aluno
        self.entry_nome = ctk.CTkEntry(
            self,
            placeholder_text="Digite o nome do aluno",
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

        # Campo: Nota 1
        self.entry_nota1 = ctk.CTkEntry(
            self,
            placeholder_text="Digite a Nota 1",
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
        self.entry_nota1.pack(pady=10)

        # Campo: Nota 2
        self.entry_nota2 = ctk.CTkEntry(
            self,
            placeholder_text="Digite a Nota 2",
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
        self.entry_nota2.pack(pady=10)

        # Botão de Cálculo
        self.btn_calcular = ctk.CTkButton(
            self,
            text="CALCULAR RESULTADO",
            fg_color=YELLOW_COLOR,
            hover_color="#E6E600",
            text_color="#000000",
            font=("Arial", 14, "bold"),
            corner_radius=10,
            width=220,
            height=42,
            command=self.calcular_resultado
        )
        self.btn_calcular.pack(pady=(20, 10))

    def calcular_resultado(self):
        try:
            nome = self.entry_nome.get().strip()
            
            # Converte vírgula para ponto e converte para float
            nota1 = float(self.entry_nota1.get().replace(",", "."))
            nota2 = float(self.entry_nota2.get().replace(",", "."))

            # Cálculo da média
            media = (nota1 + nota2) / 2

            # Definição da situação
            if media < 5.0:
                situacao = "REPROVADO(A)"
            elif 5.0 <= media <= 6.9:
                situacao = "em RECUPERAÇÃO"
            else:
                situacao = "APROVADO(A)"

            # Identificação do aluno na mensagem 
            aluno_str = f"Aluno(a): {nome}\n" if nome else ""

            # Exibe o resultado final
            messagebox.showinfo(
                "Resultado Final", 
                f"{aluno_str}Média: {media:.1f}\nSituação: {situacao}"
            )

        except ValueError:
            messagebox.showerror(
                "Erro de Digitação", 
                "Por favor, insira valores numéricos válidos para ambas as notas."
            )

if __name__ == "__main__":
    app = ResultadoAcademico()
    app.mainloop()
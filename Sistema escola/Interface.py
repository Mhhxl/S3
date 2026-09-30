import customtkinter as ctk
from tkinter import messagebox


ctk.set_appearance_mode("Dark")
ctk.set_default_color_theme("blue")

class SistemaEscolar(ctk.CTk):
    def __init__(self):
        super().__init__()

        
        self.title("Sistema Escolar 2026")
        self.geometry("600 x 450")
        self.configure(fg_color="#222222")  
        self.resizable(False, False)

        
        YELLOW_COLOR = "#FFFF00"
        DARK_BG = "#2D2D2D"

        # Título
        self.label_titulo = ctk.CTkLabel(
            self, 
            text="Sistema Escola", 
            font=("Arial", 32, "bold"),
            text_color=YELLOW_COLOR
        )
        self.label_titulo.pack(pady=(25, 20))

        
        self.entry_nota1 = ctk.CTkEntry(
            self,
            placeholder_text="Digite a sua nota na 1ª Unidade",
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
        self.entry_nota1.pack(pady=12)

        
        self.entry_nota2 = ctk.CTkEntry(
            self,
            placeholder_text="Digite a sua nota na 2ª Unidade",
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
        self.entry_nota2.pack(pady=12)

        
        self.entry_nota3 = ctk.CTkEntry(
            self,
            placeholder_text="Digite a sua nota na 3ª Unidade",
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
        self.entry_nota3.pack(pady=12)

        
        self.btn_resultado = ctk.CTkButton(
            self,
            text="Resultado",
            fg_color=YELLOW_COLOR,
            hover_color="#E6E600",
            text_color="#000000",
            font=("Arial", 14, "bold"),
            corner_radius=10,
            width=180,
            height=38,
            command=self.calcular_resultado
        )
        self.btn_resultado.pack(pady=(20, 10))

    def calcular_resultado(self):
        try:
        
            n1 = float(self.entry_nota1.get().replace(",", "."))
            n2 = float(self.entry_nota2.get().replace(",", "."))
            n3 = float(self.entry_nota3.get().replace(",", "."))

            media = (n1 + n2 + n3) / 3

            
            if media >= 7.0:
                status = "Aprovado(a)!"
            elif media >= 5.0:
                status = "em Recuperação."
            else:
                status = "Reprovado(a)."

            messagebox.showinfo(
                "Resultado final", 
                f"Média: {media:.2f}\nStatus: Aluno(a) {status}"
            )

        except ValueError:
            messagebox.showerror(
                "Erro", 
                "Por favor, insira números válidos para todas as notas."
            )

if __name__ == "__main__":
    app = SistemaEscolar()
    app.mainloop()
#importa a biblioteca do customtkinter e qrcode
#pip install customtkinter, qrcode, pillow
import customtkinter as ctk
import qrcode
from PIL import Image, ImageTk


ctk.set_appearance_mode("dark")

#janela
janela = ctk.CTk()
janela.title("Gerador de QR Code")
janela.geometry("500x400")
janela.resizable(False, False)


imagem_qr = None

def gerar_qr_code(texto):
    global imagem_qr
    if texto:
        qr = qrcode.QRCode(
            version=1,
            error_correction=qrcode.constants.ERROR_CORRECT_L,
            box_size=10,
            border=4,
        )
        qr.add_data(texto)
        qr.make(fit=True)

        img = qr.make_image(fill_color="black", back_color="white")
        img = img.resize((200, 200))
        imagem_qr = ImageTk.PhotoImage(img)

        resultado_label.configure(image=imagem_qr, text="")
    else:
        resultado_label.configure(text="Por favor, digite um texto ou link.", image="")


#elementos da interface
label_titulo = ctk.CTkLabel(janela, text="Gerador de QR Code", font=("Arial", 20))
label_titulo.pack(pady=20)

entrada = ctk.CTkEntry(janela, placeholder_text="Digite o texto ou link")
entrada.pack(pady=10)


botao= ctk.CTkButton(janela, text="Gerar QR Code", command=lambda: gerar_qr_code(entrada.get()))
botao.pack(pady=10)

resultado_label = ctk.CTkLabel(janela, text="")
resultado_label.pack(pady=20)




janela.mainloop()
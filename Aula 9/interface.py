import customtkinter as ctk #importo uma biblioteca e coloco um apelido nela, nesse caso é ctk
ctk.set_appearance_mode('Dark')
#janela

janela = ctk.CTk() #crio a janela
janela.geometry('600x500') #coloco o tamanho da janela
janela.resizable(False, False) # bloqueia o coiso do tamanho da janela q eu esqueci o nome
janela.title("Sistema de Acesso") # coloca o nome na barra de título
janela.iconbitmap('unlock_protection_safety_secure_password_access_keyboard_key_icon_262113.ico') # o icone 

#------------------------
#corpo da janela
titulo = ctk.CTkLabel(janela,# esse comando cria textos
                    text= "Sistema de Login",
                    text_color= "#4D28F0",
                    font=('Arial', 30))
titulo.pack(pady = 40) #abrir um componente ( o pady é pra se afastar do componente de cima ou de baixo)



login = ctk.CTkEntry(janela,
                    width = 400,
                    height = 40,
                    border_color = '#4D28F0',
                    placeholder_text = 'Digite seu login',)
login.pack()



senha = ctk.CTkEntry(janela,
                    width = 400,
                    height = 40,
                    border_color = '#4D28F0',
                    placeholder_text = 'Digite sua senha',
                    show = '*')
senha.pack(pady = 40)



botao = ctk.CTkButton(janela,
                    width = 400,
                    height = 40,
                    text = 'Acessar',
                    fg_color='#4D28F0',
                    text_color= 'White',
                    cursor = 'hand2',
                    font= ('arial', 30))
botao.pack()








janela.mainloop() # <<<---- #comando que da start na janela (sempre na ultima linha)
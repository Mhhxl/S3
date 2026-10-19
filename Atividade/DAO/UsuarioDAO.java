package DAO;
import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static List<Usuario> usuarios = new ArrayList<>();

    static {
        // Usuário padrão para testar a autenticação
        usuarios.add(new Usuario("admin", "1234"));
    }

    public Usuario autenticar(String login, String senha) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }
}
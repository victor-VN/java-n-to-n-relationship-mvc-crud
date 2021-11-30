package victorvn.controller;

import android.content.Context;

import java.util.List;

import victorvn.dao.UsuarioChatDAO;
import victorvn.model.Chat;
import victorvn.model.Usuario;
import victorvn.model.UsuarioChat;

public class UsuarioChatController {

    UsuarioChatDAO usuarioChatDAO;

    public UsuarioChatController(Context context){

      usuarioChatDAO = new UsuarioChatDAO(context);
    }

    public UsuarioChat inserirUsuarioNoChat(Usuario usuario, Chat chat){
        return usuarioChatDAO.inserirUsuarioNoChat(usuario, chat);
    }

    public UsuarioChat removerUsuarioDoChat(int id){
        return usuarioChatDAO.removerUsuarioDoChat(id);
    }

    public List<Chat> listarChatsDoUsuario(int usuarioId){
        return usuarioChatDAO.listarChatsUsuario(usuarioId);
    }
}

package victorvn.controller;

import android.content.Context;

import java.util.List;

import victorvn.dao.ChatDAO;
import victorvn.dao.UsuarioDAO;
import victorvn.model.Chat;
import victorvn.model.Usuario;

public class ChatController {

    ChatDAO chatDAO;

    public ChatController(Context context){
        this.chatDAO = new ChatDAO(context);
    }

    public Chat salvar(Chat chat){
        return chatDAO.salvar(chat);
    }

    public Chat atualizar(Chat chat){
        return chatDAO.atualizar(chat);
    }

    public Chat excluir(Chat chat){
        return chatDAO.excluir(chat);
    }

    public List<Chat> listarTodos(){
        return chatDAO.listarTodos();
    }

    public Chat listarPorId(int id){
        return chatDAO.listarPorId(id);
    }
}

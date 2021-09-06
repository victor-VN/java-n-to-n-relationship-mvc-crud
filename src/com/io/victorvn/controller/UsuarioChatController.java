package com.io.victorvn.controller;

import com.io.victorvn.dao.UsuarioChatDAO;
import com.io.victorvn.model.Chat;
import com.io.victorvn.model.Usuario;
import com.io.victorvn.model.UsuarioChat;

import java.util.List;

public class UsuarioChatController {

    UsuarioChatDAO usuarioChatDAO = new UsuarioChatDAO();

    public String adicionarUsuarioNoChat(UsuarioChat usuarioChat){
        return usuarioChatDAO.save(usuarioChat);
    }

    public String removerUsuarioDoChat(int usuarioId, int chatId){
        return usuarioChatDAO.delete(usuarioId, chatId);
    }

    public List<Usuario> listarTodosUsuariosDoChat(int id){
        return usuarioChatDAO.getAllUsuariosFromChat(id);
    }

    public List<Chat> listarTodosChatsDoUsuario(int id){
        return usuarioChatDAO.getAllChatsFromUsuario(id);
    }
}

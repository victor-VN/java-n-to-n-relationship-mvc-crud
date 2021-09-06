package com.io.victorvn.controller;

import com.io.victorvn.dao.ChatDAO;
import com.io.victorvn.model.Chat;

import java.util.List;

public class ChatController {

    ChatDAO chatDAO = new ChatDAO();

    public String cadastrarChat(Chat chat){
        return chatDAO.save(chat);
    }

    public String atualizarChat(Chat chat){
        return chatDAO.update(chat);
    }

    public Chat buscarChatPorId(int id){
        return chatDAO.getById(id);
    }

    public List<Chat> buscarChatPeloNome(String nome){
        return chatDAO.getByName(nome);
    }

    public List<Chat> buscarTodosChats(){
        return chatDAO.getAll();
    }

    public String deletarChat(int id) {
        return chatDAO.delete(id);
    }
}

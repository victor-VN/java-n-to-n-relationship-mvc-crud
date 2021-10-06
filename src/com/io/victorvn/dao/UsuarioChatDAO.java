package com.io.victorvn.dao;

import com.io.victorvn.config.ConexaoDB;
import com.io.victorvn.model.Chat;
import com.io.victorvn.model.Usuario;
import com.io.victorvn.model.UsuarioChat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioChatDAO {

    public UsuarioChat save(UsuarioChat usuarioChat){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "INSERT INTO usuario_chat VALUES (DEFAULT,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, usuarioChat.getUsuario().getId());
            preparedStatement.setInt(2, usuarioChat.getChat().getId());
            preparedStatement.setString(3, usuarioChat.getFavorito());
            preparedStatement.setString(4, usuarioChat.getAdmin());


            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return usuarioChat;
            } else {
                preparedStatement.close();
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }

    public Integer delete(int usuarioId, int chatId){
        try {
            Connection connection = ConexaoDB.getConnection();
            String query = "DELETE FROM usuario_chat WHERE usuario_chat.id_usuario = ? AND usuario_chat.id_chat = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, usuarioId);
            preparedStatement.setInt(2, chatId);

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return usuarioId;
            } else {
                preparedStatement.close();
                return null;
            }


        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<Usuario> getAllUsuariosFromChat(int chatId){

        try {
            Connection connection = ConexaoDB.getConnection();
            List<Usuario> usuarioList;
            String query = "select * from usuario where usuario.id in (select usuario_chat.id_usuario from usuario_chat where usuario_chat.id_chat = ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, chatId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Esse chat está vazio.");
            }

            usuarioList = new ArrayList<>();
            while(resultSet.next()){

                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(resultSet.getString(1)));
                usuario.setNome(resultSet.getString(2));
                usuario.setEmail(resultSet.getString(3));
                usuario.setAvatar(resultSet.getString(4));
                usuario.setDescricao(resultSet.getString(5));

                usuarioList.add(usuario);
            }

            resultSet.close();
            preparedStatement.close();
            return usuarioList;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }

    }

    public List<Chat> getAllChatsFromUsuario(int usuarioId){

        try {
            Connection connection = ConexaoDB.getConnection();
            List<Chat> chatList;
            String query = "select * from chat where chat.id in (select usuario_chat.id_chat from usuario_chat where usuario_chat.id_usuario = ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, usuarioId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Esse usuário não participa de nenhum chat.");
            }

            chatList = new ArrayList<>();
            while(resultSet.next()){

                Chat chat = new Chat();
                chat.setId(Integer.parseInt(resultSet.getString(1)));
                chat.setNome(resultSet.getString(2));
                chat.setStatus(resultSet.getString(3));
                chat.setCapacidade(Integer.parseInt(resultSet.getString(4)));
                chat.setAssunto(resultSet.getString(5));

                chatList.add(chat);
            }

            resultSet.close();
            preparedStatement.close();
            return chatList;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }

    }
}

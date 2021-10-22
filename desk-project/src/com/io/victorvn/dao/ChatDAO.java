package com.io.victorvn.dao;

import com.io.victorvn.config.ConexaoDB;
import com.io.victorvn.model.Chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChatDAO {

    public Chat save(Chat chat){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "INSERT INTO chat VALUES (DEFAULT,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, chat.getNome());
            preparedStatement.setString(2, chat.getStatus());
            preparedStatement.setInt(3, chat.getCapacidade());
            preparedStatement.setString(4, chat.getAssunto());

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return chat;
            } else {
                preparedStatement.close();
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }

    public Chat update(Chat chat){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "UPDATE chat SET nome = ?, status_chat = ?, cap_max = ?, assunto = ?  where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, chat.getNome());
            preparedStatement.setString(2, chat.getStatus());
            preparedStatement.setInt(3, chat.getCapacidade());
            preparedStatement.setString(4, chat.getAssunto());
            preparedStatement.setInt(5, chat.getId());

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return chat;
            } else {
                preparedStatement.close();
                return null;
            }


        } catch (Exception e){
            return null;
        }
    }

    public List<Chat> getAll(){
        try {
            Connection connection = ConexaoDB.getConnection();
            List<Chat> chatList =  new ArrayList<>();
            String query = "SELECT * FROM chat";
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet == null){
                throw new RuntimeException("Nenhum chat foi encontrado na base de dados");
            }

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
            statement.close();
            return chatList;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return new ArrayList<>();
        }
    };

    public Chat getById(int id){
        try {
            Connection connection = ConexaoDB.getConnection();
            Chat chat = new Chat();
            String query = "SELECT * FROM chat WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Chat não encontrado na base de dados");
            }

            if(resultSet.next()){
                chat.setId(Integer.parseInt(resultSet.getString(1)));
                chat.setNome(resultSet.getString(2));
                chat.setStatus(resultSet.getString(3));
                chat.setCapacidade(Integer.parseInt(resultSet.getString(4)));
                chat.setAssunto(resultSet.getString(5));
            }

            resultSet.close();
            preparedStatement.close();
            return chat;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<Chat> getByName(String name){
        try {
            Connection connection = ConexaoDB.getConnection();
            List<Chat> chatList = new ArrayList<>();
            String query = "SELECT * FROM chat WHERE nome LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Nenhum chat com o nome: " + name + " foi encontrado");
            }

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
            return new ArrayList<>();
        }
    }

    public Integer delete(int id){
        try {
            Connection connection = ConexaoDB.getConnection();
            String query = "DELETE FROM chat WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return id;
            } else {
                preparedStatement.close();
                return null;
            }


        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}

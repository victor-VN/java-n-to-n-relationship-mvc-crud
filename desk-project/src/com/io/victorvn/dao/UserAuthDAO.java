package com.io.victorvn.dao;

import com.io.victorvn.config.ConexaoDB;
import com.io.victorvn.model.UserAuth;
import com.io.victorvn.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserAuthDAO {

    public UserAuth save(UserAuth userAuth){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "INSERT INTO usuario VALUES (DEFAULT,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, userAuth.getUsername());
            preparedStatement.setString(2, userAuth.getEmail());
            preparedStatement.setString(3, userAuth.getPasswordUsr());

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return userAuth;
            } else {
                preparedStatement.close();
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }

    public UserAuth update(UserAuth userAuth){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "UPDATE user_auth SET username = ?, email = ?, password_usr = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, userAuth.getUsername());
            preparedStatement.setString(2, userAuth.getEmail());
            preparedStatement.setString(3, userAuth.getPasswordUsr());

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return userAuth;
            } else {
                preparedStatement.close();
                return null;
            }


        } catch (Exception e){
            return null;
        }
    }

    public List<UserAuth> getAll(){
        try {
            Connection connection = ConexaoDB.getConnection();
            List<UserAuth> usuarioList;
            String query = "SELECT * FROM user_auth";
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet == null){
                throw new RuntimeException("Nenhum usuário foi encontrado na base de dados");
            }

            usuarioList = new ArrayList<>();
            while(resultSet.next()){
                UserAuth usuario = new UserAuth();

                usuario.setId(Integer.parseInt(resultSet.getString(1)));
                usuario.setUsername(resultSet.getString(2));
                usuario.setEmail(resultSet.getString(3));
                usuario.setPasswordUsr(resultSet.getString(4));

                usuarioList.add(usuario);
            }

            resultSet.close();
            statement.close();
            return usuarioList;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return new ArrayList<>();
        }
    };

    public UserAuth getById(int id){
        try {
            Connection connection = ConexaoDB.getConnection();
            UserAuth usuario = new UserAuth();
            String query = "SELECT * FROM user_auth WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Usuário não encontrado na base de dados");
            }

            if (resultSet.next()){
                usuario.setId(Integer.parseInt(resultSet.getString(1)));
                usuario.setUsername(resultSet.getString(2));
                usuario.setEmail(resultSet.getString(3));
                usuario.setPasswordUsr(resultSet.getString(4));
            }

            resultSet.close();
            preparedStatement.close();
            return usuario;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<UserAuth> getByName(String name){
        try {
            Connection connection = ConexaoDB.getConnection();
            List<UserAuth> usuarioList = new ArrayList<>();
            String query = "SELECT * FROM user_auth WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,  name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Nenhum usuário com o nome: " + name + " foi encontrado");
            }

            usuarioList = new ArrayList<>();
            while(resultSet.next()){
                UserAuth usuario = new UserAuth();

                usuario.setId(Integer.parseInt(resultSet.getString(1)));
                usuario.setUsername(resultSet.getString(2));
                usuario.setEmail(resultSet.getString(3));
                usuario.setPasswordUsr(resultSet.getString(4));

                usuarioList.add(usuario);
            }


            resultSet.close();
            preparedStatement.close();
            return usuarioList;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Integer delete(int id){
        try {
            Connection connection = ConexaoDB.getConnection();
            String query = "DELETE FROM user_auth WHERE id = ?";
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

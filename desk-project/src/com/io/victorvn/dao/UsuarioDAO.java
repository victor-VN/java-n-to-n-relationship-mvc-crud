package com.io.victorvn.dao;

import com.io.victorvn.config.ConexaoDB;
import com.io.victorvn.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public Usuario save(Usuario usuario){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "INSERT INTO usuario VALUES (DEFAULT,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getAvatar());
            preparedStatement.setString(4, usuario.getDescricao());

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return usuario;
            } else {
                preparedStatement.close();
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }

    public List<Usuario> save(List<Usuario> usuarioList){
        for (Usuario usuario : usuarioList){
            try {
                Connection connection = ConexaoDB.getConnection();

                String query = "INSERT INTO usuario VALUES (DEFAULT,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, usuario.getNome());
                preparedStatement.setString(2, usuario.getEmail());
                preparedStatement.setString(3, usuario.getAvatar());
                preparedStatement.setString(4, usuario.getDescricao());

                preparedStatement.executeUpdate();
            } catch (Exception e){
                return null;
            }
        }
        return null;
    }

    public Usuario update(Usuario usuario){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "UPDATE usuario SET nome = ?, email = ?, avatar = ?, descricao = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getAvatar());
            preparedStatement.setString(4, usuario.getDescricao());
            preparedStatement.setInt(5, usuario.getId());

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return usuario;
            } else {
                preparedStatement.close();
                return null;
            }


        } catch (Exception e){
            return null;
        }
    }

    public List<Usuario> getAll(){
        try {
            Connection connection = ConexaoDB.getConnection();
            List<Usuario> usuarioList = new ArrayList<>();
            String query = "SELECT * FROM usuario";
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet == null){
                throw new RuntimeException("Nenhum usuário foi encontrado na base de dados");
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
            statement.close();
            return usuarioList;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return new ArrayList<>();
        }
    };

    public Usuario getById(int id){
        try {
            Connection connection = ConexaoDB.getConnection();
            Usuario usuario = new Usuario();
            String query = "SELECT * FROM usuario WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Usuário não encontrado na base de dados");
            }

            if (resultSet.next()){
                usuario.setId(Integer.parseInt(resultSet.getString(1)));
                usuario.setNome(resultSet.getString(2));
                usuario.setEmail(resultSet.getString(3));
                usuario.setAvatar(resultSet.getString(4));
                usuario.setDescricao(resultSet.getString(5));
            }

            resultSet.close();
            preparedStatement.close();
            return usuario;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<Usuario> getByName(String name){
        try {
            Connection connection = ConexaoDB.getConnection();
            List<Usuario> usuarioList = new ArrayList<>();
            String query = "SELECT * FROM usuario WHERE nome LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Nenhum usuário com o nome: " + name + " foi encontrado");
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
            return new ArrayList<>();
        }
    }

    public Integer delete(int id){
        try {
            Connection connection = ConexaoDB.getConnection();
            String query = "DELETE FROM usuario WHERE id = ?";
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

package com.io.victorvn.dao;

import com.io.victorvn.config.ConexaoDB;
import com.io.victorvn.model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    public String save(Pessoa pessoa){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "INSERT INTO pessoa VALUES (DEFAULT,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getIdade());
            preparedStatement.setString(3, pessoa.getAltura());
            preparedStatement.setString(4, pessoa.getGenero());
            preparedStatement.setString(5, pessoa.getPeso());


            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return "Pessoa cadastrada com sucesso";
            } else {
                preparedStatement.close();
                return "Falha ao cadastrar usuário. Por favor consulte um ADMIN";
            }
        } catch (Exception e){
            return "ERRO: " + e.getMessage();
        }
    }

    public String update(Pessoa pessoa){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "UPDATE pessoa SET nome = ?, idade = ?, altura = ?, genero = ?, peso = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getIdade());
            preparedStatement.setString(3, pessoa.getAltura());
            preparedStatement.setString(4, pessoa.getGenero());
            preparedStatement.setString(5, pessoa.getPeso());
            preparedStatement.setInt(6, pessoa.getId());

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return "Pessoa atualizada com sucesso";
            } else {
                preparedStatement.close();
                return "Falha ao atualizar usuário. Por favor consulte um ADMIN";
            }


        } catch (Exception e){
            return "ERRO: " + e.getMessage();
        }
    }

    public List<Pessoa> getAll(){
        try {
            Connection connection = ConexaoDB.getConnection();
            List<Pessoa> pessoaList;
            String query = "SELECT * FROM pessoa";
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet == null){
                throw new RuntimeException("Nenhum usuário foi encontrado na base de dados");
            }


            pessoaList = generateListPessoaFromResultSet(resultSet);


            resultSet.close();
            statement.close();
            return pessoaList;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    };

    public Pessoa getById(int id){
        try {
            Connection connection = ConexaoDB.getConnection();
            Pessoa pessoa;
            String query = "SELECT * FROM pessoa WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Usuário não encontrado na base de dados");
            }

            pessoa = generatePessoaFromResultSet(resultSet);


            resultSet.close();
            preparedStatement.close();
            return pessoa;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<Pessoa> getByName(String name){
        try {
            Connection connection = ConexaoDB.getConnection();
            List<Pessoa> pessoaList;
            String query = "SELECT * FROM pessoa WHERE nome LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Nenhum usuário com o nome: " + name + " foi encontrado");
            }

            pessoaList = generateListPessoaFromResultSet(resultSet);


            resultSet.close();
            preparedStatement.close();
            return pessoaList;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public String delete(int id){
        try {
            Connection connection = ConexaoDB.getConnection();
            String query = "DELETE FROM pessoa WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return "Usuário excluído com sucesso!";
            } else {
                preparedStatement.close();
                return "Falha ao tentar excluir usuário. Procure o ADMIN";
            }


        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    private Pessoa generatePessoaFromResultSet(ResultSet resultSet) throws SQLException {

        Pessoa pessoa = new Pessoa();
        if(resultSet.next()){
            pessoa = generatePessoa(resultSet);
        }

        return pessoa;
    }

    private List<Pessoa> generateListPessoaFromResultSet(ResultSet resultSet) throws SQLException{

        List<Pessoa> pessoaList = new ArrayList<>();
        while(resultSet.next()){
            Pessoa pessoa = generatePessoa(resultSet);
            pessoaList.add(pessoa);
        }

        return pessoaList;
    }

    private Pessoa generatePessoa(ResultSet resultSet) throws SQLException{
        Pessoa pessoa = new Pessoa();
        pessoa.setId(Integer.parseInt(resultSet.getString(1)));
        pessoa.setNome(resultSet.getString(2));
        pessoa.setIdade(resultSet.getString(3));
        pessoa.setAltura(resultSet.getString(4));
        pessoa.setGenero(resultSet.getString(5));
        pessoa.setPeso(resultSet.getString(6));
        return pessoa;
    }

}

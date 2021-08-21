package com.io.victorvn.dao;

import com.io.victorvn.config.ConexaoDB;
import com.io.victorvn.model.Pet;
import com.io.victorvn.utils.ResultSetBuildingUtils;

import java.sql.*;
import java.util.List;

public class PetDAO {

    public String save(Pet pet){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "INSERT INTO pet VALUES (DEFAULT,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, pet.getNome());
            preparedStatement.setString(2, pet.getTipo());
            preparedStatement.setString(3, pet.getIdade());

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return "Pet cadastrado com sucesso";
            } else {
                preparedStatement.close();
                return "Falha ao cadastrar pet. Por favor consulte um ADMIN";
            }
        } catch (Exception e){
            return "ERRO: " + e.getMessage();
        }
    }

    public String update(Pet pet){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "UPDATE pet SET nome = ?, tipo = ?, idade = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, pet.getNome());
            preparedStatement.setString(2, pet.getTipo());
            preparedStatement.setString(3, pet.getIdade());
            preparedStatement.setInt(4, pet.getId());

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return "Pet atualizada com sucesso";
            } else {
                preparedStatement.close();
                return "Falha ao atualizar pet. Por favor consulte um ADMIN";
            }


        } catch (Exception e){
            return "ERRO: " + e.getMessage();
        }
    }

    public List<Pet> getAll(){
        try {
            Connection connection = ConexaoDB.getConnection();
            ResultSetBuildingUtils resultSetBuildingUtils = new ResultSetBuildingUtils();
            List<Pet> petList;
            String query = "SELECT * FROM pet";
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet == null){
                throw new RuntimeException("Nenhum pet foi encontrado na base de dados");
            }

            petList = resultSetBuildingUtils.generateListPetFromResultSet(resultSet);

            resultSet.close();
            statement.close();
            return petList;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    };

    public Pet getById(int id){
        try {
            Connection connection = ConexaoDB.getConnection();
            ResultSetBuildingUtils resultSetBuildingUtils = new ResultSetBuildingUtils();
            Pet pet;
            String query = "SELECT * FROM pet WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Pet não encontrado na base de dados");
            }

            pet = resultSetBuildingUtils.generatePetFromResultSet(resultSet);

            resultSet.close();
            preparedStatement.close();
            return pet;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<Pet> getByName(String name){
        try {
            Connection connection = ConexaoDB.getConnection();
            ResultSetBuildingUtils resultSetBuildingUtils = new ResultSetBuildingUtils();
            List<Pet> petList;
            String query = "SELECT * FROM pet WHERE nome LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Nenhum pet com o nome: " + name + " foi encontrado");
            }

            petList = resultSetBuildingUtils.generateListPetFromResultSet(resultSet);


            resultSet.close();
            preparedStatement.close();
            return petList;
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public String delete(int id){
        try {
            Connection connection = ConexaoDB.getConnection();
            String query = "DELETE FROM pet WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return "Pet excluído com sucesso!";
            } else {
                preparedStatement.close();
                return "Falha ao tentar excluir pet. Procure o ADMIN";
            }


        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}

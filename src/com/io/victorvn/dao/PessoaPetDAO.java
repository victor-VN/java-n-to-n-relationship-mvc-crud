package com.io.victorvn.dao;

import com.io.victorvn.config.ConexaoDB;
import com.io.victorvn.model.Pessoa;
import com.io.victorvn.model.PessoaPet;
import com.io.victorvn.model.Pet;
import com.io.victorvn.utils.ResultSetBuildingUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PessoaPetDAO {

    public String save(PessoaPet pessoaPet){
        try {
            Connection connection = ConexaoDB.getConnection();

            String query = "INSERT INTO pet_pessoa VALUES (DEFAULT,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, pessoaPet.getIdPes());
            preparedStatement.setInt(2, pessoaPet.getIdPet());
            preparedStatement.setString(3, pessoaPet.getObs());

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return "Pet adicionado com sucesso";
            } else {
                preparedStatement.close();
                return "Falha ao adicionar pet. Por favor consulte um ADMIN";
            }
        } catch (Exception e){
            return "ERRO: " + e.getMessage();
        }
    }

    public String delete(int pessoaId, int petId){
        try {
            Connection connection = ConexaoDB.getConnection();
            String query = "DELETE FROM pet_pessoa WHERE pet_pessoa.id_pessoa = ? AND pet_pessoa.id_pet = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, pessoaId);
            preparedStatement.setInt(2, petId);

            if (preparedStatement.executeUpdate() > 0){
                preparedStatement.close();
                return "Pet removido!";
            } else {
                preparedStatement.close();
                return "Falha ao tentar remover pet. Procure o ADMIN";
            }


        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public List<Pet> getAllPetsFromPessoaById(int pessoaId){

        try {
            ResultSetBuildingUtils resultSetBuildingUtils = new ResultSetBuildingUtils();
            Connection connection = ConexaoDB.getConnection();
            List<Pet> petList;
            String query = "select * from pet where pet.id in (select pet_pessoa.id_pet from pet_pessoa where pet_pessoa.id_pessoa = ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, pessoaId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet == null){
                throw new RuntimeException("Essa pessoa não possui nenhum pet.");
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


}

package com.io.victorvn.utils;

import com.io.victorvn.model.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetBuildingUtils {

    public Pet generatePetFromResultSet(ResultSet resultSet) throws SQLException {

        Pet pet = new Pet();
        if(resultSet.next()){
            pet = generatePet(resultSet);
        }

        return pet;
    }

    public List<Pet> generateListPetFromResultSet(ResultSet resultSet) throws SQLException{

        List<Pet> petList = new ArrayList<>();
        while(resultSet.next()){
            Pet pet = generatePet(resultSet);
            petList.add(pet);
        }

        return petList;
    }

    public Pet generatePet(ResultSet resultSet) throws SQLException{
        Pet pet = new Pet();
        pet.setId(Integer.parseInt(resultSet.getString(1)));
        pet.setNome(resultSet.getString(2));
        pet.setTipo(resultSet.getString(3));
        pet.setIdade(resultSet.getString(4));

        return pet;
    }
}

package com.io.victorvn.controller;

import com.io.victorvn.dao.PessoaDAO;
import com.io.victorvn.dao.PetDAO;
import com.io.victorvn.model.Pessoa;
import com.io.victorvn.model.Pet;

import java.util.List;

public class PetController {

    PetDAO petDAO = new PetDAO();

    public String cadastrarPet(Pet pet){
        return petDAO.save(pet);
    }

    public String atualizarPet(Pet pet){
        return petDAO.update(pet);
    }

    public Pet buscarPetPorId(int id){
        return petDAO.getById(id);
    }

    public List<Pet> bucarPetPorNome(String nome){
        return petDAO.getByName(nome);
    }

    public List<Pet> buscarTodosPets(){
        return petDAO.getAll();
    }

    public String deletarPet(int id) {
        return petDAO.delete(id);
    }
}

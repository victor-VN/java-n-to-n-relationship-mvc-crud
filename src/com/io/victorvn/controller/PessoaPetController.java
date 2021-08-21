package com.io.victorvn.controller;

import com.io.victorvn.dao.PessoaPetDAO;
import com.io.victorvn.model.PessoaPet;
import com.io.victorvn.model.Pet;

import java.util.List;

public class PessoaPetController {

    PessoaPetDAO pessoaPetDAO = new PessoaPetDAO();


    public String adicionarPet(PessoaPet pessoaPet){
        return pessoaPetDAO.save(pessoaPet);
    }

    public String excluirPet(int pessoaId, int petId){
        return pessoaPetDAO.delete(pessoaId, petId);
    }

    public List<Pet> buscarPetDaPessoaPoId(int id){
        return pessoaPetDAO.getAllPetsFromPessoaById(id);
    }
}

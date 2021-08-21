package com.io.victorvn.controller;

import com.io.victorvn.dao.PessoaDAO;
import com.io.victorvn.model.Pessoa;

import java.util.List;

public class PessoaController {

    PessoaDAO pessoaDAO = new PessoaDAO();

    public String cadastrarPessoa(Pessoa pessoa){
        return pessoaDAO.save(pessoa);
    }

    public String atualizarPessoa(Pessoa pessoa){
        return pessoaDAO.update(pessoa);
    }

    public Pessoa buscarPessoaPorId(int id){
        return pessoaDAO.getById(id);
    }

    public List<Pessoa> bucarPessoasPorNome(String nome){
        return pessoaDAO.getByName(nome);
    }

    public List<Pessoa> buscarTodasPessoas(){
        return pessoaDAO.getAll();
    }

    public String deletarPessoa(int id) {
        return pessoaDAO.delete(id);
    }

}

package com.io.victorvn.controller;

import com.io.victorvn.dao.UsuarioDAO;
import com.io.victorvn.model.Usuario;

import java.util.List;

public class UsuarioController {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioDAO.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario){
        return usuarioDAO.update(usuario);
    }

    public Usuario buscarUsuarioPorId(int id){
        return usuarioDAO.getById(id);
    }

    public List<Usuario> buscarUsuarioPorNome(String nome){
        return usuarioDAO.getByName(nome);
    }

    public List<Usuario> buscarTodosUsuarios(){
        return usuarioDAO.getAll();
    }

    public Integer excluirUsuario(int id) {
        return usuarioDAO.delete(id);
    }
}

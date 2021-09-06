package com.io.victorvn.controller;

import com.io.victorvn.dao.UsuarioDAO;
import com.io.victorvn.model.Usuario;

import java.util.List;

public class UsuarioController {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public String cadastrarUsuario(Usuario usuario){
        return usuarioDAO.save(usuario);
    }

    public String atualizarUsuario(Usuario usuario){
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

    public String excluirUsuario(int id) {
        return usuarioDAO.delete(id);
    }
}

package com.io.victorvn.controller;

import com.io.victorvn.dao.UserAuthDAO;
import com.io.victorvn.dao.UsuarioDAO;
import com.io.victorvn.model.UserAuth;
import com.io.victorvn.model.Usuario;

import java.util.List;

public class UserAuthController {

    UserAuthDAO userAuthDAO = new UserAuthDAO();

    public UserAuth cadastrarUsuario(UserAuth usuario){
        return userAuthDAO.save(usuario);
    }

    public UserAuth atualizarUsuario(UserAuth usuario){
        return userAuthDAO.update(usuario);
    }

    public UserAuth buscarUsuarioPorId(int id){
        return userAuthDAO.getById(id);
    }

    public List<UserAuth> buscarUsuarioPorNome(String nome){
        return userAuthDAO.getByName(nome);
    }

    public List<UserAuth> buscarTodosUsuarios(){
        return userAuthDAO.getAll();
    }

    public Integer excluirUsuario(int id) {
        return userAuthDAO.delete(id);
    }
}

package victorvn.controller;

import android.content.Context;

import java.util.List;

import victorvn.dao.UsuarioDAO;
import victorvn.model.Usuario;

public class UsuarioController {

    UsuarioDAO usuarioDAO;

    public UsuarioController(Context context){
        this.usuarioDAO = new UsuarioDAO(context);
    }

    public Usuario salvar(Usuario usuario){
        return usuarioDAO.salvar(usuario);
    }

    public Usuario atualizar(Usuario usuario){
        return usuarioDAO.atualizar(usuario);
    }

    public Usuario excluir(Usuario usuario){
        return usuarioDAO.excluir(usuario);
    }

    public List<Usuario> listarTodos(){
        return usuarioDAO.listarTodos();
    }

    public Usuario listarPorId(int id){
        return usuarioDAO.listarPorId(id);
    }

}

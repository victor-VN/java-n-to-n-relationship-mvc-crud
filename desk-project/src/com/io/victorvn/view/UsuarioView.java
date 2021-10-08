package com.io.victorvn.view;

import com.io.victorvn.Main;
import com.io.victorvn.controller.UsuarioChatController;
import com.io.victorvn.controller.UsuarioController;
import com.io.victorvn.model.Usuario;

import javax.swing.*;

public class UsuarioView {

    UsuarioController usuarioController = new UsuarioController();
    UsuarioChatController usuarioChatController = new UsuarioChatController();

    public void showMenuCadastrar(){

        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - INSERIR\n 2 - BUSCAR\n 3 - LISTAR\n 4 - ALTERAR\n 5 - EXCLUIR\n 6 - SAIR"));
        if (ops == 1) inserir();
        if (ops == 2) buscar();
        if (ops == 3) listar();
        if (ops == 4) alterar();
        if (ops == 5) excluir();

        Main.mostrarMenuPrincipal();

    }

    private void inserir() {


        String nome = JOptionPane.showInputDialog("NOME");
        String email = JOptionPane.showInputDialog("EMAIL");
        String avatar = JOptionPane.showInputDialog("AVATAR");
        String descricao = JOptionPane.showInputDialog("DESCRICAO");

        Usuario usuario = new Usuario(
                0,
                nome,
                email,
                avatar,
                descricao
        );

        JOptionPane.showMessageDialog(
                null,
                usuarioController.cadastrarUsuario(usuario));

        showMenuCadastrar();
    }

    private void buscar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Usuario usuario = usuarioController.buscarUsuarioPorId(id);

        if (usuario == null || usuario.getId() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado com id " + id);

            showMenuCadastrar();
        }

        JOptionPane.showMessageDialog(null, usuarioController.buscarUsuarioPorId(id));
        showMenuCadastrar();
    }

    private void listar() {

        if (usuarioController.buscarTodosUsuarios().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado");
            return;
        }

        JOptionPane.showMessageDialog(null, usuarioController.buscarTodosUsuarios());
        showMenuCadastrar();

    }

    private void alterar() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));

        Usuario usuario = usuarioController.buscarUsuarioPorId(id);

        if (usuario == null || usuario.getId() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado com id " + id);

            showMenuCadastrar();
        }

        String nome = JOptionPane.showInputDialog("NOME");
        String email = JOptionPane.showInputDialog("EMAIL");
        String avatar = JOptionPane.showInputDialog("AVATAR");
        String descricao = JOptionPane.showInputDialog("DESCRICAO");

        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setAvatar(avatar);
        usuario.setDescricao(descricao);

        JOptionPane.showMessageDialog(null, usuarioController.atualizarUsuario(usuario));

        showMenuCadastrar();
    }

    private void excluir() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));

        if (!usuarioChatController.listarTodosUsuariosDoChat(id).isEmpty()){
            JOptionPane.showMessageDialog(null, "O Usuário pertence a um ou mais chats!");
            return;
        }
        JOptionPane.showMessageDialog(null, usuarioController.excluirUsuario(id));

        showMenuCadastrar();
    }
}

package com.io.victorvn.view;

import com.io.victorvn.Main;
import com.io.victorvn.controller.ChatController;
import com.io.victorvn.controller.UsuarioChatController;
import com.io.victorvn.controller.UsuarioController;
import com.io.victorvn.model.Chat;
import com.io.victorvn.model.Usuario;
import com.io.victorvn.model.UsuarioChat;
import javax.swing.*;

public class UsuarioChatView {

    UsuarioChatController usuarioChatController = new UsuarioChatController();
    ChatController chatController = new ChatController();
    UsuarioController usuarioController = new UsuarioController();

    public void showMenuCadastrar(){

        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - INSERIR\n 2 - LISTAR\n 3 - EXCLUIR\n 4 - SAIR"));
        if (ops == 1) inserir();
        if (ops == 2) listar();
        if (ops == 3) excluir();

        Main.mostrarMenuPrincipal();

    }

    private void inserir() {

        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("ID USUARIO"));
        Usuario usuario = usuarioController.buscarUsuarioPorId(idUsuario);
        if (usuario == null || usuario.getId() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum usuario encontrado com id " + idUsuario);
            return;
        }

        int idChat = Integer.parseInt(JOptionPane.showInputDialog("ID CHAT"));
        Chat chat = chatController.buscarChatPorId(idChat);
        if (chat == null || chat.getId() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum chat encontrado com id " + idChat);
            return;
        }

        UsuarioChat usuarioChat = new UsuarioChat(
                0,
                usuario,
                chat,
                "NAO",
                "NAO"
        );

        JOptionPane.showMessageDialog(null, usuarioChatController.adicionarUsuarioNoChat(usuarioChat));

        showMenuCadastrar();
    }

    private void listar() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("ID USUARIO"));
        JOptionPane.showMessageDialog(null, usuarioChatController.listarTodosChatsDoUsuario(id));

        id = Integer.parseInt(JOptionPane.showInputDialog("ID CHAT"));
        JOptionPane.showMessageDialog(null, usuarioChatController.listarTodosUsuariosDoChat(id));

        showMenuCadastrar();
    }

    private void excluir() {

        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("ID USUARIO"));
        int idChat = Integer.parseInt(JOptionPane.showInputDialog("ID CHAT"));
        Usuario usuario = usuarioController.buscarUsuarioPorId(idUsuario);
        Chat chat = chatController.buscarChatPorId(idChat);

        if (chat == null || chat.getId() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum chat encontrado!!");
            return;
        }

        if (usuario == null || usuario.getId() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum usuario encontrado");
            return;
        }

        JOptionPane.showMessageDialog(null, usuarioChatController.removerUsuarioDoChat(idUsuario, idChat));

        showMenuCadastrar();
    }
}

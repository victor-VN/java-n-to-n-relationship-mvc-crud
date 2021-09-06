package com.io.victorvn.view;

import com.io.victorvn.Main;
import com.io.victorvn.controller.ChatController;
import com.io.victorvn.model.Chat;
import javax.swing.*;

public class ChatView {

    ChatController chatController = new ChatController();

    public void showMenuCadastrar(){

        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - INSERIR, 2 - BUSCAR, 3 - LISTAR, 4 - ALTERAR, 5 - EXCLUIR, 6 - SAIR"));
        if (ops == 1) inserir();
        if (ops == 2) buscar();
        if (ops == 3) listar();
        if (ops == 4) alterar();
        if (ops == 5) excluir();

        Main.mostrarMenuPrincipal();

    }

    private void inserir() {

        String nome = JOptionPane.showInputDialog("NOME");
        String status = JOptionPane.showInputDialog("STATUS: (ABERTO ou FECHADO)");
        int capacidade = Integer.parseInt(JOptionPane.showInputDialog("CAPACIDADE"));
        String assunto = JOptionPane.showInputDialog("ASSUNTO");

        Chat chat = new Chat(
                0,
                nome,
                status,
                capacidade,
                assunto
        );

        JOptionPane.showMessageDialog(null, chatController.cadastrarChat(chat));

        showMenuCadastrar();
    }

    private void buscar() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));

        JOptionPane.showMessageDialog(null,chatController.buscarChatPorId(id));
        showMenuCadastrar();
    }

    private void listar() {

        JOptionPane.showMessageDialog(null, chatController.buscarTodosChats());
        showMenuCadastrar();

    }

    private void alterar() {

        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Chat chat = chatController.buscarChatPorId(id);

        if (chat == null){
            JOptionPane.showMessageDialog(null, "Chat não encontrado");
            showMenuCadastrar();
        }

        String nome = JOptionPane.showInputDialog("NOME");
        String status = JOptionPane.showInputDialog("STATUS: (ABERTO ou FECHADO)");
        int capacidade = Integer.parseInt(JOptionPane.showInputDialog("CAPACIDADE"));
        String assunto = JOptionPane.showInputDialog("ASSUNTO");

        chat.setNome(nome);
        chat.setStatus(status);
        chat.setCapacidade(capacidade);
        chat.setAssunto(assunto);

        JOptionPane.showMessageDialog(null, chatController.atualizarChat(chat));

        showMenuCadastrar();
    }

    private void excluir() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        JOptionPane.showMessageDialog(
                null,
                chatController.deletarChat(id));

        showMenuCadastrar();
    }

}

package com.io.victorvn;

import com.io.victorvn.model.UsuarioChat;
import com.io.victorvn.view.ChatView;
import com.io.victorvn.view.UsuarioChatView;
import com.io.victorvn.view.UsuarioView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        mostrarMenuPrincipal();

    }

    public static void mostrarMenuPrincipal(){

        UsuarioView usuarioView = new UsuarioView();
        ChatView chatView = new ChatView();
        UsuarioChatView usuarioChatView = new UsuarioChatView();

        int ops = Integer.parseInt(JOptionPane.showInputDialog("1 - USUARIO\n 2 - CHAT\n 3 - USUARIO-CHAT\n 4 SAIR"));
        if (ops == 1) usuarioView.showMenuCadastrar();
        if (ops == 2) chatView.showMenuCadastrar();
        if (ops == 3) usuarioChatView.showMenuCadastrar();

    }
}

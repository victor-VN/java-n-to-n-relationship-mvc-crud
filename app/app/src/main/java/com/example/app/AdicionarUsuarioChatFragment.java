package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app.databinding.FragmentAdicionarUsuarioChatBinding;
import com.example.app.databinding.FragmentAtualizarUsuarioBinding;

import victorvn.controller.ChatController;
import victorvn.controller.UsuarioChatController;
import victorvn.controller.UsuarioController;
import victorvn.model.Chat;
import victorvn.model.Usuario;


public class AdicionarUsuarioChatFragment extends Fragment {


    private FragmentAdicionarUsuarioChatBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAdicionarUsuarioChatBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuarioController usuarioController = new UsuarioController(getContext());
                ChatController chatController = new ChatController(getContext());
                UsuarioChatController usuarioChatController = new UsuarioChatController(getContext());

                int idChat = Integer.parseInt(binding.txtIDChat.getText().toString());
                int idUsuaio = Integer.parseInt(binding.txtIdUsuario.getText().toString());

                Usuario usuario = usuarioController.listarPorId(idUsuaio);
                Chat chat = chatController.listarPorId(idChat);

                if (usuario == null){
                    Toast.makeText(getActivity(), "Usuário não encontrado com id " + idUsuaio, Toast.LENGTH_LONG)
                            .show();
                } else if (chat == null){
                    Toast.makeText(getActivity(), "Chat não encontrado com id " + idChat, Toast.LENGTH_LONG)
                            .show();
                } else {

                    if (usuarioChatController.inserirUsuarioNoChat(usuario, chat) != null){
                        Toast.makeText(getActivity(), "Usuário inserido com sucesso!", Toast.LENGTH_LONG)
                                .show();
                    }
                }

            }
        });
    }
}
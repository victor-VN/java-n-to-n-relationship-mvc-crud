package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app.databinding.FragmentCadastrarChatBinding;

import victorvn.controller.ChatController;
import victorvn.controller.UsuarioController;
import victorvn.model.Chat;
import victorvn.model.Usuario;

public class CadastrarChatFragment extends Fragment {

    private FragmentCadastrarChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCadastrarChatBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        binding.btnCadastrarChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chat chat = new Chat();
                chat.setId(0);
                chat.setNome(binding.txtNome.getText().toString());
                chat.setCapacidade(Integer.parseInt(binding.txtCapacidade.getText().toString()));
                chat.setAssunto(binding.txtAssunto.getText().toString());

                ChatController chatController = new ChatController(getContext());


                if (chatController.salvar(chat) != null){
                    System.out.println("Usuario cadastrado com sucesso " + chat.toString());
                    binding.txtAssunto.setText("");
                    binding.txtCapacidade.setText("");
                    binding.txtNome.setText("");

                    Toast.makeText(getActivity(), "Chat cadastrado com sucesso", Toast.LENGTH_LONG)
                            .show();

                } else {
                    Toast.makeText(getActivity(), "Erro ao cadastrar chat!!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
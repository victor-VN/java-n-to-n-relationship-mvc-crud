
package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app.databinding.FragmentAtualizarChatBinding;
import com.example.app.databinding.FragmentAtualizarUsuarioBinding;
import com.example.app.databinding.FragmentCadastrarChatBinding;

import victorvn.controller.ChatController;
import victorvn.controller.UsuarioController;
import victorvn.model.Chat;
import victorvn.model.Usuario;

public class AtualizarChatFragment extends Fragment {

    private FragmentAtualizarChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAtualizarChatBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(binding.txtBuscaUsuario.getText().toString());

                ChatController chatController = new ChatController(getContext());
                Chat chat = chatController.listarPorId(id);

                if (chat == null){
                    Toast.makeText(getActivity(), "Nenhum chat encontrado com o ID: " + id, Toast.LENGTH_LONG)
                            .show();
                } else {

                    binding.txtNome.setText(chat.getNome());
                    binding.txtCapacidade.setText(Integer.toString(chat.getCapacidade()));
                    binding.txtAssunto.setText(chat.getAssunto());
                }
            }
        });

        binding.btnCadastrarChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(binding.txtBuscaUsuario.getText().toString());

                Chat chat = new Chat();
                ChatController chatController = new ChatController(getContext());
                chat.setId(id);
                chat.setNome(binding.txtNome.getText().toString());
                chat.setCapacidade(Integer.parseInt(binding.txtCapacidade.getText().toString()));
                chat.setAssunto(binding.txtAssunto.getText().toString());

                if (chatController.atualizar(chat) == null){
                    Toast.makeText(getActivity(), "Erro ao atualizar o chat!!", Toast.LENGTH_LONG)
                            .show();
                } else {
                    Toast.makeText(getActivity(), "Chat atualizado com sucesso", Toast.LENGTH_LONG)
                            .show();

                    binding.txtAssunto.setText("");
                    binding.txtNome.setText("");
                    binding.txtCapacidade.setText("");
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
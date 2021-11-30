package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app.databinding.FragmentAtualizarUsuarioBinding;

import victorvn.controller.UsuarioController;
import victorvn.model.Usuario;


public class AtualizarUsuarioFragment extends Fragment {

    private FragmentAtualizarUsuarioBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAtualizarUsuarioBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        binding.btnBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(binding.txtBuscaUsuario.getText().toString());

                UsuarioController usuarioController = new UsuarioController(getContext());
                Usuario usuario = usuarioController.listarPorId(id);

                if (usuario == null){
                    Toast.makeText(getActivity(), "Nenhum usuário encontrado com o ID: " + id, Toast.LENGTH_LONG)
                            .show();
                } else {

                    binding.txtNome.setText(usuario.getNome());
                    binding.txtCapacidade.setText(usuario.getEmail());
                    binding.txtAssunto.setText(usuario.getDescricao());
                    binding.txtDescricao.setText(usuario.getSenha());
                }
            }
        });

        binding.btnCadastrarChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(binding.txtBuscaUsuario.getText().toString());

                Usuario usuario = new Usuario();
                UsuarioController usuarioController = new UsuarioController(getContext());
                usuario.setId(id);
                usuario.setNome(binding.txtNome.getText().toString());
                usuario.setSenha(binding.txtCapacidade.getText().toString());
                usuario.setDescricao(binding.txtDescricao.getText().toString());
                usuario.setEmail(binding.txtAssunto.getText().toString());


                if (usuarioController.atualizar(usuario) == null){
                    Toast.makeText(getActivity(), "Erro ao atualizar o usuário!!", Toast.LENGTH_LONG)
                            .show();
                } else {
                    Toast.makeText(getActivity(), "Usuário atualizado com sucesso", Toast.LENGTH_LONG)
                            .show();

                    binding.txtCapacidade.setText("");
                    binding.txtNome.setText("");
                    binding.txtAssunto.setText("");
                    binding.txtDescricao.setText("");
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
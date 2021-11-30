package com.example.app;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.app.databinding.FragmentFirstBinding;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import victorvn.config.BancoHelper;
import victorvn.controller.UsuarioController;
import victorvn.model.Usuario;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.btnCadastrarChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Usuario usuario = new Usuario();
                usuario.setId(0);
                usuario.setNome(binding.txtNome.getText().toString());
                usuario.setSenha(binding.txtCapacidade.getText().toString());
                usuario.setEmail(binding.txtAssunto.getText().toString());
                usuario.setDescricao(binding.txtDescricao.getText().toString());

                UsuarioController usuarioController = new UsuarioController(getContext());


                if (usuarioController.salvar(usuario) != null){
                    System.out.println("Usuario cadastrado com sucesso " + usuario.toString());
                    binding.txtAssunto.setText("");
                    binding.txtNome.setText("");
                    binding.txtCapacidade.setText("");
                    binding.txtDescricao.setText("");
                    Toast.makeText(getActivity(), "Usuário cadastrado com sucesso", Toast.LENGTH_LONG)
                            .show();

                } else {
                    Toast.makeText(getActivity(), "Erro ao cadastrar usuário!!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
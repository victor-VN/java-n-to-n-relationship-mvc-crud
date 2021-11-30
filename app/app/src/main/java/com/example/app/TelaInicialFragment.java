package com.example.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.databinding.FragmentFirstBinding;
import com.example.app.databinding.FragmentTelaInicialBinding;


public class TelaInicialFragment extends Fragment {


    private FragmentTelaInicialBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTelaInicialBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(TelaInicialFragment.this).navigate(R.id.action_telaInicialFragment2_to_usuarioFragment);
            }
        });

        binding.btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(TelaInicialFragment.this).navigate(R.id.action_telaInicialFragment2_to_chatFragment);
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(TelaInicialFragment.this).navigate(R.id.action_telaInicialFragment2_to_adicionarUsuarioChatFragment);
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
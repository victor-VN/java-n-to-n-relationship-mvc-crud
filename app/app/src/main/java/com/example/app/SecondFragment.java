package com.example.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.app.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.List;

import victorvn.controller.UsuarioController;
import victorvn.model.Usuario;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        UsuarioController usuarioController = new UsuarioController(getContext());
        List<Usuario> usuarioList = usuarioController.listarTodos();
        int rowNumber = usuarioList.size();
        int colNumber = 4;
        int number = 0;

        for (int i = 0; i < rowNumber; i++){
            TableRow tableRow = new TableRow(getActivity());
            tableRow.setPadding(10,10,10,10);
            number = i;

            if (i > 0 && i % 2 != 0)
                tableRow.setBackgroundColor(Color.rgb(42, 128, 62));

            for (int j = 0; j < colNumber; j++){
                TextView textView = new TextView(getContext());
                textView.setTextSize(20);
                if (j == 0)
                    textView.setText(Integer.toString(usuarioList.get(i).getId()));

                if (j == 1)
                    textView.setText(usuarioList.get(i).getNome());

                if (j == 2)
                    textView.setText(usuarioList.get(i).getEmail());

                if (j == 3)
                    textView.setText(usuarioList.get(i).getDescricao());

                textView.setPadding(10, 10, 10, 10);
                textView.setTextColor(Color.WHITE);
                tableRow.addView(textView);

                int finalNumber = number;
                tableRow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        builder.setCancelable(true);
                        builder.setTitle("Excluir");
                        builder.setMessage("Deseja excluir o usuário?");
                        builder.setPositiveButton("Confirm",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        if (usuarioController.excluir(usuarioList.get(finalNumber)) != null){
                                            Toast.makeText(getActivity(), "Usuário excluído com sucesso!", Toast.LENGTH_LONG)
                                                    .show();
                                            getActivity().recreate();
                                        } else {
                                            Toast.makeText(getActivity(), "Erro ao tentar excluir o usuário!", Toast.LENGTH_LONG)
                                                    .show();
                                        }
                                    }
                                });
                        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("Cancelou");
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                });
            }
            binding.tblUsuarios.addView(tableRow);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
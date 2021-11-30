package com.example.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.databinding.FragmentListarChatBinding;

import java.util.List;

import victorvn.controller.ChatController;
import victorvn.controller.UsuarioController;
import victorvn.model.Chat;
import victorvn.model.Usuario;

public class ListarChatFragment extends Fragment {

    private FragmentListarChatBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentListarChatBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        ChatController chatController = new ChatController(getContext());
        List<Chat> chatList = chatController.listarTodos();
        int rowNumber = chatList.size();
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
                    textView.setText(Integer.toString(chatList.get(i).getId()));

                if (j == 1)
                    textView.setText(chatList.get(i).getNome());

                if (j == 2)
                    textView.setText(Integer.toString(chatList.get(i).getCapacidade()));

                if (j == 3)
                    textView.setText(chatList.get(i).getAssunto());

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
                        builder.setMessage("Deseja excluir o chat?");
                        builder.setPositiveButton("Confirm",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        if (chatController.excluir(chatList.get(finalNumber)) != null){
                                            Toast.makeText(getActivity(), "Chat excluído com sucesso!", Toast.LENGTH_LONG)
                                                    .show();
                                            getActivity().recreate();
                                        } else {
                                            Toast.makeText(getActivity(), "Erro ao tentar excluir o chat!", Toast.LENGTH_LONG)
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
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
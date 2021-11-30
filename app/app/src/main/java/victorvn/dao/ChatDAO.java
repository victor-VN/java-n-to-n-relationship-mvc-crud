package victorvn.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import victorvn.config.BancoHelper;
import victorvn.model.Chat;
import victorvn.model.Usuario;

public class ChatDAO {

    private BancoHelper bancoHelper;
    private SQLiteDatabase database;
    private UsuarioChatDAO usuarioChatDAO;

    public ChatDAO(Context context){
        this.bancoHelper = new BancoHelper(context);
        this.database = bancoHelper.getWritableDatabase();
        this.usuarioChatDAO = new UsuarioChatDAO(context);
    }

    public Chat salvar(Chat chat){
        long result = database.insert("chat", null, parseChatForContentValues(chat));

        if (result == -1){
            return null;
        }
        return chat;
    }

    public Chat atualizar(Chat chat){
        long result = database.update("chat",
                parseChatForContentValues(chat),
                "id = " + chat.getId(),
                null);

        if (result == -1){
            return null;
        }
        return chat;
    }

    public List<Chat> listarTodos(){

        List<Chat> chatList = new ArrayList<>();
        String query = "SELECT * FROM chat";
        Cursor cursor = bancoHelper.getWritableDatabase().rawQuery (query, null);

        if (cursor.moveToFirst()){
            do {
                chatList.add(new Chat(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3)
                ));
            } while (cursor.moveToNext());
        }
        return chatList;
    }

    public Chat listarPorId(int id){
        String query = "SELECT * FROM chat WHERE id = " + id;
        Cursor cursor = bancoHelper.getWritableDatabase().rawQuery (query, null);
        Chat chat = null;
        if (cursor.moveToFirst()){
            do {
                chat = new Chat(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3));
            } while (cursor.moveToNext());
        }
        return chat;
    }

    public Chat excluir(Chat chat){
        long result = database.delete("chat",
                "id = " + chat.getId(),
                null);

        usuarioChatDAO.removerTodosChatsDoUsuario(chat.getId());

        if (result == -1){
            return null;
        }
        return chat;
    }

    private ContentValues parseChatForContentValues(Chat chat){
        ContentValues values = new ContentValues();
        values.put("nome", chat.getNome());
        values.put("quantidade", chat.getCapacidade());
        values.put("assunto", chat.getAssunto());

        return values;
    }
}

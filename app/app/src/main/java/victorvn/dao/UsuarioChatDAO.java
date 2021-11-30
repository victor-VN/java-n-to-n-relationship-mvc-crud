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
import victorvn.model.UsuarioChat;

public class UsuarioChatDAO {

    private BancoHelper bancoHelper;
    private SQLiteDatabase database;
    private ChatDAO chatDAO;

    public UsuarioChatDAO(Context context){
        this.bancoHelper = new BancoHelper(context);
        this.database = bancoHelper.getWritableDatabase();
        this.chatDAO = new ChatDAO(context);
    }

    public UsuarioChat inserirUsuarioNoChat(Usuario usuario, Chat chat){
        long result = database.insert("chat_usuario", null, parceUsuarioChat(usuario,chat));

        if (result == -1){
            return null;
        }
        return new UsuarioChat();
    }

    public UsuarioChat removerUsuarioDoChat(int id){

        long result = database.delete("chat_usuario",
                "id = " + id,
                null);

        if (result == -1){
            return null;
        }
        return new UsuarioChat();

    }

    public UsuarioChat removerUsuarioDeTodosChats(int id){

        long result = database.delete("chat_usuario",
                "id_usuario = " + id,
                null);

        if (result == -1){
            return null;
        }
        return new UsuarioChat();

    }

    public UsuarioChat removerTodosChatsDoUsuario(int id){

        long result = database.delete("chat_usuario",
                "id_chat = " + id,
                null);

        if (result == -1){
            return null;
        }
        return new UsuarioChat();

    }

    public List<Chat> listarChatsUsuario(int idUsuario){


        List<Chat> chatList = new ArrayList<>();
        List<Integer> idsChats = new ArrayList<>();
        String query = "SELECT * FROM chat_usuario WHERE id_usurio =" + idUsuario;
        Cursor cursor = bancoHelper.getWritableDatabase().rawQuery (query, null);

        if (cursor.moveToFirst()){
            do {
                idsChats.add(cursor.getInt(1));
            } while (cursor.moveToNext());
        }

        for (int id : idsChats){
            chatList.add(chatDAO.listarPorId(id));
        }
        return chatList;

    }

    private ContentValues parceUsuarioChat(Usuario usuario, Chat chat){
        ContentValues values = new ContentValues();
        values.put("id_usuario", usuario.getId());
        values.put("id_chat", chat.getId());

        return values;
    }

    private ContentValues parseChatForContentValues(Chat chat){
        ContentValues values = new ContentValues();
        values.put("nome", chat.getNome());
        values.put("quantidade", chat.getCapacidade());
        values.put("assunto", chat.getAssunto());

        return values;
    }
}

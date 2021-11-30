package victorvn.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import victorvn.config.BancoHelper;
import victorvn.model.Usuario;

public class UsuarioDAO {

    private BancoHelper bancoHelper;
    private SQLiteDatabase database;
    private UsuarioChatDAO usuarioChatDAO;

    public UsuarioDAO(Context context){
        this.bancoHelper = new BancoHelper(context);
        this.database = bancoHelper.getWritableDatabase();
        this.usuarioChatDAO = new UsuarioChatDAO(context);
    }

    public Usuario salvar(Usuario usuario){
        long result = database.insert("usuario", null, parseUsuarioForContentValues(usuario));

        if (result == -1){
            return null;
        }
        return usuario;
    }

    public Usuario atualizar(Usuario usuario){
        long result = database.update("usuario",
                parseUsuarioForContentValues(usuario),
                "id = " + usuario.getId(),
                null);

        if (result == -1){
            return null;
        }
        return usuario;
    }

    public List<Usuario> listarTodos(){

        List<Usuario> usuarioList = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        Cursor cursor = bancoHelper.getWritableDatabase().rawQuery (query, null);

        if (cursor.moveToFirst()){
            do {
                usuarioList.add(new Usuario(
                  cursor.getInt(0),
                  cursor.getString(1),
                  cursor.getString(2),
                  cursor.getString(3),
                  cursor.getString(4))
                );
            } while (cursor.moveToNext());
        }
        return usuarioList;
    }

    public Usuario listarPorId(int id){
        List<Usuario> usuarioList = new ArrayList<>();
        String query = "SELECT * FROM usuario WHERE id = " + id;
        Cursor cursor = bancoHelper.getWritableDatabase().rawQuery (query, null);
        Usuario usuario = null;
        if (cursor.moveToFirst()){
            do {
                usuario = new Usuario(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));
            } while (cursor.moveToNext());
        }
        return usuario;
    }

    public Usuario excluir(Usuario usuario){
        long result = database.delete("usuario",
                "id = " + usuario.getId(),
                null);

        usuarioChatDAO.removerUsuarioDeTodosChats(usuario.getId());

        if (result == -1){
            return null;
        }
        return usuario;
    }

    private ContentValues parseUsuarioForContentValues(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("senha", usuario.getSenha());
        values.put("email", usuario.getEmail());
        values.put("descricao", usuario.getDescricao());

        return values;
    }
}

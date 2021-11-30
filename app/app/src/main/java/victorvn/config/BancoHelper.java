package victorvn.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BancoHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "chat.db";
    public static final String TABELA_USUARIO = "usuario";
    public static final String TABELA_CHAT = "chat";
    public static final String TABELA_CH_US = "chat_usuario";

    private static final int VERSAO_SCHEMA = 1;
    private final String USUARIO_CREATE;
    private final String CHAT_CREATE;
    private final String CH_US_CREATE;


    public BancoHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        this.USUARIO_CREATE = "CREATE TABLE usuario (id INTEGER PRIMARY KEY AUTOINCREMENT,nome TEXT,senha TEXT,email TEXT,descricao TEXT);";
        this.CHAT_CREATE = "CREATE TABLE chat (id INTEGER PRIMARY KEY AUTOINCREMENT,nome TEXT,quantidade INTEGER,assunto TEXT);";
        this.CH_US_CREATE = "CREATE TABLE chat_usuario (id INTEGER PRIMARY KEY AUTOINCREMENT,id_usuario INTeger NOT NULL,id_chat INTEGER NOT NULL, " +
                "FOREIGN KEY(id_usuario) REFERENCES usuario(id)," +
                "FOREIGN KEY(id_chat) REFERENCES chat(id));";

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USUARIO_CREATE);
        db.execSQL(CHAT_CREATE);
        db.execSQL(CH_US_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_CHAT);
        db.execSQL("DROP TABLE IF EXISTS" + TABELA_CH_US);
        onCreate(db);
    }
}

package mercadoverde.lucas.mercadoverde;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class ProdutoClienteTable {


    private SQLiteDatabase mDataBase;
    private DataBaseHelper mDataHelper;
    private static String TABLE = "PRODUTO_CLIENTE";
    private static String COLUMN_ID = "ID";
    private static String COLUMN_NOME = "NOME";
    private static String COLUMN_PRODUTO = "PRECO_PRODUTO";
    private static String COLUMN_DT_ANUNCIO = "DT_ANUNCIO";
   // private static String COLUMN_URL_DA_FOTO_DO_PRODUTO = "URL_DA_FOTO_DO_PRODUTO";

    private static String[] ALL_COLUMNS = {COLUMN_ID,COLUMN_NOME,COLUMN_PRODUTO,COLUMN_DT_ANUNCIO/*,COLUMN_URL_DA_FOTO_DO_PRODUTO*/};

    public static String CREATE_TABLE = "CREATE TABLE " + TABLE + "("
            + COLUMN_ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOME             + " TEXT, "
            + COLUMN_PRODUTO          + " TEXT, "
            + COLUMN_DT_ANUNCIO       + " TEXT "
          //  + COLUMN_URL_DA_FOTO_DO_PRODUTO + "TEXT"
            +");";
    public ProdutoClienteTable (Context context) throws SQLException {
        mDataHelper = DataBaseHelper.getInstance(context);
        open();
    }

    private void open() throws SQLException {
        mDataBase = mDataHelper.getWritableDatabase();
    }
    private ProdutoCliente toObject(Cursor cursor) {
        ProdutoCliente u = new ProdutoCliente();
        u.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
        u.setnome(cursor.getString(cursor.getColumnIndex(COLUMN_NOME)));
        u.setpreco(cursor.getFloat(cursor.getColumnIndex(COLUMN_PRODUTO)));
        u.setdt_anuncio(cursor.getInt(cursor.getColumnIndex(COLUMN_DT_ANUNCIO)));
       //u.seturlDaFotoDoProduto(cursor.getString(cursor.getColumnIndex(COLUMN_URL_DA_FOTO_DO_PRODUTO)));
        return u;
    }
    private ContentValues toContent(ProdutoCliente item) {
        ContentValues content = new ContentValues();
        content.put(COLUMN_NOME, item.getNome());
        content.put(COLUMN_PRODUTO, item.getprecoProduto());
        content.put(COLUMN_DT_ANUNCIO,item.getdataProduto());
       // content.put(COLUMN_URL_DA_FOTO_DO_PRODUTO, item.geturlDaFotoDoProduto());
        return content;
    }
    public long inserir(ProdutoCliente ProdutoCliente){
        return mDataBase.insert(TABLE, null, toContent(ProdutoCliente));
    }
    public List<ProdutoCliente> obterTodos(){
        Cursor cursor = null;
        List<ProdutoCliente> list = new ArrayList<>();
        try {
            cursor = mDataBase.query(true,TABLE,ALL_COLUMNS,null,null,null,null,null,null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    list.add(toObject(cursor));
                } while (cursor.moveToNext());
            }
        }finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return list;
    }

}

package br.com.brunotonia.informatic.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.brunotonia.informatic.Constants.ServicosConstants;
import br.com.brunotonia.informatic.VO.Servicos;

/**
 * Created by bruno on 04/06/16.
 */
public class ServicosDAO {

    public Long adicionar(SQLiteDatabase db, Servicos servico) throws Exception {
        ContentValues values = new ContentValues();
        values.put(ServicosConstants.COLUMN_DESCRICAO, servico.getDescricao());
        values.put(ServicosConstants.COLUMN_VALOR, servico.getValor());
        return db.insert(ServicosConstants.TABLE_NAME, null, values);
    }

    public boolean editar(SQLiteDatabase db, Servicos servico) throws Exception {
        ContentValues values = new ContentValues();
        values.put(ServicosConstants.COLUMN_DESCRICAO, servico.getDescricao());
        values.put(ServicosConstants.COLUMN_VALOR, servico.getValor());
        String busca = ServicosConstants.COLUMN_ID + " =? ";
        String[] dados = new String[] {servico.getId().toString()};
        Integer l = db.update(ServicosConstants.TABLE_NAME, values, busca, dados);
        return (l > 0);
    }

    public List<Servicos> listar(SQLiteDatabase db) throws Exception {
        List<Servicos> servicos = new ArrayList<Servicos>();
        Cursor cursor = db.query(
                ServicosConstants.TABLE_NAME,
                new String[]{ServicosConstants.COLUMN_ID, ServicosConstants.COLUMN_DESCRICAO,
                        ServicosConstants.COLUMN_VALOR},
                null,
                null,
                null,
                null,
                ServicosConstants.COLUMN_DESCRICAO
        );
        while (cursor.moveToNext()) {
            Long id = cursor.getLong(cursor.getColumnIndex(ServicosConstants.COLUMN_ID));
            String descricao = cursor.getString(cursor.getColumnIndex(ServicosConstants.COLUMN_DESCRICAO));
            Float valor = cursor.getFloat(cursor.getColumnIndex(ServicosConstants.COLUMN_VALOR));
            Servicos servico = new Servicos(id, descricao, valor);
            servicos.add(servico);
        }
        return servicos;
    }

    public Servicos selecionar(SQLiteDatabase db, Long id) throws Exception {
        Servicos servico = null;
        Cursor cursor = db.query(
                ServicosConstants.TABLE_NAME,
                new String[]{ServicosConstants.COLUMN_ID, ServicosConstants.COLUMN_DESCRICAO,
                        ServicosConstants.COLUMN_VALOR},
                ServicosConstants.COLUMN_ID + " IS ? ",
                new String[]{id.toString()},
                null,
                null,
                ServicosConstants.COLUMN_DESCRICAO
        );
        while (cursor.moveToNext()) {
            String descricao = cursor.getString(cursor.getColumnIndex(ServicosConstants.COLUMN_DESCRICAO));
            Float valor = cursor.getFloat(cursor.getColumnIndex(ServicosConstants.COLUMN_VALOR));
            servico = new Servicos(id, descricao, valor);
        }
        return servico;
    }
}

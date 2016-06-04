package br.com.brunotonia.informatic.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.brunotonia.informatic.Constants.EnderecosConstants;
import br.com.brunotonia.informatic.VO.Enderecos;

/**
 * Created by bruno on 03/06/16.
 */
public class EnderecosDAO {

    public Long adicionar(SQLiteDatabase db, Enderecos endereco) throws Exception {
        ContentValues values = new ContentValues();
        values.put(EnderecosConstants.COLUMN_CLIENTE, endereco.getCliente());
        values.put(EnderecosConstants.COLUMN_RUA, endereco.getRua());
        values.put(EnderecosConstants.COLUMN_NUMERO, endereco.getNumero());
        values.put(EnderecosConstants.COLUMN_CIDADE, endereco.getCidade());
        return db.insert(EnderecosConstants.TABLE_NAME, null, values);
    }

    public boolean editar(SQLiteDatabase db, Enderecos endereco) throws Exception {
        ContentValues values = new ContentValues();
        values.put(EnderecosConstants.COLUMN_CLIENTE, endereco.getCliente());
        values.put(EnderecosConstants.COLUMN_RUA, endereco.getRua());
        values.put(EnderecosConstants.COLUMN_NUMERO, endereco.getNumero());
        values.put(EnderecosConstants.COLUMN_CIDADE, endereco.getCidade());
        String busca = EnderecosConstants.COLUMN_ID + " =? ";
        String[] dados = new String[] {endereco.getId().toString()};
        Integer l = db.update(EnderecosConstants.TABLE_NAME, values, busca, dados);
        return (l > 0);
    }

    public List<Enderecos> listar(SQLiteDatabase db) throws Exception {
        List<Enderecos> enderecos = new ArrayList<Enderecos>();
        Cursor cursor = db.query(
                EnderecosConstants.TABLE_NAME,
                new String[]{EnderecosConstants.COLUMN_ID, EnderecosConstants.COLUMN_CLIENTE,
                        EnderecosConstants.COLUMN_RUA, EnderecosConstants.COLUMN_NUMERO, EnderecosConstants.COLUMN_CIDADE},
                null,
                null,
                null,
                null,
                EnderecosConstants.COLUMN_ID
        );
        while (cursor.moveToNext()) {
            Long id = cursor.getLong(cursor.getColumnIndex(EnderecosConstants.COLUMN_ID));
            Long cliente = cursor.getLong(cursor.getColumnIndex(EnderecosConstants.COLUMN_CLIENTE));
            String rua = cursor.getString(cursor.getColumnIndex(EnderecosConstants.COLUMN_RUA));
            String numero = cursor.getString(cursor.getColumnIndex(EnderecosConstants.COLUMN_NUMERO));
            String cidade = cursor.getString(cursor.getColumnIndex(EnderecosConstants.COLUMN_CIDADE));
            Enderecos endereco = new Enderecos(id, cliente, rua, numero, cidade);
            enderecos.add(endereco);
        }
        return enderecos;
    }

    public List<Enderecos> listar(SQLiteDatabase db, Long clienteID) throws Exception {
        List<Enderecos> enderecos = new ArrayList<Enderecos>();
        Cursor cursor = db.query(
                EnderecosConstants.TABLE_NAME,
                new String[]{EnderecosConstants.COLUMN_ID, EnderecosConstants.COLUMN_CLIENTE,
                        EnderecosConstants.COLUMN_RUA, EnderecosConstants.COLUMN_NUMERO, EnderecosConstants.COLUMN_CIDADE},
                EnderecosConstants.COLUMN_CLIENTE + " IS ? ",
                new String[]{clienteID.toString()},
                null,
                null,
                EnderecosConstants.COLUMN_ID
        );
        while (cursor.moveToNext()) {
            Long id = cursor.getLong(cursor.getColumnIndex(EnderecosConstants.COLUMN_ID));
            Long cliente = cursor.getLong(cursor.getColumnIndex(EnderecosConstants.COLUMN_CLIENTE));
            String rua = cursor.getString(cursor.getColumnIndex(EnderecosConstants.COLUMN_RUA));
            String numero = cursor.getString(cursor.getColumnIndex(EnderecosConstants.COLUMN_NUMERO));
            String cidade = cursor.getString(cursor.getColumnIndex(EnderecosConstants.COLUMN_CIDADE));
            Enderecos endereco = new Enderecos(id, cliente, rua, numero, cidade);
            enderecos.add(endereco);
        }
        return enderecos;
    }

    public Enderecos selecionar(SQLiteDatabase db, Long id) throws Exception {
        Enderecos endereco = null;
        Cursor cursor = db.query(
                EnderecosConstants.TABLE_NAME,
                new String[]{EnderecosConstants.COLUMN_ID, EnderecosConstants.COLUMN_CLIENTE,
                        EnderecosConstants.COLUMN_RUA, EnderecosConstants.COLUMN_NUMERO, EnderecosConstants.COLUMN_CIDADE},
                EnderecosConstants.COLUMN_ID + " IS ? ",
                new String[]{id.toString()},
                null,
                null,
                EnderecosConstants.COLUMN_RUA
        );
        while (cursor.moveToNext()) {
            Long cliente = cursor.getLong(cursor.getColumnIndex(EnderecosConstants.COLUMN_CLIENTE));
            String rua = cursor.getString(cursor.getColumnIndex(EnderecosConstants.COLUMN_RUA));
            String numero = cursor.getString(cursor.getColumnIndex(EnderecosConstants.COLUMN_NUMERO));
            String cidade = cursor.getString(cursor.getColumnIndex(EnderecosConstants.COLUMN_CIDADE));
            endereco = new Enderecos(id, cliente, rua, numero, cidade);
        }
        return endereco;
    }
}

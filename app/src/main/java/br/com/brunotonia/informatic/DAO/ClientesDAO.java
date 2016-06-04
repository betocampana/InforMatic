package br.com.brunotonia.informatic.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.brunotonia.informatic.Constants.ClientesConstants;
import br.com.brunotonia.informatic.VO.Clientes;

/**
 * Created by bruno on 03/06/16.
 */
public class ClientesDAO {

    public Long adicionar(SQLiteDatabase db, Clientes cliente) throws Exception {
        ContentValues values = new ContentValues();
        values.put(ClientesConstants.COLUMN_NOME, cliente.getNome());
        values.put(ClientesConstants.COLUMN_TELEFONE, cliente.getTelefone());
        values.put(ClientesConstants.COLUMN_EMAIL, cliente.getEmail());
        return db.insert(ClientesConstants.TABLE_NAME, null, values);
    }

    public boolean editar(SQLiteDatabase db, Clientes cliente) throws Exception {
        ContentValues values = new ContentValues();
        values.put(ClientesConstants.COLUMN_ID, cliente.getId());
        values.put(ClientesConstants.COLUMN_TELEFONE, cliente.getTelefone());
        values.put(ClientesConstants.COLUMN_EMAIL, cliente.getEmail());
        String busca = ClientesConstants.COLUMN_ID + " =? ";
        String[] dados = new String[] {cliente.getId().toString()};
        Integer l = db.update(ClientesConstants.TABLE_NAME, values, busca, dados);
        return (l > 0);
    }

    public List<Clientes> listar(SQLiteDatabase db) throws Exception {
        List<Clientes> clientes = new ArrayList<Clientes>();
        Cursor cursor = db.query(
                ClientesConstants.TABLE_NAME,
                new String[]{ClientesConstants.COLUMN_ID, ClientesConstants.COLUMN_NOME,
                        ClientesConstants.COLUMN_TELEFONE, ClientesConstants.COLUMN_EMAIL},
                null,
                null,
                null,
                null,
                ClientesConstants.COLUMN_ID
        );
        while (cursor.moveToNext()) {
            Long id = cursor.getLong(cursor.getColumnIndex(ClientesConstants.COLUMN_ID));
            String nome = cursor.getString(cursor.getColumnIndex(ClientesConstants.COLUMN_NOME));
            String telefone = cursor.getString(cursor.getColumnIndex(ClientesConstants.COLUMN_TELEFONE));
            String email = cursor.getString(cursor.getColumnIndex(ClientesConstants.COLUMN_EMAIL));
            Clientes cliente = new Clientes(id, nome, telefone, email);
            clientes.add(cliente);
        }


        return clientes;
    }

    public Clientes selecionar(SQLiteDatabase db, Long id) throws Exception {
        Clientes cliente = null;
        Cursor cursor = db.query(
                ClientesConstants.TABLE_NAME,
                new String[]{ClientesConstants.COLUMN_NOME,
                        ClientesConstants.COLUMN_TELEFONE, ClientesConstants.COLUMN_EMAIL},
                ClientesConstants.COLUMN_ID + " IS ? ",
                new String[]{id.toString()},
                null,
                null,
                ClientesConstants.COLUMN_ID
        );
        while (cursor.moveToNext()) {;
            String nome = cursor.getString(cursor.getColumnIndex(ClientesConstants.COLUMN_NOME));
            String telefone = cursor.getString(cursor.getColumnIndex(ClientesConstants.COLUMN_TELEFONE));
            String email = cursor.getString(cursor.getColumnIndex(ClientesConstants.COLUMN_EMAIL));
            cliente = new Clientes(id, nome, telefone, email);
        }
        return cliente;
    }

}

package br.com.brunotonia.informatic.Constants;

/**
 * Created by bruno on 03/06/16.
 */
public interface ClientesConstants {
    String TABLE_NAME     = "clientes";
    String COLUMN_ID      = "id";
    String COLUMN_NOME    = "nome";
    String COLUMN_TELEFONE= "telefone";
    String COLUMN_EMAIL   = "email";

    String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] ( " +
                    "[" + COLUMN_ID       + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_NOME     + "] TEXT UNIQUENOT NULL, " +
                    "[" + COLUMN_TELEFONE + "] TEXT UNIQUE NOT NULL, " +
                    "[" + COLUMN_EMAIL    + "] TEXT NOT NULL)";

    String DROP_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
}

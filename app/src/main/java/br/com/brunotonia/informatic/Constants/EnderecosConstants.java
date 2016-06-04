package br.com.brunotonia.informatic.Constants;

/**
 * Created by bruno on 03/06/16.
 */
public interface EnderecosConstants {
    String TABLE_NAME     = "enderecos";
    String COLUMN_ID      = "id";
    String COLUMN_CLIENTE = "cliente";
    String COLUMN_RUA     = "rua";
    String COLUMN_NUMERO  = "senha";
    String COLUMN_CIDADE  = "cidade";

    String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] ( " +
                    "[" + COLUMN_ID      + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                    "[" + COLUMN_CLIENTE + "] INTEGER NOT NULL, " +
                    "[" + COLUMN_RUA + "] TEXT NOT NULL, " +
                    "[" + COLUMN_NUMERO + "] TEXT NOT NULL, " +
                    "[" + COLUMN_CIDADE + "] TEXT NOT NULL, " +
                    "FOREIGN KEY([" + COLUMN_CLIENTE +"]) REFERENCES " + ClientesConstants.TABLE_NAME +
                    "(" +  ClientesConstants.COLUMN_ID + "))";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

}

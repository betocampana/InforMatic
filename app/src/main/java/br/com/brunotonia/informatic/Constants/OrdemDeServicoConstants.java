package br.com.brunotonia.informatic.Constants;

/**
 * Created by bruno on 04/06/16.
 */
public interface OrdemDeServicoConstants {
    String TABLE_NAME        = "ordemdeservico";
    String COLUMN_ID         = "id";
    String COLUMN_ENDERECO   = "endereco";
    String COLUMN_SITUACAO   = "situacao";
    String COLUMN_OBSERVACAO = "observacao";

    String CREATE_TABLE = "CREATE TABLE [" + TABLE_NAME + "] ( " +
            "[" + COLUMN_ID      + "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, " +
            "[" + COLUMN_ENDERECO + "] INTEGER NOT NULL, " +
            "[" + COLUMN_SITUACAO + "] INTEGER NOT NULL, " +
            "[" + COLUMN_OBSERVACAO + "] TEXT NOT NULL, " +
            "FOREIGN KEY([" + COLUMN_ENDERECO +"]) REFERENCES " + EnderecosConstants.TABLE_NAME +
            "(" +  ClientesConstants.COLUMN_ID + ")," +
            "FOREIGN KEY([" + COLUMN_SITUACAO +"]) REFERENCES " + OSSituacaoConstants.TABLE_NAME +
            "(" +  ClientesConstants.COLUMN_ID + "))";

    String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}

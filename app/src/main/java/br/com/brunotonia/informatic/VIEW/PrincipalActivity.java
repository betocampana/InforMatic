package br.com.brunotonia.informatic.VIEW;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.brunotonia.informatic.DAO.DatabaseHelper;
import br.com.brunotonia.informatic.R;

public class PrincipalActivity extends AppCompatActivity {


    // Variáveis de Sessão
    private Intent it = null;
    private Bundle params = null;

    // Declarando elementos de tela
    Button btnClientes = null;
    Button btnOrdemsDeServico = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Inicializando elementos de tela
        btnClientes = (Button) findViewById(R.id.btnClientes);
        btnOrdemsDeServico = (Button) findViewById(R.id.btnOrdensDeServico);

        // Listener btnClientes
        btnClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamarTelaClientes();
            }
        });

        // Listener btnOrdemsDeServicos
        btnOrdemsDeServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamarTelaOS();
            }
        });

        // Isso tá funcionando?
        try {
            DatabaseHelper dh = new DatabaseHelper(this);

        } catch (Exception e) {

        }

    }

    // Métodos Adicionais
    // Recuperar params
    private void recuperarParams() {
        it = getIntent();
        params = it.getExtras();
    }

    // Carregar params
    private void carregarParams() {
        params = new Bundle();
    }

    // Métodos para chamar novas telas
    private void chamarTelaClientes () {
        carregarParams();
        it = new Intent(this, ClientesMenuActivity.class);
        it.putExtras(params);
        startActivity(it);
    }

    private void chamarTelaOS () {
        carregarParams();
        it = new Intent(this, OSMenuActivity.class);
        it.putExtras(params);
        startActivity(it);
    }
}

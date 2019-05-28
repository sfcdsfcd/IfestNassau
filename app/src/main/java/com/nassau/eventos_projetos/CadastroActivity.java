package com.nassau.eventos_projetos;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nassau.eventos_projetos.Models.Usuario;

public class CadastroActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar tbNavigation;
    private TextInputEditText etUsuario, etNome, etSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        this.tbNavigation = this.findViewById(R.id.tb_navigation);
        this.etUsuario = this.findViewById(R.id.et_usuario_cadastro);
        this.etSenha = this.findViewById(R.id.et_senha_cadastro);
        this.etNome = this.findViewById(R.id.et_nome_cadastro);

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_black_24dp);
        tbNavigation.setNavigationIcon(drawable);
        setSupportActionBar(tbNavigation);
        getSupportActionBar().setTitle("Cadastro");

        final Intent login = new Intent(this, LoginActivity.class);
        tbNavigation.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(login);
            }
        });

    }

    private boolean verificaCampos() {

        boolean retorno = true;

        if(this.etUsuario.getText().toString().isEmpty()) {

            Toast.makeText(this, "Preencha o campo de usuário", Toast.LENGTH_SHORT).show();

            retorno = false;

        } else if((this.etSenha.getText().toString().isEmpty())) {

            Toast.makeText(this, "Preencha o campo de senha", Toast.LENGTH_SHORT).show();

            retorno = false;
        } else if(this.etNome.getText().toString().isEmpty()) {

            Toast.makeText(this, "Preencha o campo do nome", Toast.LENGTH_SHORT).show();

            retorno = false;
        }

        return retorno;

    }


    public void cadastrar(View view) {
        if(!this.verificaCampos()) return;

        try {

            Usuario usuarioCadastro = new Usuario(null, this.etNome.getText().toString(),
                                            this.etSenha.getText().toString(), this.etUsuario.getText().toString());


            startActivity(new Intent(this, MainActivity.class));
        } catch (Exception ex) {
            Toast.makeText(this, "Erro ao cadastrar usuário", Toast.LENGTH_SHORT).show();
        }
    }
}

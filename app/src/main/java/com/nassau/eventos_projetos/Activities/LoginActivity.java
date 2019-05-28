package com.nassau.eventos_projetos.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nassau.eventos_projetos.Models.Usuario;
import com.nassau.eventos_projetos.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etSenha;
    private TextView tvCadastrar;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.etUsuario = this.findViewById(R.id.et_usuario);
        this.etSenha = this.findViewById(R.id.et_senha);
        this.tvCadastrar = this.findViewById(R.id.tv_cadastrar);
        this.btnLogin = this.findViewById(R.id.btn_acessar);


        /* Define o listener do textView Cadastrar */
        this.btnCadastrarOnClick();
    }

    private boolean verificaCampos() {

        boolean retorno = true;

        if(this.etUsuario.getText().toString().isEmpty()) {
            retorno = false;
            Toast.makeText(this, "Preencha o campo de usuário", Toast.LENGTH_SHORT).show();

        } else if((this.etUsuario.getText().toString().isEmpty())) {
            Toast.makeText(this, "Preencha o campo de senha", Toast.LENGTH_SHORT).show();

            retorno = false;
        }

        return retorno;

    }

    public void logar(View view) {

        if(!this.verificaCampos()) return;

        try {

            this.btnLogin.setEnabled(false);

            Usuario usuarioLogin = new Usuario(null, "Nome Completo de Teste",
                    this.etSenha.getText().toString(), this.etUsuario.getText().toString());

            Intent main = new Intent(this, MainActivity.class);
            main.putExtra("NOME_USUARIO", usuarioLogin.getNome());
            main.putExtra("USERNAME_USUARIO", usuarioLogin.getUsername());
            startActivity(main);


        } catch (Exception ex) {

            Toast.makeText(this, "Erro ao fazer login", Toast.LENGTH_SHORT).show();

        } finally {

            this.btnLogin.setEnabled(true);

        }


    }

    private void btnCadastrarOnClick() {
        final Intent cadastro = new Intent(this, CadastroActivity.class);
        this.tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cadastro);
            }
        });
    }

}

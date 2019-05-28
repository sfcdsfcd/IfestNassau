package com.nassau.eventos_projetos;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class CadastroActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar tbNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        this.tbNavigation = this.findViewById(R.id.tb_navigation);

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

    public void cadastrar(View view) {

    }
}

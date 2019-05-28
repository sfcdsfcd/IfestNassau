package com.nassau.eventos_projetos;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nassau.eventos_projetos.Models.Usuario;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar tbNavigation;
    private Usuario mUsuarioLogado;
    private TextView tvNome, tvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.tbNavigation = this.findViewById(R.id.tb_navigation_profile);
        this.initToolBar();
        this.mUsuarioLogado = new Usuario(null, null, null, null);
        if (savedInstanceState == null) {

            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            } else {
                mUsuarioLogado.setNome(extras.getString("NOME_USUARIO"));
                mUsuarioLogado.setUsername(extras.getString("USERNAME_USUARIO"));
            }
        } else {
            mUsuarioLogado.setNome((String) savedInstanceState.getSerializable("NOME_USUARIO"));
            mUsuarioLogado.setUsername((String) savedInstanceState.getSerializable("USERNAME_USUARIO"));
        }

        this.tvNome = this.findViewById(R.id.tv_nome_profile);
        this.tvUsername = this.findViewById(R.id.tv_username_profile);

        this.tvNome.setText(mUsuarioLogado.getNome());
        this.tvUsername.setText(mUsuarioLogado.getUsername());
    }

    private void initToolBar() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_black_24dp);
        tbNavigation.setNavigationIcon(drawable);
        setSupportActionBar(tbNavigation);
        getSupportActionBar().setTitle("Perfil");

        final Intent main = new Intent(this, MainActivity.class);
        tbNavigation.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(main);
            }
        });
    }

    public void logout(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}

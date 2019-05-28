package com.nassau.eventos_projetos.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nassau.eventos_projetos.Models.Evento;
import com.nassau.eventos_projetos.R;
import com.squareup.picasso.Picasso;

public class EventoDetailActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolBar;
    private ImageView mImageEvento;
    private TextView mTitulo, mPreco, mDesc;
    private Evento mEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_detail);

        this.mEvento = new Evento(null, null, null, 0, null, null);

        if (savedInstanceState == null) {

            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                startActivity(new Intent(EventoDetailActivity.this, MainActivity.class));
            } else {
                mEvento.setNome(extras.getString("TITULO_EVENTO"));
                mEvento.setDesc(extras.getString("DESC_EVENTO"));
                mEvento.setValor(extras.getDouble("PRECO_EVENTO"));
                mEvento.setImagem(extras.getString("FOTO_EVENTO"));

            }
        } else {
            mEvento.setNome((String) savedInstanceState.getSerializable("TITULO_EVENTO"));
            mEvento.setDesc((String) savedInstanceState.getSerializable("DESC_EVENTO"));
            mEvento.setValor((double) savedInstanceState.getSerializable("PRECO_EVENTO"));
            mEvento.setImagem((String) savedInstanceState.getSerializable("FOTO_EVENTO"));
        }

        this.mToolBar = this.findViewById(R.id.tb_navigation_detail);
        this.mTitulo = this.findViewById(R.id.tv_titulo_evento);
        this.mPreco = this.findViewById(R.id.tv_preco_evento);
        this.mDesc = this.findViewById(R.id.tv_desc_evento);
        this.mImageEvento = this.findViewById(R.id.img_evento_detail);

        this.mDesc.setText(mEvento.getDesc());
        this.mPreco.setText("R$" + String.valueOf(mEvento.getValor()));
        this.mTitulo.setText(mEvento.getNome());

        Picasso.with(this)
                .load(mEvento.getImagem())
                .into(mImageEvento);

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_black_24dp);
        mToolBar.setNavigationIcon(drawable);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Detalhes");

        final Intent main = new Intent(this, MainActivity.class);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(main);
            }
        });
    }

    public void comprarIngresso(View view) {

    }
}

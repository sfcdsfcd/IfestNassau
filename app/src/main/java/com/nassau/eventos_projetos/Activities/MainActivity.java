package com.nassau.eventos_projetos.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.View;
import android.widget.AdapterView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.nassau.eventos_projetos.Adapters.EventoAdapter;
import com.nassau.eventos_projetos.Adapters.RecyclerItemClickListener;
import com.nassau.eventos_projetos.Models.Evento;
import com.nassau.eventos_projetos.Models.Usuario;
import com.nassau.eventos_projetos.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private SliderLayout mSliderLayout;
    private android.support.v7.widget.Toolbar tbNavigation;
    private RecyclerView rvEventos;
    private List<Evento> mEventosTopList;
    private List<Evento> mEventosList;
    private Usuario mUsuarioLogado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mUsuarioLogado = new Usuario(null, null, null, null);

        if (savedInstanceState == null) {

            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            } else {
                mUsuarioLogado.setNome(extras.getString("NOME_USUARIO"));
                mUsuarioLogado.setUsername(extras.getString("USERNAME_USUARIO"));

            }
        } else {
            mUsuarioLogado.setNome((String) savedInstanceState.getSerializable("NOME_USUARIO"));
            mUsuarioLogado.setUsername((String) savedInstanceState.getSerializable("USERNAME_USUARIO"));
        }

        mSliderLayout = this.findViewById(R.id.sl_eventos);
        rvEventos = this.findViewById(R.id.rv_eventos);
        tbNavigation = this.findViewById(R.id.tb_navigation_main);
        this.mEventosList = new ArrayList<>();
        this.mEventosTopList = new ArrayList<>();

        this.mEventosTopList = retornaListaEventos(true);
        this.mEventosList = retornaListaEventos(false);

        this.initToolBar();



        for(Evento evento : mEventosTopList){
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(evento.getNome())
                    .image(evento.getImagem())
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", evento.getId());

            mSliderLayout.addSlider(textSliderView);
        }
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setDuration(4000);
        mSliderLayout.addOnPageChangeListener(this);

        this.initRvEventos();

    }

    private void startDetailAct(Evento evento) {

        if(evento == null) return;

        Intent mDetailActivity = new Intent(this, EventoDetailActivity.class);
        mDetailActivity.putExtra("FOTO_EVENTO", evento.getImagem());
        mDetailActivity.putExtra("TITULO_EVENTO", evento.getNome());
        mDetailActivity.putExtra("DESC_EVENTO", evento.getDesc());
        mDetailActivity.putExtra("PRECO_EVENTO", evento.getValor());

        startActivity(mDetailActivity);

    }

    private void initRvEventos() {
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        rvEventos.setLayoutManager(manager);
        rvEventos.setAdapter(new EventoAdapter(mEventosList, getApplicationContext()));
        rvEventos.setHasFixedSize(true);
        rvEventos.addOnItemTouchListener(new RecyclerItemClickListener(this, rvEventos, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Evento evento = mEventosList.get(position);
                startDetailAct(evento);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    private void initToolBar() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_person_black_24dp);
        tbNavigation.setNavigationIcon(drawable);
        setSupportActionBar(tbNavigation);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final Intent profile = new Intent(this, ProfileActivity.class);
        profile.putExtra("NOME_USUARIO", this.mUsuarioLogado.getNome());
        profile.putExtra("USERNAME_USUARIO", this.mUsuarioLogado.getUsername());

        tbNavigation.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(profile);
            }
        });
    }

    private List<Evento> retornaListaEventos(boolean top) {

        List<Evento> vListaRetorno = new ArrayList<>();

        if(top) {

            vListaRetorno.add(new Evento("1", "São João de Limoeiro", "Limoeiro - PE",
                    100.00, "https://tvdiariamente.com.br/wp-content/uploads/2019/05/04-14-720x445.jpg",
                    "O maior evento de São João do interior com OPEN BAR de cerveja Skol!"));

            vListaRetorno.add(new Evento("2", "São João de Caruaru", "Caruaru - PE",
                    300.00, "https://i.ytimg.com/vi/6n4fxstxX_s/maxresdefault.jpg",
                    "O maior evento de Pernambuco contará com 3 atrações surpresas"));

            vListaRetorno.add(new Evento("3", "São Gião - Open Bar", "Recife - PE",
                    50.00, "https://confiramais.com.br/wp-content/uploads/2015/04/sao-giao-recife-vendas-ingresso-prime.jpg",
                    "Open bar até as 3h da manhã de Smirnoff, meia entrada para as mulheres"));


        } else {

            vListaRetorno.add(new Evento("1", "São João de Limoeiro", "Limoeiro - PE",
                    100.00, "https://tvdiariamente.com.br/wp-content/uploads/2019/05/04-14-720x445.jpg",
                    "O maior evento de São João do interior com OPEN BAR de cerveja Skol!"));

            vListaRetorno.add(new Evento("2", "São João de Caruaru", "Caruaru - PE",
                    300.00, "https://i.ytimg.com/vi/6n4fxstxX_s/maxresdefault.jpg",
                    "O maior evento de Pernambuco contará com 3 atrações surpresas"));

            vListaRetorno.add(new Evento("3", "São Gião - Open Bar", "Recife - PE",
                    50.00, "https://confiramais.com.br/wp-content/uploads/2015/04/sao-giao-recife-vendas-ingresso-prime.jpg",
                    "Open bar até as 3h da manhã de Smirnoff, meia entrada para as mulheres"));

            vListaRetorno.add(new Evento("3", "São João de Carpina", "Carpina - PE",
                    100.00, "https://www.meggashop.com.br/wp-content/uploads/2015/06/imagem-post.jpg",
                    "As melhores pessoas, os melhores cantores só em Carpina!"));


        }

        return vListaRetorno;

    }


    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mSliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        String id = (String) slider.getBundle().get("extra");
        Evento evento = new Evento(id, null, null, 0, null, null);
        for(Evento evento1 : this.mEventosTopList) {
            if(evento1.getId().equals(id)){
                evento = evento1;
                break;
            }
        }

        startDetailAct(evento);

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}

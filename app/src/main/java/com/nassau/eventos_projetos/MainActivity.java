package com.nassau.eventos_projetos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.nassau.eventos_projetos.Adapters.EventoAdapter;
import com.nassau.eventos_projetos.Adapters.RecyclerItemClickListener;
import com.nassau.eventos_projetos.Models.Evento;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private SliderLayout mSliderLayout;
    private RecyclerView rvEventos;
    private List<Evento> mEventoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSliderLayout = this.findViewById(R.id.sl_eventos);
        rvEventos = this.findViewById(R.id.rv_eventos);
        this.mEventoList = new ArrayList<>();
        HashMap<String,String> url_maps = new HashMap<String, String>();

        url_maps.put("Hannibal", "https://www.shopping-guararapes.com/files/news/15581168059759-arraial_bannernotcia750x456px.jpg");
        url_maps.put("Big Bang Theory", "https://s3.amazonaws.com/jgdprod-blogs-us/blogs/wp-content/uploads/sites/116/2017/06/18920979_832885650193103_713578010828070196_o.jpg");
        url_maps.put("House of Cards", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPEkx2XP78sJSz8KuIeOoTLJiRg-XDR-db4YkzSSGWrIZPz2un8m7V4mxh");


        this.mEventoList.add(new Evento(null, "teste",
                "rua sao sebastiao", 3.33, Uri.parse("https://www.shopping-guararapes.com/files/news/15581168059759-arraial_bannernotcia750x456px.jpg")));

        this.mEventoList.add(new Evento(null, "teste",
                "rua sao sebastiao", 3.33, Uri.parse("https://www.shopping-guararapes.com/files/news/15581168059759-arraial_bannernotcia750x456px.jpg")));

        this.mEventoList.add(new Evento(null, "teste",
                "rua sao sebastiao", 3.33, Uri.parse("https://www.shopping-guararapes.com/files/news/15581168059759-arraial_bannernotcia750x456px.jpg")));

        this.mEventoList.add(new Evento(null, "teste",
                "rua sao sebastiao", 3.33, Uri.parse("https://www.shopping-guararapes.com/files/news/15581168059759-arraial_bannernotcia750x456px.jpg")));

        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mSliderLayout.addSlider(textSliderView);
        }
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setDuration(4000);
        mSliderLayout.addOnPageChangeListener(this);

        this.initRvEventos();

    }

    private void initRvEventos() {
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        rvEventos.setLayoutManager(manager);
        rvEventos.setAdapter(new EventoAdapter(mEventoList, getApplicationContext()));
        rvEventos.setHasFixedSize(true);
        rvEventos.addOnItemTouchListener(new RecyclerItemClickListener(this, rvEventos, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Estabelecimento ent = estList.get(position);
//                SharedPreferences estChosen = getSharedPreferences("est_chosen", MODE_PRIVATE);
//                SharedPreferences.Editor editor = estChosen.edit();
//                editor.putString("nome_local", ent.getNomeLugar());
//                editor.putString("tipo_local", ent.getTipoLugar());
//                editor.putString("id", ent.getId());
//                editor.putString("rua", rua);
//                editor.commit();
//                Intent gerarSenha = new Intent(MainActivity.this,  GerarSenhaActivity.class);
//                startActivity(gerarSenha);
//                finish();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mSliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
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

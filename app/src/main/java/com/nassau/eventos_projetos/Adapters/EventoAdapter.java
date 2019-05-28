package com.nassau.eventos_projetos.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nassau.eventos_projetos.Models.Evento;
import com.nassau.eventos_projetos.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventoAdapter  extends RecyclerView.Adapter<EventoAdapter.EventoViewHolder> {
    private List<Evento> eventoList;
    private Context context;

    public EventoAdapter(List<Evento> estabelecimentoList, Context context) {
        this.eventoList = estabelecimentoList;
        this.context = context;
    }

    @NonNull
    @Override
    public EventoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_rv_evento, parent, false);
        return new EventoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoViewHolder holder, int position) {
        Evento mEvento = eventoList.get(position);
        holder.nomeEvento.setText(mEvento.getNome());
        holder.precoEvento.setText(Double.toString(mEvento.getValor()));
        holder.imagemEvento.setImageURI(mEvento.getImagem());
    }

    @Override
    public int getItemCount() {
        return eventoList.size();
    }

    public class EventoViewHolder extends RecyclerView.ViewHolder{
        private TextView nomeEvento, precoEvento;
        private ImageView imagemEvento;
        public EventoViewHolder(View itemView) {
            super(itemView);
            nomeEvento = itemView.findViewById(R.id.nome_evento);
            precoEvento = itemView.findViewById(R.id.preco_evento);
            imagemEvento = itemView.findViewById(R.id.img_evento);
        }
    }
}

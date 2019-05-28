package com.nassau.eventos_projetos.Models;

import android.net.Uri;

public class Evento {

    private String id;
    private String nome;
    private String endereco;
    private double valor;
    private Uri imagem;

    public Evento(String id, String nome, String endereco, double valor, Uri imagem) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.valor = valor;
        this.imagem = imagem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValor() {
        return valor;
    }

    public Uri getImagem() {
        return imagem;
    }

    public void setImagem(Uri imagem) {
        this.imagem = imagem;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

package com.nassau.eventos_projetos.Models;

import android.net.Uri;

public class Evento {

    private String id;
    private String nome;
    private String endereco;
    private double valor;
    private String imagem;
    private String desc;



    public Evento(String id, String nome, String endereco, double valor, String imagem, String desc) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.valor = valor;
        this.imagem = imagem;
        this.desc = desc;
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

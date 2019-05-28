package com.nassau.eventos_projetos.Models;

public class Evento {

    private String id;
    private String nome;
    private String endereco;
    private float valor;

    public Evento(String id, String nome, String endereco, float valor) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.valor = valor;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}

package com.nassau.eventos_projetos.Models;

public class Usuario {

    private String id;
    private String nome;
    private String senha;
    private String username;

    public Usuario(String pId, String pNome, String pSenha, String pUsername) {
        this.id = pId;
        this.nome = pNome;
        this.senha = pSenha;
        this.username = pUsername;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

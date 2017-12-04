package br.senac.tads4b.as.restfullp2.model;

public class Pessoa {
    private Integer id;
    private String nome;
    private String profissao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Pessoa(Integer id, String nome, String profissao) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
    }
}

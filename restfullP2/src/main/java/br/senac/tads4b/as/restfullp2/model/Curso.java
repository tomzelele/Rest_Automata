package br.senac.tads4b.as.restfullp2.model;

public class Curso {
    private Integer id;
    private String nome;
    private String duracao;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
  
    public Curso(Integer id, String nome, String duracao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDuracao() {
        return duracao;
    }    
}

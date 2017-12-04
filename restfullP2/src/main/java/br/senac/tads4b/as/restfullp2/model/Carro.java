package br.senac.tads4b.as.restfullp2.model;

public class Carro {
    private Integer id;
    private String modelo;
    private String marca;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Carro(Integer id, String modelo, String marca) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }
}

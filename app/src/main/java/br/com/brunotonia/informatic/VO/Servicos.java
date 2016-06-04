package br.com.brunotonia.informatic.VO;

/**
 * Created by bruno on 03/06/16.
 */
public class Servicos {

    private Long id;
    private String descricao;
    private Float valor;

    public Servicos(String descricao, Float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Servicos(Long id, String descricao, Float valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}

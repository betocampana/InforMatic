package br.com.brunotonia.informatic.VO;

/**
 * Created by bruno on 03/06/16.
 */
public class Enderecos {

    private Long id;
    private Long cliente;
    private String rua;
    private String numero;
    private String cidade;

    public Enderecos(Long cliente, String rua, String numero, String cidade) {
        this.cliente = cliente;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
    }

    public Enderecos(Long id, Long cliente, String rua, String numero, String cidade) {
        this.id = id;
        this.cliente = cliente;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

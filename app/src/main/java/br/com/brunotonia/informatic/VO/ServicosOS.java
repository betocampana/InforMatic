package br.com.brunotonia.informatic.VO;

/**
 * Created by bruno on 04/06/16.
 */
public class ServicosOS {

    private Long id;
    private Long ordemDeServico;
    private Float valor;

    public ServicosOS(Long ordemDeServico, Float valor) {
        this.ordemDeServico = ordemDeServico;
        this.valor = valor;
    }

    public ServicosOS(Long id, Long ordemDeServico, Float valor) {
        this.id = id;
        this.ordemDeServico = ordemDeServico;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(Long ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}

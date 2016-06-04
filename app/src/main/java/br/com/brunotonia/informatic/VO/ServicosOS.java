package br.com.brunotonia.informatic.VO;

/**
 * Created by bruno on 04/06/16.
 */
public class ServicosOS {

    private Long id;
    private Long ordemDeServico;
    private Long servico;
    private Float valor;

    public ServicosOS(Long ordemDeServico, Long servico, Float valor) {
        this.ordemDeServico = ordemDeServico;
        this.servico = servico;
        this.valor = valor;
    }

    public ServicosOS(Long id, Long ordemDeServico, Long servico, Float valor) {
        this.id = id;
        this.ordemDeServico = ordemDeServico;
        this.servico = servico;
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

    public Long getServico() {
        return servico;
    }

    public void setServico(Long servico) {
        this.servico = servico;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}

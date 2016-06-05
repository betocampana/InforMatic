package br.com.brunotonia.informatic.VO;

/**
 * Created by bruno on 03/06/16.
 */
public class OrdemDeServico {

    private Long id;
    private Long endereco;
    private Long situacao;
    private String descricao;

    public OrdemDeServico(Long endereco, Long situacao, String descricao) {
        this.endereco = endereco;
        this.situacao = situacao;
        this.descricao = descricao;
    }

    public OrdemDeServico(Long id, Long endereco, Long situacao, String descricao) {
        this.id = id;
        this.endereco = endereco;
        this.situacao = situacao;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEndereco() {
        return endereco;
    }

    public void setEndereco(Long endereco) {
        this.endereco = endereco;
    }

    public Long getSituacao() {
        return situacao;
    }

    public void setSituacao(Long situacao) {
        this.situacao = situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

/**
 * @author Gabri
 */

package br.com.clark.domain;

public class Produto {

    private Long id;

    private String codigo;

    private String nome;

    private Integer qtd;

    public Produto() {

    }

    public Produto(String codigo, String nome, Integer qtd) {
        this.codigo = codigo;
        this.nome = nome;
        this.qtd = qtd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
}

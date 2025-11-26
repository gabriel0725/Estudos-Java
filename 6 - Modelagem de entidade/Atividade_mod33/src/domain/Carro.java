/**
 * @author Gabri
 */

package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carro")
    @SequenceGenerator(name = "seq_carro", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME",length = 50, nullable = false)
    private String nome;

    @Column(name = "ano", length = 4, nullable = false)
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_marca_carro"),
            referencedColumnName = "id", nullable = false)
    private Marca marca;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "TB_CARRO_ACESSORIO",
            joinColumns = {@JoinColumn( name = "id_carro_fk") },
            inverseJoinColumns = { @JoinColumn(name = "id_acessorio_fk") }
    )
    private List<Acessorio> acessorios;

    public Carro(){
        this.acessorios = new ArrayList<Acessorio>();
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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public void add(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }
}

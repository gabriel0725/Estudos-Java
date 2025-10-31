package gabriel.stream.exemplo;

import java.util.List;

public class Pessoa {


    String id;
    String nome;
    String nacionalidade;
    int idade;

    public Pessoa() {

    }

    public Pessoa(String id, String nome, String nacionalidade, int idade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
    }

    public List populaPessoa() {
        Pessoa pessoa1 = new Pessoa("1", "Clark", "Brasileira", 25);
        Pessoa pessoa2 = new Pessoa("2", "Paloma", "Brasileira", 28);
        Pessoa pessoa3 = new Pessoa("3", "Maristela", "Turca", 17);
        Pessoa pessoa4 = new Pessoa("4", "Robsberto", "Russo", 30);
        return List.of(pessoa1, pessoa2, pessoa3, pessoa4);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", idade=" + idade +
                '}';
    }
}

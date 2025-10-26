/**
 * @author Gabri
 */

package gabriel.usuario;

import gabriel.anotation.Tabela;

@Tabela(nome = "Nome da tabela 123")
public class Usuario {
    private String nome;
    private int idade;

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

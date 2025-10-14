/**
 * @author Gabri
 */

public class PessoaJuridica extends Pessoa{

    String cnpj;

    public PessoaJuridica(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    @Override
    public void exibirDados() {
        System.out.println("Pessoa Juridica: " + nome + ", CNPJ: " + cnpj);
    }
}

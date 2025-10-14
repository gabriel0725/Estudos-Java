/**
 * @author Gabri
 */

public class PessoaFisica extends Pessoa {

    String cpf;

    public PessoaFisica(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }


    @Override
    public void exibirDados() {
        System.out.println("Pessoa fisica: " + nome + ", CPF: " + cpf);
    }
}

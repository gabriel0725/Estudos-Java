/**
 * @author Gabri
 */

public class Main {
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica("Clark", "999.999.999-99");
        PessoaJuridica pj = new PessoaJuridica("Company", "88.888.888/0008-88");

        pf.exibirDados();
        pj.exibirDados();
    }
}

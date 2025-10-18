/**
 * @author Gabri
 */

package gabriel.dev.carro;

public class Carro implements ICarro{

    String nomeDoCarro;


    @Override
    public void infosCarro(String nomeCarro, Integer ano) {
        this.nomeDoCarro = nomeCarro;
        System.out.println("Carro: %s \nAno: %s".formatted(nomeCarro, ano));
    }

    @Override
    public void acelerar() {
        System.out.println("%s esta acelerando".formatted(nomeDoCarro));
    }
}

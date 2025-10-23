/**
 * @author Gabri
 */

package gabriel;

import gabriel.carro.Carro;
import gabriel.lista.ListaDeCarros;

public class Main {
    public static void main(String[] args) {
        ListaDeCarros lista1 = new ListaDeCarros();

        Carro carroTeste = new Carro("Carro de teste", "testando");

        lista1.adicionar(new Carro("Nissan", "Tiida"));
        lista1.adicionar(new Carro("Toyota", "Etios"));
        lista1.adicionar(new Carro("Honda", "Civic"));
        lista1.adicionar(carroTeste);
        lista1.adicionar("carro sobrecarga", "deu certo");


        lista1.imprimirLista();

        System.out.println("\nPrimeiro carro: " + lista1.buscarPorIndice(1));
        System.out.println("Total de carros: " + lista1.tamanho());
    }
}

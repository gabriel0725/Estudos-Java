/**
 * @author Gabri
 */

package gabriel;

import gabriel.carro.Carro;
import gabriel.carro.Civic;
import gabriel.carro.Etios;
import gabriel.carro.Tiida;
import gabriel.lista.ListaDeCarros;

public class Main {
    public static void main(String[] args) {
        ListaDeCarros lista = new ListaDeCarros();

        Carro tiida = new Tiida();
        Carro civic = new Civic();
        Carro etios = new Etios();

        lista.adicionar(tiida);
        lista.adicionar(civic);
        lista.adicionar(etios);

        lista.imprimirLista();

        System.out.println("\nCarro no índice 1: " + lista.buscarPorIndice(1));
        System.out.println("Total de carros: " + lista.tamanho());

    }
}

/**
 * @author Gabri
 */

package gabriel.dev;

import gabriel.dev.cliente.Cliente;
import gabriel.dev.fabricas.FabricaCarroCombustao;
import gabriel.dev.fabricas.FabricaCarroEletrico;

public class Main {
    public static void main(String[] args) {

        System.out.println("Carros com motor a combustão:\n");

        Cliente carroCombustão1 = new Cliente(new FabricaCarroCombustao());
        Cliente carroCombustão2 = new Cliente(new FabricaCarroCombustao());

        carroCombustão1.criarCarro("Tiida", 2012);
        System.out.printf("\n");
        carroCombustão2.criarCarro("Civic", 2008);



        System.out.println("\nCarros com motor elétrico:\n");
        Cliente carroEletrico1 = new Cliente(new FabricaCarroEletrico());
        Cliente carroEletrico2 = new Cliente(new FabricaCarroEletrico());

        carroEletrico1.criarCarro("King",2022);
        System.out.printf("\n");
        carroEletrico2.criarCarro("Leaf", 2020);
    }
}

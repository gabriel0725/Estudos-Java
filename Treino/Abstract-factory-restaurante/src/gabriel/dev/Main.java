/**
 * @author Gabri
 */

package gabriel.dev;

import gabriel.dev.clientes.Cliente;
import gabriel.dev.fabricas.DeliveryFactory;
import gabriel.dev.fabricas.HamburgeriaFactory;
import gabriel.dev.fabricas.PizzariaFactory;

public class Main {

    public static void main(String[] args) {

        System.out.println("Pedido na hamburgueria:");
        Cliente clienteHamburguer = new Cliente(new HamburgeriaFactory());
        clienteHamburguer.criaPedido("cebola");

        System.out.println("");

        System.out.println("Pedido na pizzaria:");
        Cliente clientePizzaria = new Cliente(new PizzariaFactory());
        clientePizzaria.criaPedido("azeitona");
    }
}

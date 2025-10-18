/**
 * @author Gabri
 */

package gabriel.dev.clientes;

import gabriel.dev.bebidas.Bebida;
import gabriel.dev.comidas.Comida;
import gabriel.dev.fabricas.DeliveryFactory;

public class Cliente {

    private DeliveryFactory fabrica;

    public Cliente(DeliveryFactory fabrica) {
        this.fabrica = fabrica;
    }

    public void criaPedido(String ingrediente) {
        Comida comida = fabrica.criaComida();
        Bebida bebida = fabrica.criaBebida();

        comida.removeIngrediente(ingrediente);
        bebida.escolherSemAcucar();
    }
}

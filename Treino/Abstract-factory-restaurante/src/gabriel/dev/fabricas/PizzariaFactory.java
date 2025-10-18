/**
 * @author Gabri
 */

package gabriel.dev.fabricas;

import gabriel.dev.bebidas.Bebida;
import gabriel.dev.bebidas.Refrigerante;
import gabriel.dev.comidas.Comida;
import gabriel.dev.comidas.Pizza;

public class PizzariaFactory implements DeliveryFactory{

    @Override
    public Comida criaComida() {
        return new Pizza();
    }

    @Override
    public Bebida criaBebida() {
        return new Refrigerante();
    }
}

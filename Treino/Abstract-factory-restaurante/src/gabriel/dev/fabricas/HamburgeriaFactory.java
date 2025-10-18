/**
 * @author Gabri
 */

package gabriel.dev.fabricas;

import gabriel.dev.bebidas.Bebida;
import gabriel.dev.bebidas.Milkshake;
import gabriel.dev.comidas.Comida;
import gabriel.dev.comidas.Hamburger;

public class HamburgeriaFactory implements DeliveryFactory{

    @Override
    public Comida criaComida() {
        return new Hamburger();
    }

    @Override
    public Bebida criaBebida() {
        return new Milkshake();
    }
}

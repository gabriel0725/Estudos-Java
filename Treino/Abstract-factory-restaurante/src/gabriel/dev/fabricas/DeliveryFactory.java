package gabriel.dev.fabricas;

import gabriel.dev.bebidas.Bebida;
import gabriel.dev.comidas.Comida;

public interface DeliveryFactory {

    Comida criaComida();

    Bebida criaBebida();
}

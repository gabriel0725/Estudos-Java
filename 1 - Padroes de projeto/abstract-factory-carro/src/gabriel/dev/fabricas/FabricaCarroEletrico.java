/**
 * @author Gabri
 */

package gabriel.dev.fabricas;

import gabriel.dev.carro.Carro;
import gabriel.dev.carro.ICarro;
import gabriel.dev.motor.IMotor;
import gabriel.dev.motor.MotorEletrico;

public class FabricaCarroEletrico implements IFabricaDeCarros{
    @Override
    public ICarro criarCarro() {
        return new Carro();
    }

    @Override
    public IMotor criarMotor() {
        return new MotorEletrico();
    }
}

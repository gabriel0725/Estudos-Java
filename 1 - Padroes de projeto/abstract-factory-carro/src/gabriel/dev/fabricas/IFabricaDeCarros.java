package gabriel.dev.fabricas;

import gabriel.dev.carro.ICarro;
import gabriel.dev.motor.IMotor;

public interface IFabricaDeCarros {

    ICarro criarCarro();

    IMotor criarMotor();
}

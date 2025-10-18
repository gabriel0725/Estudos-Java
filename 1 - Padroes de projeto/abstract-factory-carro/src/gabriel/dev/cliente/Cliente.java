/**
 * @author Gabri
 */

package gabriel.dev.cliente;

import gabriel.dev.carro.ICarro;
import gabriel.dev.fabricas.IFabricaDeCarros;
import gabriel.dev.motor.IMotor;

public class Cliente {

    private IFabricaDeCarros fabrica;

    public Cliente(IFabricaDeCarros fabrica){
        this.fabrica = fabrica;
    }

    public void criarCarro(String nomeCarro, Integer ano) {
        ICarro carro = fabrica.criarCarro();
        IMotor motor = fabrica.criarMotor();

        carro.infosCarro(nomeCarro, ano);
        motor.tipoMotor();
        carro.acelerar();
    }
}

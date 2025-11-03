package br.com.clark;

import org.junit.Assert;
import org.junit.Test;

public class TesteClientTest {

    @Test
    public void testeClasseCliente() {
        TesteCliente cli = new TesteCliente();
        cli.adicionarNome("Clark");


        Assert.assertEquals("Paloma", cli.getNome());
    }
}

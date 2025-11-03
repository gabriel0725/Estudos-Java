package gabriel.dev;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StreamTest {

    @Test
    public void deveRetornarMulheres() {
        List<String> entrada = List.of(
                "Clark - M",
                "Paloma - f",
                "Thiago - m",
                "Livia - F",
                "Pamela - F"
        );

        List<String> resultado = App.FiltrarPessoa(entrada);

        Assert.assertEquals(3, resultado.size());

        Assert.assertTrue(resultado.stream().allMatch(s -> s.toUpperCase().contains("F")));
    }
}

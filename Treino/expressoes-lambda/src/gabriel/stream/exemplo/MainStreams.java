package gabriel.stream.exemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainStreams {
    static void main(String[] args) {
        List<Pessoa> listaPessoas = new Pessoa().populaPessoa();


        listaPessoas.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equalsIgnoreCase("turca"))
                .forEach(System.out::println);


    }
}

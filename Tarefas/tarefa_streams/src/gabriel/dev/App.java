package gabriel.dev;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    static void main(String[] args) {

        //Scanner para entrada de dados
        Scanner input = new Scanner(System.in);

        System.out.println("Digite no formato 'NOME - SEXO (M/F)' separados por virgula ',':");

        //variavel ENTRADA recebe a string escrita no terminal
        String entrada = input.nextLine();


        //Array de Strings "pessoasArray" recebe os valores que foram guardados em
        // ENTRADA mas separando por virgula
        String[] pessoasArray = entrada.split(",");

        //Lista de strings PESSOAS é transformada em uma stream, MAP para cada pessoa esta
        // tirando os espaçoes em branco e colocando tudo em maiusculo
        //collect esta transformando a strem novamente em uma lista
        List<String> pessoas = Arrays.stream(pessoasArray)
                .map(pessoa -> pessoa.trim().toUpperCase())
                .collect(Collectors.toList());

        //Lista PESSOASFILTRADAS é transformada em uma stream, filter para cada PESSOA
        //divide a string pessoa em duas partes, usando o - como separador
        //Exemplo: "Maria - F" vira ["Maria ", " F"]
        List<String> pessoasFiltradas = pessoas.stream()
                .filter(pessoa -> {
                    String[] partes = pessoa.split("-");
                    //confere se foi dividido em duas partes (nome e sexo)
                    //Pega a segunda parte (partes[1]), que representa o sexo, remove os espaços em branco
                    //e deixa maiuscula
                    if(partes.length == 2) {
                        String sexo = partes[1].trim().toUpperCase();
                        //verifica qual a letra do sexo (F ou M)
                        return sexo.equals("F");
                    } else {
                        return false;
                    }
                })
                //coleta as informações filtradas do stream e transforma em lista novamente
                .collect(Collectors.toList());

        System.out.println("\nPessoas encontradas:");

        //para cada pessoa filtrada, imprime na tela a pessoa filtrada
        pessoasFiltradas.forEach(filtrada -> System.out.println(filtrada));

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Gabri
 */

public class Parte2 {


        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);

            ArrayList<String> masculino = new ArrayList<>();
            ArrayList<String> feminino = new ArrayList<>();

            System.out.println("Digite no formato 'NOME - SEXO (M/F)' separados por virgula ',':");
            String entrada = s.nextLine();

            String[] pessoas = entrada.split(",");



            for (String pessoa : pessoas) {
                String[] dados = pessoa.trim().split(" - ");

                if(dados.length == 2) {
                    String nome = dados[0].trim();
                    String sexo = dados[1].trim().toUpperCase();

                    if (sexo.equals("M")) {
                        masculino.add(nome);
                    } else if (sexo.equals("F")) {
                        feminino.add(nome);
                    }
                }

            }

            Collections.sort(feminino);
            Collections.sort(masculino);

            System.out.println("Pessoas do sexo masculino:");
            for (String nome : masculino) {
                System.out.println(nome);
            }

            System.out.println("\nPessoas do sexo feminino:");
            for (String nome : feminino) {
                System.out.println(nome);
            }
        }
    }



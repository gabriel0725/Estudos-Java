import java.util.Scanner;

/**
 * @author Gabri
 */

public class main {

    //metodo para calculo da media da nota do aluno
    public static void mediaAluno(double somaNota){

        //media das 4 notas
        double mediaNota = somaNota / 4;

        //se valor for maior ou igual a 7 = aprovado
        if (mediaNota >= 7) {
            System.out.println("Nota final: " + mediaNota);
            System.out.println("ALUNO APROVADO!!!");
        }
        //se valor for maior ou igual a 5 e menor que 7 = recuperação
        else if (mediaNota >=5){
            System.out.println("Nota final: " + mediaNota);
            System.out.println("ALUNO DE RECUPERAÇÃO :/");
        }
        //se valor for menor que 5 = reprovado
        else {
            System.out.println("Nota final: " + mediaNota);
            System.out.println("ALUNO REPROVADO :(");
        }
    }

    public static void main (String args[]){
        //scanner
        Scanner scanner = new Scanner(System.in);

        //variaveis iniciando em 0
        double somaDasNotas = 0;

        for (int i = 1; i < 5; i++) {
            System.out.println("digite a nota do " + i +"ª semestre do aluno");
            somaDasNotas += scanner.nextDouble();
        }

        //chamada do metodo com os valores das variaveis
        mediaAluno(somaDasNotas);

    }
}

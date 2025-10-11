import java.util.ArrayList;

/**
 * @author Gabri
 */

public class main {

    public static void main(String[] args) {

        String[] nomes = {"Clark", "Paloma", "Thiago", "Livia", "Guilherme", "Anne","Jhow", "Robert"};
        String[] sexos = {"M", "F", "M", "F", "M", "F", "M", "M"};

        //criandos listas para separar as pessoas pelo sexo
        ArrayList<String> grupoMasculino = new ArrayList<>();
        ArrayList<String> grupoFeminino = new ArrayList<>();
        
        //loop para separar os grupos
        for (int i = 0; i < nomes.length; i++) {
            if(sexos[i].equalsIgnoreCase("M")){
                grupoMasculino.add(nomes[i]);
            } else if (sexos[i].equalsIgnoreCase("F")) {
                grupoFeminino.add(nomes[i]);
            }
        }

        System.out.println("=============GRUPO MASCULINO=============");
        System.out.println(grupoMasculino);
        System.out.println("=============GRUPO FEMININO=============");
        System.out.println(grupoFeminino);
    }
}

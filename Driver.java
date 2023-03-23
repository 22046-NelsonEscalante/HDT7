import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        WordComparator comp = new WordComparator();
        Reader myReader = new Reader();
        ArrayList<String> file = new ArrayList<>();
        ArrayList<String> toTraduce = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        BinarySearchTree<String, String> engTree = new BinarySearchTree<>(comp, null);
        BinarySearchTree<String, String> frnTree = new BinarySearchTree<>(comp, null);

        try {
            file = myReader.read("diccionario.txt");
        } catch (Exception e) {
            System.out.println("Se necesita un diccionario con el nombre \"diccionario.txt\" para que el programa funcione.");
            System.exit(0);
        }

        for (String s : file) {
            String[] words = s.split(",");
            engTree.insert(words[1], words[0]);
            frnTree.insert(words[2], words[0]);
        }

        try {
            toTraduce = myReader.read("texto.txt");
        } catch (Exception e) {
            System.out.println("Se necesita un archivo con el nombre \"texto.txt\" para que el programa funcione.");
            System.exit(0);
        }

        for (String w : toTraduce) {
            String traduced = "";
            String[] word = w.split(" ");
            for (String v : word) {
                String traduction = engTree.search(v);
                if (traduction == null) {
                    traduced  = traduced + "*" + v + "* ";
                } else {
                    traduced = traduced + traduction + " ";
                }
            }
            System.out.println(traduced);
        }

        System.out.println("Proceso terminado");

        in.close();
    }
}

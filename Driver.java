import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        WordComparator comp = new WordComparator();
        Reader myReader = new Reader();
        ArrayList<String> file = new ArrayList<>();
        ArrayList<String> toTraduce = new ArrayList<>();
        String traducedWords = "";
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

        boolean a = true;

        while (a) {
            System.out.println("Ingrese el idioma del archivo que quiere traducir.");
            System.out.println("1. Inglés.");
            System.out.println("2. Francés.");
            System.out.println("Ingrese su selección.");
            int option = Integer.parseInt(in.nextLine());

            switch(option) {
                case 1:
                    traducedWords = traduce(toTraduce, engTree);
                    a = false;
                    break;
                case 2:
                    traducedWords = traduce(toTraduce, frnTree);
                    a = false;
                    break;
                default:
                    System.out.println("Ingrese un valor válido.");
                    break;
            }
        }

        System.out.println(traducedWords);

        System.out.println("Proceso terminado");

        in.close();
    }

    public static String traduce(ArrayList<String> gay, BinarySearchTree<String, String> homo) {
        String traduced = "";
        
        for (String w : gay) {
            String[] word = w.split(" ");
            for (String v : word) {
                String traduction = homo.search(v);
                if (traduction == null) {
                    traduced  = traduced + "*" + v + "* ";
                } else {
                    traduced = traduced + traduction + " ";
                }
            }
        }

        return traduced;
    }
}

import java.util.Comparator;

public class WordComparator implements Comparator<String> {

    @Override
    public int compare(String w1, String w2) {
        return w1.compareTo(w2);
    }
    
}

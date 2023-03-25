import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {
    
    public ArrayList<String> read(String path) throws Exception {
        ArrayList<String> content = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();

            while (line != null) {
                content.add(line);
                line = reader.readLine();
            }

            reader.close();

            return content;
        } catch (Exception e) {
            throw new Exception();
        }
    }
}

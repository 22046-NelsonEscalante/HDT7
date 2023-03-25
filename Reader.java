import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;

public class Reader {
    
    public ArrayList<String> read(String path) throws Exception {
        ArrayList<String> content = new ArrayList<>();
        Charset chars = Charset.forName("UTF-8");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path, chars));
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

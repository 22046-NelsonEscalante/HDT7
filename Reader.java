import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;

/**
 * @author 22046-NelsonEscalante
 */
public class Reader {
    
    /**
     * This method reads a file and saves all lines of text into an arraylist for subsequent use. Throws an exception when it cannot find the file.
     * @param path the path of the file to read.
     * @return an ArrayList with the file content.
     * @throws Exception an error for when it cannot find the file.
     */
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

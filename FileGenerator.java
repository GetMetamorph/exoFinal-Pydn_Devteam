import java.io.File;
import java.io.IOException;

public class FileGenerator {


    public static void generateFile(String filename) throws IOException {
        try {
            new File(filename + ".txt").createNewFile();
        } catch (IOException e) {
            System.out.println("Error generating" + filename + "file.");
            e.printStackTrace();
        }
    }





}

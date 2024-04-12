import java.io.File;
import java.io.IOException;

public class FileGenerator {


    public static void generateFile(String filename) throws IOException {
        try {
            // check if file exists, if so print a message
            if (new File(filename + ".txt").exists()) {
                System.out.println("Aborting, File already exists.");
                return;
            }
            // create a new file
            new File(filename + ".txt").createNewFile();
        } catch (IOException e) {
            System.out.println("Error generating" + filename + "file.");
            e.printStackTrace();
        }
    }





}

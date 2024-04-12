import java.io.*;
import java.util.List;

public class FileWriterCustom {
    public static void writeFile(List<String> lines, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String modifiedLine : lines) {
            writer.write(modifiedLine);
            writer.newLine();
        }
        writer.close();
    }
}

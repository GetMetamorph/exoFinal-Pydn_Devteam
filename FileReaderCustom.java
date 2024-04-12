import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderCustom {
    public static List<String> readFile(String taskToRemove, String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.contains(taskToRemove)) {
                lines.add(line);
            }
        }
        reader.close();
        return lines;
    }
}

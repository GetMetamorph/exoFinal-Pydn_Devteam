import java.io.*;
import java.util.*;

public class RemoveTask {
    public static void removeTask(String taskToRemove, String filename) throws IOException {
        List<String> lines = FileReaderCustom.readFile(taskToRemove, filename);
        FileWriterCustom.writeFile(lines, filename);
    }
}
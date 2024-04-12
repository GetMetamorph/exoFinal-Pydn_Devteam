import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskFileReader {
    private String filePath;

    public TaskFileReader(String filePath) {
        this.filePath = filePath;
    }

    public void displayTasksWithElapsedTime() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private void processLine(String line) {
        int lastParenthesisIndex = line.lastIndexOf('(');
        if (lastParenthesisIndex != -1) {
            String description = line.substring(0, lastParenthesisIndex).trim();
            String dateTimeStr = line.substring(lastParenthesisIndex + 1, line.length() - 1).trim();
            LocalDateTime creationDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String elapsedTime = TimeUtils.getElapsedTime(creationDateTime);
            System.out.println(description + " - " + elapsedTime + " ago");
        }
    }
}

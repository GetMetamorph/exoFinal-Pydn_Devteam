import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

class FileGeneratorTest {

    @org.junit.jupiter.api.Test
    void generateFile() {
        try {
            FileGenerator.generateFile("todo");
            File file = new File("todo.txt");
            assertTrue(file.exists());
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
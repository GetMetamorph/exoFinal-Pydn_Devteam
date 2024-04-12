import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class TodoListTest {
    TodoList todoList;

    @BeforeEach
    void setUp() {
        todoList = new TodoList();
    }

    @Test
    void addTask() {
        Task task = new Task("test");
        try {
            FileGenerator.generateFile("todo");
            File file = new File("todo.txt");
            todoList.addTask(task, file.getName());
            assertTrue(file.exists());
            String content = Files.readString(file.toPath());
            boolean sentenceFound = content.contains(task.getTaskText());
            assertTrue(sentenceFound);
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void shouldNotFailedAddTasksWhenTodoNotCreatedYet() {
        Task task = new Task("test");
        File file = new File("todo.txt");
        assertDoesNotThrow(() -> todoList.addTask(task, file.getName()));

    }
    @Test
    void listTasks() {
        try {
            FileGenerator.generateFile("todo");
            File file = new File("todo.txt");
            todoList.addTask(new Task("test"), file.getName());
            todoList.listTasks(file.getName());
            assertTrue(file.exists());
            assertEquals(1, todoList.taskList.size());
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     @Test
    void lisTasksEmpty(){
        try {
            FileGenerator.generateFile("todo");
            File file = new File("todo.txt");
            todoList.listTasks(file.getName());
            assertTrue(file.exists());
            assertEquals(0, todoList.taskList.size());
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
     }
}
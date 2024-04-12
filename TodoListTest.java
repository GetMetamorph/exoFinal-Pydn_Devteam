

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
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
    void markTaskHasDone() {
        Task task = new Task("test");
        try {
            FileGenerator.generateFile("todo");
            File file = new File("todo.txt");
            todoList.addTask(task, file.getName());
            todoList.markTaskHasDone(task, file.getName());
            assertTrue(file.exists());
            String content = Files.readString(file.toPath());
            boolean sentenceFound = content.contains("["+Status.DONE +"]"+ " " + task.getTaskText() +" (" + task.getTaskCreatedDate() + ")");
            assertTrue(sentenceFound);
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void shouldThrowExceptionWhenFileDoesNotExistWhenMarkingTaskHasDone() {
        Task task = new Task("test");
        File file = new File("todo.txt");
        assertThrows(FileNotFoundException.class,() -> todoList.markTaskHasDone(task, file.getName()));

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
    void removeTask() {
        Task task = new Task("test");
        try {
            FileGenerator.generateFile("todo");
            File file = new File("todo.txt");
            todoList.addTask(task, file.getName());
            RemoveTask.removeTask(task.getTaskText(), file.getName());
            assertFalse(Files.readString(file.toPath()).contains(task.getTaskText()));
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
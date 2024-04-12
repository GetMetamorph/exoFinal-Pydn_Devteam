import java.io.File;
import java.io.IOException;

public class Main {
    public static void readCommands(String[] args) throws IOException {
        String COMMAND = args[0];
        String FILENAME = args[1];

        TodoList todoList = new TodoList();

        Commands commandEnum = Commands.valueOf(COMMAND.toUpperCase());
        switch (commandEnum) {
            case ADD:
                System.out.println("Adding a new task");
                todoList.addTask(new Task(args[1]), args[2] );
                break;
            case LIST:
                System.out.println("Listing all tasks");
                todoList.listTasks(FILENAME);
                break;
            case EDIT:
                System.out.println("Editing a task");
                break;
            case CREATE:
                System.out.println("Creating a new Todo list");
                FileGenerator.generateFile(FILENAME);
                break;
            case DELETE:
                System.out.println("Deleting a task");
                break;
            default:
                System.out.println("Invalid command");
        }
    }

    public static void main(String[] args) {
        try {
            readCommands(args);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

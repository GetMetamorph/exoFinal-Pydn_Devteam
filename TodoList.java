    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;

    public class TodoList {

        List<Task> taskList = new ArrayList<Task>();

        public void addTask(Task task, String filename) throws IOException {
            taskList.add(task);
            for (Task t : taskList) {
                appendFile(filename, t);
            }
        }

        private void appendFile(String filename, Task task) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                writer.write(task.toString());
                writer.newLine();
            }
        }

    }

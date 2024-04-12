    import java.io.BufferedWriter;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;

    public class TodoList {

        List<Task> taskList = new ArrayList<Task>();
        private String filename;

        public void addTask(Task task, String filename) throws IOException {
            taskList.add(task);
            for (Task t : taskList) {
                appendTaskToFile(filename, t);
            }
        }

        private void appendTaskToFile(String filename, Task task) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filename, true))) {
                writer.write(task.toString());
                writer.newLine();
            }
        }

        public void listTasks(String filename) throws IOException {
            TaskFileReader reader = new TaskFileReader(filename);
            reader.displayTasksWithElapsedTime();
        }

    }

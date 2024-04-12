    import java.io.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class TodoList {

        List<Task> taskList = new ArrayList<>();
        private String filename;

        public void addTask(Task task, String filename) throws IOException {
            taskList.add(task);
            for (Task t : taskList) {
                appendTaskToFile(filename, t);
            }
        }

        private void appendTaskToFile(String filename, Task task) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                writer.write(task.toString());
                writer.newLine();
            }
        }

        public void listTasks(String filename) throws IOException {
            TaskFileReader reader = new TaskFileReader(filename);
            reader.displayTasksWithElapsedTime();
        }
        public void markTaskHasDone(Task task, String filename) throws IOException {
            File todoToBeModified= new File(filename);
            StringBuilder oldContent = new StringBuilder();
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(todoToBeModified))){
                while((line =reader.readLine())!=null){
                    oldContent.append(line).append(System.lineSeparator());
                }
            }

            Pattern pattern = Pattern.compile("\\[(TODO|DONE)\\]\\s+" + task.getTaskText() + "\\s*\\(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d+\\)");
            Matcher matcher = pattern.matcher(oldContent.toString());


            String newContent = matcher.replaceAll("["+Status.DONE +"]"+ " " + task.getTaskText() +" (" + task.getTaskCreatedDate() + ")");


            BufferedWriter writer = new BufferedWriter(new FileWriter(todoToBeModified));
            writer.write(newContent);
            writer.close();
        }

    }

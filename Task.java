public class Task {

    private String taskText;

    private Status status;
    private String taskCreatedDate;

    public Task(String taskText) {
        this.taskText = taskText;
        this.taskCreatedDate = java.time.LocalDate.now().toString();
        this.status = Status.TODO; // Default is To do when created
    }

    public String getTaskText() {
        return taskText;
    }

    public String getTaskCreatedDate() {
        return taskCreatedDate;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public void setTaskCreatedDate(String taskCreatedDate) {
        this.taskCreatedDate = taskCreatedDate;
    }

    public String toString() {
        return "Task: " + taskText + " Created on: " + taskCreatedDate;
    }


}

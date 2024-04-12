import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {

    private String taskText;

    private Status status;
    private LocalDateTime taskCreatedDate;

    public Task(String taskText) {
        this.taskText = taskText;
        this.taskCreatedDate = java.time.LocalDateTime.now();
        this.status = Status.TODO; // Default is To do when created
    }

    public String getTaskText() {
        return taskText;
    }

    public LocalDateTime getTaskCreatedDate() {
        return taskCreatedDate;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public void setTaskCreatedDate(LocalDateTime taskCreatedDate) {
        this.taskCreatedDate = taskCreatedDate;
    }

    public String toString() {
        return  "[" + status +"] " + taskText + " (" + taskCreatedDate + ")";
    }



}

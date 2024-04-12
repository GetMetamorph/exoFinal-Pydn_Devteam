public class Task {

    private String taskText;
    private String taskCreatedDate;

    public Task(String taskText, String taskCreatedDate) {
        this.taskText = taskText;
        this.taskCreatedDate = taskCreatedDate;
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

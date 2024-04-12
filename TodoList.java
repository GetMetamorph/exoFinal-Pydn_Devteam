import java.util.ArrayList;
import java.util.List;

public class TodoList {

    List<Task> taskList = new ArrayList<Task>();

    public void addTask(Task task) {
        taskList.add(task);
    }


}

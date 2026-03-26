import java.util.ArrayList;
import java.util.List;

/**
 * Composite component representing a group of logs.
 */
public class LogGroup implements LogComponent {

    private String name;
    private List<LogComponent> components = new ArrayList<>();

    public LogGroup(String name) {
        this.name = name;
    }

    public void add(LogComponent component) {
        components.add(component);
    }

    public void remove(LogComponent component) {
        components.remove(component);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "[" + name + "]");

        for (LogComponent c : components) {
            c.display(indent + "  ");
        }
    }

    @Override
    public List<Log> getLogs() {
        List<Log> allLogs = new ArrayList<>();

        for (LogComponent c : components) {
            allLogs.addAll(c.getLogs());
        }

        return allLogs;
    }
}
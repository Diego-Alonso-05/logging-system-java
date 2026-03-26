
/**
 * Service responsible for logging operations
 * Delegates the storage of logs to a configurable
 * LogDestination, allowing dynamic behavior changes
 */




public class LogService {

    private LogDestination destination;
    private String currentDestinationType;

    public LogService(LogDestination destination) {
        this.destination = destination;
    }

    public void setDestination(LogDestination destination) {
        this.destination = destination;
    }
    //Destination is the way the log will be stored and has its own save function that handles
    //the log
    public void log(LogComponent component) {
        for (Log log : component.getLogs()) {
            destination.save(log);
        }
    }


    public LogMemento saveState() {
        return new LogMemento(
                ConfigManager.INSTANCE.getConfig(),
                currentDestinationType
        );
    }

    public void restoreState(LogMemento memento) {
        ConfigManager.INSTANCE.setConfig(memento.getConfig());
        this.destination = LogDestinationFactory.getDestination(memento.getDestinationType());
    }
}
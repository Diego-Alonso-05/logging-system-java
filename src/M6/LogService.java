package M6;

import M0.Log;
import M1.ConfigManager;
import M3.LogDestination;
import M4.LogComponent;
import M4.LogGroup;
import M5.LogDestinationFactory;
import M7.AlertLogDecorator;

/**
 * Service responsible for logging operations.
 * Delegates the storage of logs to a configurable
 * LogDestination, allowing dynamic behavior changes.
 */

public class LogService {

    private LogDestination destination;
    private String currentDestinationType;

    // 🌳 ROOT del árbol de logs
    private LogGroup root;

    public LogService(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Destination type cannot be null or empty");
        }

        this.currentDestinationType = type;
        this.destination = LogDestinationFactory.getDestination(type);

        // Inicializamos el árbol
        this.root = new LogGroup("ROOT");
    }

    public void setDestination(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Destination type cannot be null or empty");
        }

        this.currentDestinationType = type;
        this.destination = LogDestinationFactory.getDestination(type);
    }

    /**
     * Adds an alert decorator on top of the current destination.
     */
    public void addAlertDecorator() {
        this.destination = new AlertLogDecorator(this.destination);
    }

    /**
     * Añade un log o grupo al árbol (NO lo guarda aún).
     */
    public void addToTree(LogComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("LogComponent cannot be null");
        }

        root.add(component);
    }

    /**
     * Guarda todos los logs del árbol en el destino actual.
     */
    public void saveAll() {
        for (Log log : root.getLogs()) {
            destination.save(log);
        }
    }

    /**
     * Muestra el árbol completo de logs.
     */
    public void showTree() {
        root.display("");
    }

    /**
     * Limpiar el árbol.
     */
    public void clearTree() {
        this.root = new LogGroup("ROOT");
    }

    /**
     * Logs directos (sin usar árbol).
     */
    public void log(LogComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("LogComponent cannot be null");
        }

        for (Log log : component.getLogs()) {
            destination.save(log);
        }
    }

    /**
     * Saves current state (Memento pattern).
     */
    public LogMemento saveState() {
        return new LogMemento(
                ConfigManager.INSTANCE.getConfig(),
                currentDestinationType,
                root   // 🔥 CLAVE: guardar árbol
        );
    }

    /**
     * Restores a previously saved state.
     */
    public void restoreState(LogMemento memento) {
        if (memento == null) {
            throw new IllegalArgumentException("Memento cannot be null");
        }

        // Restaurar configuración
        ConfigManager.INSTANCE.setConfig(memento.getConfig());

        String type = memento.getDestinationType();

        if (type == null || type.isEmpty()) {
            throw new IllegalStateException("Saved destination type is null or empty");
        }

        // Restaurar destino
        this.currentDestinationType = type;
        this.destination = LogDestinationFactory.getDestination(type);

        // 🔥 CLAVE: restaurar árbol
        this.root = memento.getRoot();
    }

    public String getCurrentDestinationType() {
        return currentDestinationType;
    }
}
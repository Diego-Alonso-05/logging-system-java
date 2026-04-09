package M5;

import java.util.HashMap;
import java.util.Map;

import M3.LogDestination;

/**
 * Factory that manages and reuses LogDestination instances.
 * Now delegates creation to specific factories (Factory Method pattern)
 */
public class LogDestinationFactory {

    private static final Map<String, LogDestination> cache = new HashMap<>();

    public static LogDestination getDestination(String type) {

        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Destination type cannot be null or empty");
        }

        if (!cache.containsKey(type)) {

            DestinationFactory factory;

            switch (type) {
                case "FILE":
                    factory = FileDestinationFactory.getInstance();
                    break;
                case "DB":
                    factory = DatabaseDestinationFactory.getInstance();
                    break;
                case "CONSOLE":
                    factory = ConsoleDestinationFactory.getInstance();
                    break;
                case "AZURE":
                    factory = AzureDestinationFactory.getInstance();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid destination");
            }

            cache.put(type, factory.createDestination());
        }

        return cache.get(type);
    }
}
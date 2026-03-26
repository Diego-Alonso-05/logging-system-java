package M5;

import java.util.HashMap;
import java.util.Map;

import M3.AzureLogDestination;
import M3.ConsoleLogDestination;
import M3.DatabaseLogDestination;
import M3.FileLogDestination;
import M3.LogDestination;

/**
 * Factory that manages and reuses LogDestination instances.
 * Implements a caching mechanism to avoid creating
 * multiple instances of the same destination
 */


public class LogDestinationFactory {

    private static final Map<String, LogDestination> cache = new HashMap<>();

    public static LogDestination getDestination(String type) {

        if (!cache.containsKey(type)) {

            switch (type) {
                case "FILE":
                    cache.put(type, new FileLogDestination());
                    break;
                case "DB":
                    cache.put(type, new DatabaseLogDestination());
                    break;
                case "CONSOLE":
                    cache.put(type, new ConsoleLogDestination());
                    break;
                case "AZURE":
                    cache.put(type, new AzureLogDestination());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid destination");
            }
        }

        return cache.get(type);
    }
}
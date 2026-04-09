package M5;

import M3.ConsoleLogDestination;
import M3.LogDestination;

public class ConsoleDestinationFactory extends DestinationFactory {

    private static ConsoleDestinationFactory instance;

    private ConsoleDestinationFactory() {}

    public static ConsoleDestinationFactory getInstance() {
        if (instance == null) {
            instance = new ConsoleDestinationFactory();
        }
        return instance;
    }

    @Override
    public LogDestination createDestination() {
        return new ConsoleLogDestination();
    }
}
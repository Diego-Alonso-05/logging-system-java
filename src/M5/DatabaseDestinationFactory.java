package M5;

import M3.DatabaseLogDestination;
import M3.LogDestination;

public class DatabaseDestinationFactory extends DestinationFactory {

    private static DatabaseDestinationFactory instance;

    private DatabaseDestinationFactory() {}

    public static DatabaseDestinationFactory getInstance() {
        if (instance == null) {
            instance = new DatabaseDestinationFactory();
        }
        return instance;
    }

    @Override
    public LogDestination createDestination() {
        return new DatabaseLogDestination();
    }
}
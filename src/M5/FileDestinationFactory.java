package M5;

import M3.FileLogDestination;
import M3.LogDestination;

public class FileDestinationFactory extends DestinationFactory {

    private static FileDestinationFactory instance;

    private FileDestinationFactory() {}

    public static FileDestinationFactory getInstance() {
        if (instance == null) {
            instance = new FileDestinationFactory();
        }
        return instance;
    }

    @Override
    public LogDestination createDestination() {
        return new FileLogDestination();
    }
}
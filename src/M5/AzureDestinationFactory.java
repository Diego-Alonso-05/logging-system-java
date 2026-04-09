package M5;

import M3.AzureLogDestination;
import M3.LogDestination;

public class AzureDestinationFactory extends DestinationFactory {

    private static AzureDestinationFactory instance;

    private AzureDestinationFactory() {}

    public static AzureDestinationFactory getInstance() {
        if (instance == null) {
            instance = new AzureDestinationFactory();
        }
        return instance;
    }

    @Override
    public LogDestination createDestination() {
        return new AzureLogDestination();
    }
}
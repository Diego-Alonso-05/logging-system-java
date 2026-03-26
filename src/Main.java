import M0.Log;
import M0.LogLevel;
import M2.LogFactory;
import M3.LogDestination;
import M4.LogGroup;
import M4.LogLeaf;
import M5.LogDestinationFactory;
import M6.LogMemento;
import M6.LogService;
import M7.AlertLogDecorator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Estado inicial
        String currentDestination = "CONSOLE";

        LogDestination destination =
                LogDestinationFactory.getDestination(currentDestination);

        LogService service = new LogService(destination);

        LogMemento savedState = null;

        while (true) {
            try
            {

            

                System.out.println("\n===== LOG SYSTEM MENU =====");
                System.out.println("1. Change destination");
                System.out.println("2. Add alert decorator");
                System.out.println("3. Create log");
                System.out.println("4. Create grouped logs");
                System.out.println("5. Save state");
                System.out.println("6. Restore state");
                System.out.println("0. Exit");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {

                    case 1:
                        System.out.println("Select destination: CONSOLE / FILE / DB / AZURE");
                        currentDestination = scanner.nextLine().toUpperCase();

                        destination = LogDestinationFactory.getDestination(currentDestination);
                        service.setDestination(destination);

                        System.out.println("Destination changed.");
                        break;

                    case 2:
                        destination = new AlertLogDecorator(
                                LogDestinationFactory.getDestination(currentDestination)
                        );
                        service.setDestination(destination);

                        System.out.println("Alert decorator added.");
                        break;

                    case 3:
                        System.out.println("Log type: INFO / WARNING / ERROR / DEBUG");
                        String type = scanner.nextLine().toUpperCase();

                        System.out.println("Message:");
                        String msg = scanner.nextLine();

                        Log log = LogFactory.createLog(LogLevel.valueOf(type), msg);

                        service.log(new LogLeaf(log));
                        break;

                    case 4:
                        System.out.println("Creating grouped logs...");

                        Log log1 = LogFactory.createLog(LogLevel.INFO, "User login");
                        Log log2 = LogFactory.createLog(LogLevel.ERROR, "DB failure");

                        LogLeaf leaf1 = new LogLeaf(log1);
                        LogLeaf leaf2 = new LogLeaf(log2);

                        LogGroup group = new LogGroup("System");
                        group.add(leaf1);
                        group.add(leaf2);

                        service.log(group);
                        break;

                    case 5:
                        savedState = service.saveState();
                        System.out.println("State saved.");
                        break;

                    case 6:
                        if (savedState != null) {
                            service.restoreState(savedState);
                            System.out.println("State restored.");
                        } else {
                            System.out.println("No state saved.");
                        }
                        break;

                    case 0:
                        System.out.println("Bye!");
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
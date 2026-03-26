import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LogService service = new LogService("CONSOLE");
        LogMemento savedState = null;

        while (true) {

            System.out.println("\n===== LOG SYSTEM MENU =====");
            System.out.println("1. Change destination");
            System.out.println("2. Add alert decorator");
            System.out.println("3. Create log (add to tree)");
            System.out.println("4. Create group of logs");
            System.out.println("5. Show log tree");
            System.out.println("6. Save all logs");
            System.out.println("7. Clear log tree");
            System.out.println("8. Save state");
            System.out.println("9. Restore state");
            System.out.println("0. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    System.out.println("Select destination: CONSOLE / FILE / DB / AZURE");
                    String dest = scanner.nextLine().toUpperCase();

                    try {
                        service.setDestination(dest);
                        System.out.println("Destination changed to " + dest);
                    } catch (Exception e) {
                        System.out.println("Invalid destination.");
                    }
                    break;

                case 2:
                    service.addAlertDecorator();
                    System.out.println("Alert decorator added.");
                    break;

                case 3:
                    System.out.println("Log type: INFO / WARNING / ERROR / DEBUG");
                    String type = scanner.nextLine().toUpperCase();

                    System.out.println("Message:");
                    String msg = scanner.nextLine();

                    try {
                        Log log = LogFactory.createLog(LogLevel.valueOf(type), msg);
                        service.addToTree(new LogLeaf(log));
                        System.out.println("Log added to tree.");
                    } catch (Exception e) {
                        System.out.println("Invalid log type.");
                    }
                    break;

                case 4:
                    System.out.println("Group name:");
                    String groupName = scanner.nextLine();

                    LogGroup group = new LogGroup(groupName);

                    System.out.println("How many logs?");
                    int n = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.println("Log " + (i + 1) + " type:");
                        String t = scanner.nextLine().toUpperCase();

                        System.out.println("Message:");
                        String m = scanner.nextLine();

                        try {
                            Log log = LogFactory.createLog(LogLevel.valueOf(t), m);
                            group.add(new LogLeaf(log));
                        } catch (Exception e) {
                            System.out.println("Invalid log type, skipped.");
                        }
                    }

                    service.addToTree(group);
                    System.out.println("Group added to tree.");
                    break;

                case 5:
                    System.out.println("\n--- LOG TREE ---");
                    service.showTree();
                    break;

                case 6:
                    service.saveAll();
                    System.out.println("All logs saved to " + service.getCurrentDestinationType());
                    break;

                case 7:
                    service.clearTree();
                    System.out.println("Log tree cleared.");
                    break;

                case 8:
                    savedState = service.saveState();
                    System.out.println("State saved.");
                    break;

                case 9:
                    if (savedState != null) {
                        try {
                            service.restoreState(savedState);
                            System.out.println("State restored.");
                        } catch (Exception e) {
                            System.out.println("Error restoring state.");
                        }
                    } else {
                        System.out.println("No state saved.");
                    }
                    break;

                case 0:
                    System.out.println("Terminated");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
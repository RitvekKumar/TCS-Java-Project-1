import java.util.InputMismatchException;
import java.util.Scanner;

public class StarProtectVehicleSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        Admin admin = new Admin();

        while (!exit) {
            try {
                System.out.println("Welcome to Star Protect Vehicle System");
                System.out.println("Select your role:");
                System.out.println("1. Admin");
                System.out.println("2. UnderWriter");
                System.out.println("3. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        admin.login();
                        break;
                    case 2:
                        if(admin.underWriters.size() > 0) {
                            System.out.println("Enter UnderWriter ID:");
                            int userId = scanner.nextInt();
                            UnderWriter underWriter = admin.findUnderWriterById(userId);
                            underWriter.login();
                        }
                        else {
                            System.out.println("no underwriter registered!");
                        }
                        break;
                    case 3:
                        exit = true;
                        System.out.println("Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear the invalid input
            }
        }

        scanner.close();
    }
}

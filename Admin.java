import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private static final String DEFAULT_USER_ID = "admin";
    private static final String DEFAULT_PASSWORD = "admin123";
    List<UnderWriter> underWriters = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void login() {
        System.out.println("Enter Admin User ID:");
        String userId = scanner.next();
        System.out.println("Enter Admin Password:");
        String password = scanner.next();

        if (userId.equals(DEFAULT_USER_ID) && password.equals(DEFAULT_PASSWORD)) {
            System.out.println("Admin logged in successfully.");
            adminMenu();
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }

    private void adminMenu() {
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("Admin Menu:");
                System.out.println("1. Register UnderWriter");
                System.out.println("2. Search UnderWriter by ID");
                System.out.println("3. Update UnderWriter Password");
                System.out.println("4. Delete UnderWriter by ID");
                System.out.println("5. View All UnderWriters");
                System.out.println("6. View All Vehicles specific to UnderWriter ID");
                System.out.println("7. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        registerUnderWriter();
                        break;
                    case 2:
                        searchUnderWriterById();
                        break;
                    case 3:
                        updateUnderWriterPassword();
                        break;
                    case 4:
                        deleteUnderWriterById();
                        break;
                    case 5:
                        viewAllUnderWriters();
                        break;
                    case 6:
                        viewAllVehiclesByUnderWriterId();
                        break;
                    case 7:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear the invalid input
            }
        }
    }

    private void registerUnderWriter() {
        try {
            System.out.println("Enter UnderWriter Name:");
            String name = scanner.next();
            System.out.println("Enter UnderWriter DOB (yyyy-mm-dd):");
            String dob = scanner.next();
            System.out.println("Enter UnderWriter Joining Date (yyyy-mm-dd):");
            String joiningDate = scanner.next();
            System.out.println("Enter UnderWriter Default Password:");
            String defaultPassword = scanner.next();

            int underWriterId = underWriters.size() + 1;
            UnderWriter underWriter = new UnderWriter(underWriterId, name, dob, joiningDate, defaultPassword);
            underWriters.add(underWriter);
            System.out.println("UnderWriter registered successfully with ID: " + underWriterId);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next(); // clear the invalid input
        }
    }

    private void searchUnderWriterById() {
        try {
            System.out.println("Enter UnderWriter ID:");
            int id = scanner.nextInt();

            UnderWriter underWriter = findUnderWriterById(id);
            if (underWriter != null) {
                System.out.println(underWriter);
            } else {
                System.out.println("Invalid UnderWriter ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
    }

    private void updateUnderWriterPassword() {
        try {
            System.out.println("Enter UnderWriter ID:");
            int id = scanner.nextInt();

            UnderWriter underWriter = findUnderWriterById(id);
            if (underWriter != null) {
                System.out.println("Enter New Password:");
                String newPassword = scanner.next();
                underWriter.setPassword(newPassword);
                System.out.println("Password updated successfully.");
            } else {
                System.out.println("Invalid UnderWriter ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
    }

    private void deleteUnderWriterById() {
        try {
            System.out.println("Enter UnderWriter ID:");
            int id = scanner.nextInt();

            UnderWriter underWriter = findUnderWriterById(id);
            if (underWriter != null) {
                underWriters.remove(underWriter);
                System.out.println("UnderWriter deleted successfully.");
            } else {
                System.out.println("Invalid UnderWriter ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
    }

    private void viewAllUnderWriters() {
        if (underWriters.isEmpty()) {
            System.out.println("No UnderWriters registered.");
        } else {
            for (UnderWriter underWriter : underWriters) {
                System.out.println(underWriter);
            }
        }
    }

    private void viewAllVehiclesByUnderWriterId() {
        try {
            System.out.println("Enter UnderWriter ID:");
            int id = scanner.nextInt();

            UnderWriter underWriter = findUnderWriterById(id);
            if (underWriter != null) {
                underWriter.viewAllVehicles();
            } else {
                System.out.println("Invalid UnderWriter ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
    }

    UnderWriter findUnderWriterById(int id) {
        for (UnderWriter underWriter : underWriters) {
            if (underWriter.getId() == id) {
                return underWriter;
            }
        }
        return null;
    }
}

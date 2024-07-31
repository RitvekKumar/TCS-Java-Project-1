import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UnderWriter {
    private int id;
    private String name;
    private String dob;
    private String joiningDate;
    private String password;
    private List<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public UnderWriter() {
    }

    public UnderWriter(int id, String name, String dob, String joiningDate, String password) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.joiningDate = joiningDate;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        try {
            System.out.println("Enter Password:");
            String userPassword = scanner.next();

            if (validateCredentials(userPassword)) {
                System.out.println("UnderWriter logged in successfully.");
                underWriterMenu();
            } else {
                System.out.println("Invalid credentials. Access denied.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
    }

    private boolean validateCredentials(String userPassword) {
        return this.password.equals(userPassword);
    }

    private void underWriterMenu() {
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("UnderWriter Menu:");
                System.out.println("1. Create a new Vehicle Insurance");
                System.out.println("2. Renewal of a Policy");
                System.out.println("3. Changing of a Policy");
                System.out.println("4. View Policy");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        createNewVehicleInsurance();
                        break;
                    case 2:
                        renewPolicy();
                        break;
                    case 3:
                        changePolicy();
                        break;
                    case 4:
                        viewPolicy();
                        break;
                    case 5:
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

    private void createNewVehicleInsurance() {
        try {
            System.out.println("Enter Vehicle Number:");
            String vehicleNo = scanner.next();
            System.out.println("Enter Vehicle Type:");
            String vehicleType = scanner.next();
            System.out.println("Enter Customer Name:");
            String customerName = scanner.next();
            System.out.println("Enter Engine Number:");
            int engineNo = scanner.nextInt();
            System.out.println("Enter Chassis Number:");
            int chassisNo = scanner.nextInt();
            System.out.println("Enter Phone Number:");
            long phoneNo = scanner.nextLong();
            System.out.println("Enter Insurance Type (Full/ThirdParty):");
            String insuranceType = scanner.next();
            System.out.println("Enter Premium Amount:");
            double premiumAmt = scanner.nextDouble();
            String fromDate = "2023-07-31";
            String toDate = "2024-07-30";

            int policyNo = vehicles.size() + 1;
            Vehicle vehicle = new Vehicle(policyNo, vehicleNo, vehicleType, customerName, engineNo, chassisNo, phoneNo, insuranceType,
                    premiumAmt, fromDate, toDate, this.id);
            vehicles.add(vehicle);
            System.out.println("Vehicle insurance created successfully with Policy Number: " + policyNo);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next(); // clear the invalid input
        }
    }

    private void renewPolicy() {
        try {
            System.out.println("Enter Policy Number:");
            int policyNo = scanner.nextInt();

            Vehicle vehicle = findVehicleByPolicyNo(policyNo);
            if (vehicle != null) {
                System.out.println("Renewing policy for Vehicle: " + vehicle.getVehicleNo());
                System.out.println("Enter new Premium Amount:");
                double newPremiumAmt = scanner.nextDouble();
                String newFromDate = "2024-07-31";
                String newToDate = "2025-07-30";

                Vehicle newVehicle = new Vehicle(vehicle.getPolicyNo(), vehicle.getVehicleNo(), vehicle.getVehicleType(), vehicle.getCustomerName(),
                        vehicle.getEngineNo(), vehicle.getChassisNo(), vehicle.getPhoneNo(), vehicle.getInsuranceType(), newPremiumAmt,
                        newFromDate, newToDate, this.id);

                vehicles.remove(vehicle);
                vehicles.add(newVehicle);
                System.out.println("Policy renewed successfully.");
            } else {
                System.out.println("Invalid Policy Number.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
    }

    private void changePolicy() {
        try {
            System.out.println("Enter Policy Number:");
            int policyNo = scanner.nextInt();

            Vehicle vehicle = findVehicleByPolicyNo(policyNo);
            if (vehicle != null) {
                if (vehicle.getInsuranceType().equalsIgnoreCase("ThirdParty")) {
                    System.out.println("There's no provision to update the policy type from Third party to full Insurance.");
                } else if (vehicle.getInsuranceType().equalsIgnoreCase("Full")) {
                    System.out.println("Press U to update the insurance type from full insurance to third party:");
                    String choice = scanner.next();
                    if (choice.equalsIgnoreCase("U")) {
                        vehicle.setInsuranceType("ThirdParty");
                        System.out.println("Insurance type updated successfully.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                }
            } else {
                System.out.println("Invalid Policy Number.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
    }

    private void viewPolicy() {
        try {
            System.out.println("View Policy Menu:");
            System.out.println("1. View All Insurance");
            System.out.println("2. View Insurance by Vehicle ID");
            System.out.println("3. View Insurance by Policy ID");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllInsurance();
                    break;
                case 2:
                    viewInsuranceByVehicleId();
                    break;
                case 3:
                    viewInsuranceByPolicyId();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
    }

    private void viewAllInsurance() {
        if (vehicles.isEmpty()) {
            System.out.println("No Vehicle Insurance records found.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    private void viewInsuranceByVehicleId() {
        try {
            System.out.println("Enter Vehicle ID:");
            String vehicleId = scanner.next();

            boolean found = false;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getVehicleNo().equalsIgnoreCase(vehicleId)) {
                    System.out.println(vehicle);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Invalid Vehicle ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.next(); // clear the invalid input
        }
    }

    private void viewInsuranceByPolicyId() {
        try {
            System.out.println("Enter Policy ID:");
            int policyId = scanner.nextInt();

            Vehicle vehicle = findVehicleByPolicyNo(policyId);
            if (vehicle != null) {
                System.out.println(vehicle);
            } else {
                System.out.println("Invalid Policy ID.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
    }

    private Vehicle findVehicleByPolicyNo(int policyNo) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPolicyNo() == policyNo) {
                return vehicle;
            }
        }
        return null;
    }

    public void viewAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles registered.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    @Override
    public String toString() {
        return "UnderWriter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", joiningDate='" + joiningDate + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

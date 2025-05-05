import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null;

        ArrayList<Package> packages = new ArrayList<>();
        packages.add(new Package(1, "Paris Getaway", "A romantic trip to Paris with guided tours", 999.99));
        packages.add(new Package(2, "Tropical Hawaii", "Relax on the sunny beaches of Hawaii", 1299.99));
        packages.add(new Package(3, "Alaskan Adventure", "Explore the wilderness of Alaska", 1599.99));
        packages.add(new Package(4, "Tokyo Experience", "Discover the vibrant culture of Tokyo", 1199.99));
        packages.add(new Package(5, "Australian Outback", "Experience the vast landscapes of Australia", 1399.99));

        while (true) {
            System.out.println("\n--- Welcome to Wonderlust ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Packages");
            System.out.println("4. Book a Package");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    User.register(username, password);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    loggedInUser = User.login(username, password);
                    break;

                case 3:
                    System.out.println("\n--- Available Packages ---");
                    for (Package pkg : packages) {
                        pkg.displayPackage();
                    }
                    break;

                case 4:
                    if (loggedInUser == null || !loggedInUser.isRegistered()) {
                        System.out.println("Please login as a registered user to book a package.");
                    } else {
                        System.out.print("Enter Package ID to book: ");
                        int packageId = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        Package selectedPackage = null;
                        for (Package pkg : packages) {
                            if (pkg.getId() == packageId) {
                                selectedPackage = pkg;
                                break;
                            }
                        }
                        if (selectedPackage != null) {
                            Booking.bookPackage(loggedInUser, selectedPackage);
                        } else {
                            System.out.println("Invalid Package ID.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Wonderlust!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

import java.util.*;

public class InternshipTracker {
    private static List<Internship> internships = DataManager.load();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nINTERNSHIP TRACKER");
            System.out.println("1. Add Internship");
            System.out.println("2. View All");
            System.out.println("3. Delete Internship");
            System.out.println("4. Save & Exit");
            System.out.print("Choose an option: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1 -> addInternship();
                case 2 -> viewInternships();
                case 3 -> deleteInternship();
                case 4 -> {
                    DataManager.save(internships);
                    System.out.println("Data saved. Goodbye!");
                }
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    private static void addInternship() {
        System.out.print("Company: ");
        String company = input.nextLine();
        System.out.print("Position: ");
        String position = input.nextLine();
        System.out.print("Status (Applied/Interviewed/etc): ");
        String status = input.nextLine();
        System.out.print("Deadline (YYYY-MM-DD): ");
        String deadline = input.nextLine();
        System.out.print("Notes: ");
        String notes = input.nextLine();

        internships.add(new Internship(company, position, status, deadline, notes));
        System.out.println("Internship added.");
    }

    private static void viewInternships() {
        if (internships.isEmpty()) {
            System.out.println("No internships found.");
            return;
        }
        for (int i = 0; i < internships.size(); i++) {
            System.out.println("[" + i + "]\n" + internships.get(i));
        }
    }

    private static void deleteInternship() {
        viewInternships();
        System.out.print("Enter index to delete: ");
        int index = Integer.parseInt(input.nextLine());
        if (index >= 0 && index < internships.size()) {
            internships.remove(index);
            System.out.println("Internship removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagement {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String[]> books = new ArrayList<>();
    static ArrayList<String[]> members = new ArrayList<>();

    // Common function to add a book or a member
    static void addEntry(ArrayList<String[]> list, String type, String... fields) {
        String[] entry = new String[fields.length];

        for (int i = 0; i < fields.length; i++) {
            System.out.print("Enter " + fields[i] + ": ");
            entry[i] = scanner.nextLine().toUpperCase();
        }

        System.out.println("Adding " + type + "...");
        list.add(entry);
        waitForEffect();
        System.out.println();
        System.out.println(type + " added successfully.");
        System.out.println("********************************************");
    }

    // Common function to remove a book or a member
    static void removeEntry(ArrayList<String[]> list, String type) {
        System.out.print("Enter " + type + " ID to remove: ");
        String id = scanner.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0].equals(id)) {
                System.out.println("Removing " + type + "...");
                printEntry(list.get(i));

                list.remove(i);
                waitForEffect();
                System.out.println();
                System.out.println(type + " removed successfully.");
                System.out.println("********************************************");
                return;
            }
        }
        System.out.println(type + " with ID " + id + " not found.");
    }

    // Common function to update a book or a member
    static void updateEntry(ArrayList<String[]> list, String type, String... fields) {
        System.out.print("Enter " + type + " ID to update: ");
        String id = scanner.nextLine();

        for (String[] entry : list) {
            if (entry[0].equals(id)) {
                for (int i = 1; i < fields.length; i++) {
                    System.out.print("Enter new " + fields[i] + ": ");
                    entry[i] = scanner.nextLine().toUpperCase();
                }

                waitForEffect();
                System.out.println();
                System.out.println(type + " updated successfully.");
                System.out.println("********************************************");
                return;
            }
        }
        System.out.println(type + " with ID " + id + " not found.");
    }

    // Common function to list books or members
    static void listEntries(ArrayList<String[]> list, String type, String... fields) {
        if (list.isEmpty()) {
            System.out.println("No " + type.toLowerCase() + "s available.");
        } else {
            System.out.println("List of " + type + "s:");
            for(int i = 0; i < list.size(); i++) {
                System.out.print((i + 1) + ". ");
                printEntry(list.get(i));
            }
            System.out.println("********************************************");
        }
    }

    // Helper function to print book/member details
    static void printEntry(String[] entry) {
        for (String field : entry) {
            System.out.print(field + "  ");
        }
        System.out.println();
    }

    // Function to simulate delay effect
    static void waitForEffect() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Unexpected interruption!");
        }
    }

    // Helper function to sort entries by ID using Bubble Sort
    static void sortEntries(ArrayList<String[]> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j)[0].compareTo(list.get(j + 1)[0]) > 0) {
                    // Swap the entries
                    String[] temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // Display menu
    static void displayMenu() {
        System.out.println("\n********************************************");
        System.out.println("         Library Management System          ");
        System.out.println("********************************************");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Update Book");
        System.out.println("4. List Books");
        System.out.println("5. Add Member");
        System.out.println("6. Remove Member");
        System.out.println("7. Update Member");
        System.out.println("8. List Members");
        System.out.println("9. Exit");
        System.out.println("********************************************");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                switch (choice) {
                    case 1:
                        addEntry(books, "Book", "Book ID", "Title", "Author");
                        sortEntries(books);
                        break;
                    case 2:
                        removeEntry(books, "Book");
                        break;
                    case 3:
                        updateEntry(books, "Book", "Book ID", "Title", "Author");
                        break;
                    case 4:
                        listEntries(books, "Book", "ID", "Title", "Author");
                        break;
                    case 5:
                        addEntry(members, "Member", "Member ID", "Name");
                        sortEntries(books);
                        break;
                    case 6:
                        removeEntry(members, "Member");
                        break;
                    case 7:
                        updateEntry(members, "Member", "Member ID", "Name");
                        break;
                    case 8:
                        listEntries(members, "Member", "ID", "Name");
                        break;
                    case 9:
                        exit = true;
                        System.out.println("********************************************");
                        System.out.println("Thank YOU!!");
                        System.out.println("********************************************");
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Please enter a valid number.");
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }
}

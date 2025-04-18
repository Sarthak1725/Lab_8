

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentOperations ops = new StudentOperations();
        int choice;

        do {
            System.out.println("\n1. Add Student\n2. Display All\n3. Search by PRN\n4. Delete\n5. Update\n6. Exit");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter PRN: ");
                        int prn = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Batch: ");
                        String batch = sc.nextLine();
                        ops.addStudent(name, prn, batch);
                        break;
                    case 2:
                        ops.displayStudents();
                        break;
                    case 3:
                        System.out.print("Enter PRN to search: ");
                        ops.searchStudent(sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Enter PRN to delete: ");
                        ops.deleteStudent(sc.nextInt());
                        break;
                    case 5:
                        System.out.print("Enter PRN to update: ");
                        int uprn = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new batch: ");
                        String newBatch = sc.nextLine();
                        ops.updateStudent(uprn, newName, newBatch);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 6);
    }
}
package net.salesianos.activities.four;

import net.salesianos.activities.four.models.Table;
import net.salesianos.activities.four.utils.TableManager;

import java.util.List;
import java.util.Scanner;

public class AppFour {
    private static final String FILE_PATH = "./files/four.dat";

    public static void main(String[] args) {
        TableManager tableManager = new TableManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. New Table");
            System.out.println("2. Show Saved Tables");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Insert table's color: ");
                    String color = scanner.nextLine();
                    System.out.print("Insert table's amount of legs: ");
                    int legs = scanner.nextInt();
                    scanner.nextLine();

                    Table newTable = new Table(color, legs);
                    tableManager.saveTableToFile(newTable, FILE_PATH);
                    System.out.println("Table saved successfully.");
                    break;

                case 2:
                    List<Table> tables = tableManager.getAllTablesFromFile(FILE_PATH);
                    if (tables.isEmpty()) {
                        System.out.println("No tables saved.");
                    } else {
                        System.out.println("List of tables:");
                        for (Table table : tables) {
                            System.out.println(table);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option not valid. Please, try again.");
            }
        }
    }
}
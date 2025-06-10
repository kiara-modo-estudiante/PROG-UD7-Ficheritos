package net.salesianos.activities.four.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import net.salesianos.activities.four.models.Table;

public class TableManager {

    private List<Table> tables;

    public TableManager() {
        this.tables = new ArrayList<>();
    }

    /**
     * Adds a table to the in-memory list and saves all tables to the file.
     *
     * @param table    The table to be added.
     * @param filePath The path to the file where the tables will be saved.
     */
    public void addTable(Table table, String filePath) {
        tables.add(table);
        saveTablesToFile(filePath);
    }

    /**
     * Saves all tables from the in-memory list to the specified file.
     *
     * @param filePath The path to the file where the tables will be saved.
     */
    private void saveTablesToFile(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(tables);
        } catch (IOException ioe) {
            System.err.println("Error saving tables to file: " + ioe.getMessage());
        }
    }

    /**
     * Loads tables from the specified file into the in-memory list.
     *
     * @param filePath The path to the file containing the serialized list of
     *                 tables.
     */
    public void loadTablesFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            tables = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            tables = (List<Table>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading tables from file: " + e.getMessage());
            tables = new ArrayList<>();
        }
    }

    /**
     * Retrieves all tables from the in-memory list.
     *
     * @return A list of tables.
     */
    public List<Table> getAllTables() {
        return new ArrayList<>(tables);
    }
}

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

    /**
     * Saves a given table to a file. The method retrieves all existing tables from
     * the specified file,
     * adds the new table to the list, and then writes the updated list back to the
     * file.
     *
     * @param table    The table to be saved.
     * @param filePath The path to the file where the table will be saved.
     *                 The file is expected to contain a serialized list of tables.
     * @throws IOException If an I/O error occurs during file operations.
     */
    public void saveTableToFile(Table table, String filePath) {
        List<Table> tables = new ArrayList<>(getAllTablesFromFile(filePath));
        tables.add(table);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.reset();
            oos.writeObject(tables);
        } catch (IOException ioe) {
            System.err.println("Error saving table to file: " + ioe.getMessage());
        }
    }

    /**
     * Retrieves a list of tables from a file specified by the given file path.
     * If the file does not exist or an error occurs during reading, an empty list
     * is returned.
     *
     * @param filePath The path to the file containing the serialized list of
     *                 tables.
     * @return A list of table objects read from the file, or an empty list if an
     *         error occurs.
     * @throws IOException            If an I/O error occurs during file operations.
     * @throws ClassNotFoundException If the class of a serialized object cannot be
     *                                found.
     */
    public List<Table> getAllTablesFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Table>) ois.readObject();
        } catch (IOException ioe) {
            System.err.println("Warning: Couldn't find any tables on file!");
            return new ArrayList<>();
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Class not found while reading tables from file: " + cnfe.getMessage());
            return new ArrayList<>();
        }
    }
}

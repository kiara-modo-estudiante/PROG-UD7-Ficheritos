package net.salesianos.activities.three;

import net.salesianos.utils.FileManager;

public class AppThree {
    public static void main(String[] args) {
        // a) Create a file to use on this activity
        final String FILE_PATH = "./files/three.txt";

        FileManager.saveText(FILE_PATH, "");
        System.out.println(FILE_PATH + " created. ");

    }
}

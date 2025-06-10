package net.salesianos.activities.three;

import net.salesianos.utils.FileManager;

public class AppThree {
    public static void main(String[] args) {
        final String FILE_PATH = "./files/three.txt";

        FileManager.mergeFilesContent(FILE_PATH, "./files/one.txt", "./files/two.txt");
    }

}

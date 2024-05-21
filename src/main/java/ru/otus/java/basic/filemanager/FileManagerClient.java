package ru.otus.java.basic.filemanager;

import java.io.IOException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileManagerClient {
    private static final Logger logger = LogManager.getLogger(FileManagerClient.class.getName());

    public static void main(String[] args) {
        DirHandler fileManager = new DirHandler("");
        Dispatcher dispatcher = new Dispatcher();
        Scanner scanner = new Scanner(System.in);
        System.out.print(fileManager.getCurrentDir() + ">");
        String rawCommandString = scanner.nextLine();
        while (!rawCommandString.equals("exit")) {
            try {
                dispatcher.execute(fileManager, rawCommandString);
            } catch (IOException e) {
                logger.error("Error", e);
            }
            System.out.print(fileManager.getCurrentDir() + ">");
            rawCommandString = scanner.nextLine();
        }
    }
}

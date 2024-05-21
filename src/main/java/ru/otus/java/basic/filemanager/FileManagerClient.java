package ru.otus.java.basic.filemanager;

import java.util.Scanner;

public class FileManagerClient {
    public static void main(String[] args) {
        DirHandler fileManager = new DirHandler("");
        Dispatcher dispatcher = new Dispatcher();
        Scanner scanner = new Scanner(System.in);
        System.out.print(fileManager.getCurrentDir() + ">");
        String rawCommandString = scanner.nextLine();
        while (!rawCommandString.equals("exit")) {
            dispatcher.execute(fileManager, rawCommandString);
            System.out.print(fileManager.getCurrentDir() + ">");
            rawCommandString = scanner.nextLine();
        }
    }
}

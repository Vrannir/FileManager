package ru.otus.java.basic.filemanager.processors;

import ru.otus.java.basic.filemanager.CommandString;
import ru.otus.java.basic.filemanager.DirHandler;

public class UnknownCommandProcessor implements CommandProcessor{

    @Override
    public void execute(DirHandler dir, CommandString commandString) {
        System.out.println("Unknown command");
    }
}

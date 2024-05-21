package ru.otus.java.basic.filemanager.processors;

import ru.otus.java.basic.filemanager.CommandString;
import ru.otus.java.basic.filemanager.DirHandler;

import java.io.IOException;

public class UnknownCommandProcessor implements CommandProcessor{

    @Override
    public void execute(DirHandler dir, CommandString commandString)  throws IOException {
        System.out.println("Unknown command");
    }
}

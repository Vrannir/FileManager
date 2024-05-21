package ru.otus.java.basic.filemanager.processors;

import ru.otus.java.basic.filemanager.CommandString;
import ru.otus.java.basic.filemanager.DirHandler;

import java.io.IOException;

public interface CommandProcessor {
    void execute (DirHandler dir, CommandString commandString) throws IOException;
}

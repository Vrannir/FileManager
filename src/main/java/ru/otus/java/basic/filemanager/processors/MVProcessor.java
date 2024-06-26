package ru.otus.java.basic.filemanager.processors;

import ru.otus.java.basic.filemanager.CommandString;
import ru.otus.java.basic.filemanager.DirHandler;

import java.io.IOException;

public class MVProcessor implements CommandProcessor {
    @Override
    public void execute(DirHandler dir, CommandString cS) throws IOException{
        if (cS.paramQuantity() < 2) System.out.println("Error in syntax");
        else {
            dir.moveFile(cS.getParameter(1), cS.getParameter(2));
        }
    }
}

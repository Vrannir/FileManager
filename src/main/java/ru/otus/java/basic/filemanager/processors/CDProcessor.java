package ru.otus.java.basic.filemanager.processors;

import ru.otus.java.basic.filemanager.CommandString;
import ru.otus.java.basic.filemanager.DirHandler;

import java.io.IOException;

public class CDProcessor implements CommandProcessor {

    @Override
    public void execute(DirHandler dir, CommandString cS) throws IOException {
        if (cS.paramQuantity() < 1) System.out.println("Error in syntax");
        else if(!dir.cdDir(cS.getParameter(1)))
                System.out.println(cS.getParameter(1) + " don't exist or not a directory");
    }
}

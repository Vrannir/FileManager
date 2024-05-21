package ru.otus.java.basic.filemanager.processors;

import ru.otus.java.basic.filemanager.CommandString;
import ru.otus.java.basic.filemanager.DirHandler;
import ru.otus.java.basic.filemanager.FileInfo;

import java.io.IOException;

public class FInfoProcessor implements CommandProcessor{
    @Override
    public void execute(DirHandler dir, CommandString cS) throws IOException{
        if (cS.paramQuantity() < 1) System.out.println("Error in syntax");
        else {
            FileInfo info;
            info = dir.fileInfo(cS.getParameter(1));
            System.out.println("Name: " + info.getName());
            System.out.println("Size: " + info.getSize());
            System.out.println("Last update: " + info.getLastModifiedDate());
        }
    }
}

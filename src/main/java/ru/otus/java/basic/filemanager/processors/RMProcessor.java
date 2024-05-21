package ru.otus.java.basic.filemanager.processors;

import ru.otus.java.basic.filemanager.CommandString;
import ru.otus.java.basic.filemanager.DirHandler;

import java.io.IOException;

public class RMProcessor implements CommandProcessor{

    @Override
    public void execute(DirHandler dir, CommandString cS) {
        if (cS.paramQuantity() < 1) System.out.println("Error in syntax");
        else {
            try {
                dir.removeFile(cS.getParameter(1));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

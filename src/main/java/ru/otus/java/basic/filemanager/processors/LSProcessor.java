package ru.otus.java.basic.filemanager.processors;

import ru.otus.java.basic.filemanager.CommandString;
import ru.otus.java.basic.filemanager.DirHandler;
import ru.otus.java.basic.filemanager.FileInfo;

public class LSProcessor implements CommandProcessor {

    @Override
    public void execute(DirHandler dir, CommandString cS) {
        boolean extView = (cS.paramQuantity() > 0) && (cS.getParameter(1).equals("-I"));
        if (extView) System.out.println("File Name | File Size | Last Update");
        for (FileInfo infoRaw : dir.listDir()) {
            if (extView) {
                System.out.print(infoRaw.getName());
                if (infoRaw.isFile()) System.out.println(" | " + infoRaw.getSize() + " | " + infoRaw.getLastModifiedDate());
                else System.out.println(" | DIR");
            } else System.out.println(infoRaw.getName());
        }
    }
}

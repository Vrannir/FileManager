package ru.otus.java.basic.filemanager.processors;

import ru.otus.java.basic.filemanager.CommandString;
import ru.otus.java.basic.filemanager.DirHandler;

import java.io.IOException;

public class HelpProcessor implements CommandProcessor{
    @Override
    public void execute(DirHandler dir, CommandString commandString) throws IOException {
        System.out.println("ls [-I]");
        System.out.println("cd [path]");
        System.out.println("mkdir [name]");
        System.out.println("rm [name]");
        System.out.println("mv [source][destination]");
        System.out.println("cp [source][destination]");
        System.out.println("finfo [name]");
        System.out.println("help");
        System.out.println("exit");
    }
}

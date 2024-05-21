package ru.otus.java.basic.filemanager;

import ru.otus.java.basic.filemanager.processors.*;

import java.util.HashMap;
import java.util.Map;

public class Dispatcher {
    private final Map<String, CommandProcessor> router;
    private final CommandProcessor unknownCommandProcessor;

    public Dispatcher() {
        this.router = new HashMap<>();
        this.router.put("mkdir", new MkDirProcessor());
        this.router.put("cd", new CDProcessor());
        this.router.put("ls", new LSProcessor());
        this.router.put("rm", new RMProcessor());
        this.router.put("mv", new MVProcessor());
        this.router.put("cp", new CPProcessor());
        this.router.put("finfo", new FInfoProcessor());
        this.router.put("help", new HelpProcessor());
        this.unknownCommandProcessor = new UnknownCommandProcessor();
    }

    public void execute(DirHandler dir, String rawCommandString) {
        CommandString commandString = new CommandString(rawCommandString);
        if (!router.containsKey(commandString.getCommand())) {
            unknownCommandProcessor.execute(dir, commandString);
            return;
        }
        router.get(commandString.getCommand()).execute(dir, commandString);
    }
}

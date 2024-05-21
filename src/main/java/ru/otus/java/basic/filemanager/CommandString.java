package ru.otus.java.basic.filemanager;

import java.util.ArrayList;
import java.util.List;

public class CommandString {
    private final String rawCommandString;
    private final List<String> parameters;

    public CommandString(String rawCommandString) {
        this.rawCommandString = rawCommandString;
        parameters = new ArrayList<>();
        this.parseCommandString();
    }

    public void parseCommandString() {
        int startIndex = 0;
        int endIndex = rawCommandString.indexOf(' ');
        while (endIndex > 0) {
            parameters.add(rawCommandString.substring(startIndex, endIndex));
            startIndex = endIndex + 1;
            endIndex = rawCommandString.indexOf(' ', startIndex);
        }
        parameters.add(rawCommandString.substring(startIndex));
    }

    public String getCommand() {
        return parameters.get(0);
    }

    public String getParameter(int i) {
        return parameters.get(i);
    }

    public int paramQuantity() {
        return parameters.size() - 1;
    }
}

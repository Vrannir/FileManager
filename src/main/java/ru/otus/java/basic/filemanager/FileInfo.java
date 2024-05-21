package ru.otus.java.basic.filemanager;

import java.nio.file.attribute.FileTime;

public class FileInfo {
    private final String name;
    private final long size;
    private final boolean isFile;
    private final FileTime changeDate;

    public FileInfo(String name, long size, FileTime changeDate, boolean isFile) {
        this.name = name;
        this.size = size;
        this.changeDate = changeDate;
        this.isFile = isFile;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getLastModifiedDate(){
        return changeDate.toString();
    }

    public boolean isFile() {
        return isFile;
    }
}

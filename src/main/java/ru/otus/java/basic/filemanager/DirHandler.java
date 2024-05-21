package ru.otus.java.basic.filemanager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DirHandler {

    private static final String PathDivider = "/";
    private Path currentDir;

    public DirHandler(String initialDirRaw) {
        this.currentDir = Paths.get(initialDirRaw).normalize().toAbsolutePath();
    }

    public String getCurrentDir() {
        return currentDir.toString();
    }

    public Path addNameToDir(String name) {
        Path path;
        path = Paths.get(name);
        if (path.isAbsolute()) return path;
        else return Paths.get(currentDir.toString() + PathDivider + name);
    }

    public boolean cdDir(String dirName) {
        if (Files.isDirectory(addNameToDir(dirName))) {
            currentDir = addNameToDir(dirName).normalize();
            return true;
        } else return false;
    }

    public List<FileInfo> listDir() {
        try {
            List<Path> listDir = Files.list(currentDir).collect(Collectors.toList());
            listDir.sort(new Comparator<Path>() {
                public int compare(Path p1, Path p2) {
                    if (Files.isDirectory(p1) == Files.isDirectory(p2)) {
                        return p1.toString().compareTo(p2.toString());
                    } else if (Files.isDirectory(p1)) return -1;
                    else return 1;
                }
            });
            List<FileInfo> result = new ArrayList<>();
            for (Path p : listDir) {
                result.add(new FileInfo(p.getFileName().toString(), Files.size(p), Files.getLastModifiedTime(p), Files.isRegularFile(p)));
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void makeDir(String dirName) throws IOException{
        Path newDir = Files.createDirectory(addNameToDir(dirName));
    }

    public void removeFile(String fileName) throws IOException {
        Files.delete(addNameToDir(fileName));
    }

    public void moveFile(String source, String destination) throws IOException {
        Files.move(addNameToDir(source), Paths.get(addNameToDir(destination).toString() + PathDivider + source));
    }

    public void copyFile(String source, String destination) throws IOException {
        Files.copy(addNameToDir(source), Paths.get(addNameToDir(destination).toString() + PathDivider + source));
    }

    public FileInfo fileInfo(String fileName) throws IOException {
        Path file = addNameToDir(fileName).normalize();
        return new FileInfo(file.getFileName().toString(), Files.size(file), Files.getLastModifiedTime(file), Files.isRegularFile(file));
    }
}

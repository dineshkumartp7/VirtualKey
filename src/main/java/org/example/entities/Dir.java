package org.example.entities;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class Dir {

    public static final String dir_path = "C:\\Users\\dkumartp\\OneDrive - Cisco\\Desktop\\TestDir";
    private ArrayList<File> files = new ArrayList<File>();
    Path path = FileSystems.getDefault().getPath(dir_path).toAbsolutePath();
    File Dir_files = path.toFile();
    public String getName() {
        return dir_path;
    }
    public void print() {
        System.out.println("Files in the path: ");
        files.forEach(f -> System.out.println(f));
    }
    public ArrayList<File> fillFiles() {
        File[] dirfiles = Dir_files.listFiles();
        files.clear();
        for (int i = 0; i < dirfiles.length; i++) {
            if (dirfiles[i].isFile()) {
                files.add(dirfiles[i]);
            }
        }
        Collections.sort(files);
        return files;
    }
    public ArrayList<File> getFiles() {
        fillFiles();
        return files;
    }
    public void mergeSort() {
    }

}

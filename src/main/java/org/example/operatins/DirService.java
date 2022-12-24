package org.example.operatins;

import org.example.entities.Dir;

import java.io.File;

public class DirService {

    private static Dir fileDirectory = new Dir();

    public static void PrintFiles() {

        fileDirectory.fillFiles();

        for (File file : DirService.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static Dir getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(Dir fileDirectory) {
        DirService.fileDirectory = fileDirectory;
    }
}

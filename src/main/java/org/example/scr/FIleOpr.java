package org.example.scr;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.example.entities.Dir;
import org.example.operatins.ScrService;

public class FIleOpr implements Scr {
    private Dir dirs = new Dir();
    private ArrayList<String> options = new ArrayList<>();
    public FIleOpr() {

        options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A File");
        options.add("4. Return to Menu");

    }

    @Override
    public void ShowMenu() {
        System.out.println("File Options Menu");
        for (String s : options) {
            System.out.println(s);
        }

    }

    public void GetInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {

        switch(option) {

            case 1: // Add File
                this.AddFile();

                this.ShowMenu();
                break;
            case 2: // Delete File
                this.DeleteFile();

                this.ShowMenu();
                break;
            case 3: // Search File
                this.SearchFile();
                this.ShowMenu();
                break;

                /*
            case 4: // Return to Menu

            	ScreenService.setCurrentScreen(ScreenService.WelcomeScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();

                break;
                */
            default:
                System.out.println("Invalid Option");
                break;


        }

    }


    public void AddFile() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are adding a file named: " + fileName);

        try {
            Path path = FileSystems.getDefault().getPath(Dir.dir_path + fileName).toAbsolutePath();
            File file = new File(dirs.getName() + fileName);

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                dirs.getFiles().add(file);

            } else {
                System.out.println("This File Already Exits, no need to add another");
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }



    public void DeleteFile() {

        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are deleting a file named: " + fileName);



        Path path = FileSystems.getDefault().getPath(Dir.dir_path + fileName).toAbsolutePath();
        File file = path.toFile();
        if (file.delete()) {
            System.out.println("Deleted File: " + file.getName());
            dirs.getFiles().remove(file);
        } else {
            System.out.println("Failed to delete file:" + fileName + ", file was not found.");
        }
    }

    public void SearchFile() {

        Boolean found = false;

        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("You are searching for a file named: " + fileName);

        ArrayList<File> files = dirs.getFiles();


        for(int i = 0; i < files.size(); i++) {
            if(files.get(i).getName().equals(fileName)) {
                System.out.println("Found " + fileName);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("File not found");
        }
    }

    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }

    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid input");
        }
        return returnOption;

    }

}

package org.example.scr;


import org.example.operatins.DirService;
import org.example.operatins.ScrService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WelcomeScr implements Scr {
    private String Wtxt = "Welcome to VirtualKey";
    private String Dtxt = "Developed by Dinesh Kumar T P";
    private ArrayList<String> opt = new ArrayList<>();

    public WelcomeScr(){
        opt.add("1: List All Files");
        opt.add("2: Show File operations menu");
        opt.add("3: Quit");
    }

    @Override
    public void ShowMenu(){
        System.out.println("Main Menu");
        for (String string : opt){
            System.out.println((string));
        }
    }

    public void intro(){
        System.out.println((Wtxt));
        System.out.println((Dtxt));
        System.out.println("***************XXXX***************");
        ShowMenu();

    }

    public void GetInput(){
        int option = 0;
        while ((option = this.getOpt()) != 3){
            this.NavigateOption(option);
        }
    }

    @Override
    public void NavigateOption(int option){
        switch (option){
            case 1:
                this.ShowFiles();
                this.ShowMenu();
                break;
            case 2:
                ScrService.setCurrentScreen(ScrService.FileOptionsScreen);
                ScrService.getCurrentScreen().ShowMenu();
                ScrService.getCurrentScreen().GetInput();

                this.ShowMenu();
                break;
            default:
                System.out.println(("Invalid Option"));
                break;
        }
    }

    public void ShowFiles() {

        System.out.println("List of Files: ");
        DirService.PrintFiles();

    }

    private int getOpt() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }


}

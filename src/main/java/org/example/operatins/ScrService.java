package org.example.operatins;

import org.example.scr.FIleOpr;
import org.example.scr.WelcomeScr;
import org.example.scr.Scr;

public class ScrService {
    public static WelcomeScr WelcomeScreen = new WelcomeScr();
    public static FIleOpr FileOptionsScreen = new FIleOpr();

    public static Scr CurrentScreen = WelcomeScreen;


    public static Scr getCurrentScreen() {
        return CurrentScreen;
    }


    public static void setCurrentScreen(Scr currentScreen) {
        CurrentScreen = currentScreen;
    }

}

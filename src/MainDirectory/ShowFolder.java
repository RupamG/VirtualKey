package MainDirectory;

import WelcomeScreen.Show;
import WelcomeScreen.Welcome;
import WelcomeScreen.fileNames;

import java.io.File;

public class ShowFolder {
    public static Welcome Welcome = new Welcome();
    public static fileNames fileNames = new fileNames();

    public static Show CurrentScreen = Welcome;

    public static Show getCurrentScreen(){
        return CurrentScreen;

    }

    public static void setCurrentScreen(Show currentScreen)
    {
        CurrentScreen = currentScreen;
    }
}

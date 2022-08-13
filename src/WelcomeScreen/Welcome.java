package WelcomeScreen;

import MainDirectory.FolderMain;
import MainDirectory.ShowFolder;
import appStorage.Folder;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Welcome implements Show {
    private String Text1 ="Hello Welcome To The Application!";
    private String Text2 ="Developer Details-Developed By: Rupam Gogoi";

    private ArrayList<String> a1= new ArrayList<>();

    public Welcome()
    {
        a1.add("1. Show Files list: ");
        a1.add("2. Files Admin Screen: ");
        a1.add("3. Quit");
    }
    public void MainScreen()
    {
        System.out.println(Text1);
        System.out.println(Text2);
        System.out.println("\n");
        DisplayShow();

    }
    @Override
    public void DisplayShow()
    {
        System.out.println("Final list ");
        for (String v : a1)
        {
            System.out.println(v);
        }

    }
    public void FetchInput()
    {
        int optionChosen =0;
        while ((optionChosen =this.getOption()) != 3)
        {
            this.linkOption(optionChosen);
        }
    }

    @Override
    public void linkOption(int choice)
    {
        switch (choice)
        {
            case 1:
                this.ShowFiles();
                this.DisplayShow();
                break;
            case 2:
                ShowFolder.setCurrentScreen(ShowFolder.fileNames);
                ShowFolder.getCurrentScreen().DisplayShow();
                ShowFolder.getCurrentScreen().FetchInput();
                this.DisplayShow();
                break;
            default:
                System.out.println("Selected choice not available");
                break;
        }
    }

    public void ShowFiles() {

        System.out.println("List of Files: ");
        FolderMain.PrintFiles();

    }

    private int getOption()
    {
        Scanner in = new Scanner(System.in);
        int returnOption=0;
        try{
            returnOption=in.nextInt();
        }
        catch (InputMismatchException exception)
        {
        }
        return returnOption;
    }
}

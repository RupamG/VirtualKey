package WelcomeScreen;

import appStorage.Folder;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class fileNames implements Show {
    private Folder f1 = new Folder();
    private ArrayList<String> a1 = new ArrayList<>();

    public fileNames() {
        a1.add("1. ADD A FILE");
        a1.add("2. DELETE A FILE");
        a1.add("3. SEARCH A FILE");
        a1.add("4. RETURN TO LIST");
    }

    @Override
    public void DisplayShow() {
        System.out.println("File Options Menu");
        //   String[] options = new String[0];
        for (String v1 : a1) {
            System.out.println(v1);
        }
    }

    @Override
    public void linkOption(int choice) {

    }

    public void FetchInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }


    public void NavigateOption(int option) {
        switch (option) {
            case 1:
                this.AddFile();
                this.DisplayShow();
                break;
            case 2:
                this.DeleteFile();
                this.DisplayShow();
                break;
            case 3:
                this.SearchFile();
                this.DisplayShow();
                break;
            default:
                System.out.println("Selected choice not available");
                break;
        }
    }

    public void AddFile() {
        System.out.println("Please Enter the Filename:");
        String fileName = this.getInputString();
        System.out.println("you are adding a file named:" + fileName);
        try {
            Path path = FileSystems.getDefault().getPath(Folder.name + fileName).toAbsolutePath();
            File file = new File(f1.getName() + fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                f1.getFiles().add(file);
            } else {
                System.out.println("This File Already Exits, no need to add another");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void DeleteFile() {
        System.out.println("Please Enter the Filename:");
        String fileName = this.getInputString();
        System.out.println("You are deleting a file named: " + fileName);
        Path path = FileSystems.getDefault().getPath(Folder.name + fileName).toAbsolutePath();
        File file = path.toFile();
        if (file.delete()) {
            System.out.println("Deleted File: " + file.getName());
            f1.getFiles().remove(file);
        } else {
            System.out.println("Failed to delete file:" + fileName + ", file was not found.");
        }
    }

    public void SearchFile() {
        Boolean found=false;
        System.out.println("Please Enter the Filename:");
        String fileName= this.getInputString();
        System.out.println("You are searching for a file named: " + fileName);
        ArrayList<File> files =f1.getFiles();
        for (int i=0;i<files.size();i++)
        {
            if(files.get(i).getName().equals(fileName));
            {
                System.out.println("found "+fileName);
                found=true;
            }
        }
        if (found==false)
        {
            System.out.println("file not available");
        }
    }

    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }

    private int getOption()
    {
        Scanner sc=new Scanner(System.in);
        int returnOption =0;
        try {
            returnOption =sc.nextInt();

        }
        catch (InputMismatchException ex)
        {
            System.out.println("Invalid input");
        }
        return returnOption;

    }
}




















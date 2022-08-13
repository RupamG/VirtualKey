package MainDirectory;

import appStorage.Folder;

import java.io.File;

public class FolderMain {
    private static Folder file1 = new Folder();
    public static void PrintFiles()
    {
        file1.fillFiles();

        for (File file : FolderMain.getFileFolder().getFiles())
        {
            System.out.println(file.getName());
        }

    }
    public static Folder getFileFolder()
    {
        return file1;
    }
    public static void SetFileDirectory(Folder file1)
    {
        FolderMain.file1 =file1;
    }
}

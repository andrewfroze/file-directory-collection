package directiryprinter;

import directiryprinter.entity.Directory;

import java.io.File;

public class DirectoryTreePrinter {
    //place for your Directory :)
    private static String fullPathToDirectory = "";

    public static void main(String[] args) {
        File root = new File(fullPathToDirectory);
        if (root.isDirectory()) {
            Directory rootDirectory = new Directory(root.getPath());
            System.out.println(rootDirectory);
        }
    }
}


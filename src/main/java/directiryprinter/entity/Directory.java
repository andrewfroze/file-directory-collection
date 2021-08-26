package directiryprinter.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory {
    private String directoryFullPath;
    private String directoryName;
    private List<Directory> innerDirectories = new ArrayList<>();
    private List<File> innerFiles = new ArrayList<>();
    private String tabToPrint;
    private String tabToPrintForChildren;

    public Directory(String directoryFullPath, String tabToPrint) {
        init(directoryFullPath, tabToPrint);
    }

    public Directory(String directoryFullPath) {
        init(directoryFullPath, "");
    }

    private void init(String directoryFullPath, String tabToPrint) {
        this.directoryFullPath = directoryFullPath;
        this.directoryName = directoryFullPath.substring(directoryFullPath.lastIndexOf("\\")+1);
        this.tabToPrint = tabToPrint;
        calculateTabForChildren();
        java.io.File directory = new java.io.File(directoryFullPath);
        for (java.io.File file: Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                innerDirectories.add(new Directory(file.getPath(), tabToPrintForChildren));
            } else {
                innerFiles.add(new File(file.getName(), tabToPrintForChildren));
            }
        }
    }

    private void calculateTabForChildren() {
        this.tabToPrintForChildren = tabToPrint + "   ";
        for (int i = 0, l = directoryName.length(); i < l; i++) {
            this.tabToPrintForChildren += " ";
        }
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder(tabToPrint + directoryName + ": [");
        for (Directory directory: innerDirectories) {
            resultString.append("\n").append(directory);
        }
        for (File file: innerFiles) {
            resultString.append(file);
        }
        resultString.append("\n");
        resultString.append(tabToPrintForChildren).append("]");
        return resultString.toString();
    }
}

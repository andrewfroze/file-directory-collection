package directiryprinter.entity;

public class File {
    private final String fileName;
    private final String fileFullPath;
    private final String tabToPrint;

    public File(String fileFullPath, String tabToPrint) {
        this.fileFullPath = fileFullPath;
        this.fileName = fileFullPath.substring(fileFullPath.lastIndexOf("/")+1);
        this.tabToPrint = tabToPrint;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileFullPath() {
        return fileFullPath;
    }

    @Override
    public String toString() {
        return "\n" + tabToPrint + "{" + fileName + "}";
    }
}

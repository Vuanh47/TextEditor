package Homework6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class TextEditorModel {


    private String fileName;
    private String fileAddress;

    public String getFileName() {
        return fileName;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

}

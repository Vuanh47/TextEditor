package Homework6;
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class TextEditorController {
    TextEditorView view;
    String fileName;
    String fileAddress;
    public TextEditorController(TextEditorView view) {
        this.view=view;
    }
    public void newFile() {
        view.textArea.setText("");
        view.frame.setTitle("New");
        fileName=null;
        fileAddress=null;
    }
    public void open() {
        FileDialog fd =new FileDialog(view.frame, "Open",FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile()!=null) {
            fileName =fd.getFile();
            fileAddress =fd.getDirectory();
            view.frame.setTitle(fileName);

        }
        System.out.println("File address and file name "+fileAddress+fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+fileName));
            view.textArea.setText("");
            String line=null;
            while((line =br.readLine())!=null) {
                view.textArea.append(line+ "\n");
            }br.close();
        }catch(Exception e) {
            e.getStackTrace();
        }
    }
    public void save() {
        if (fileName==null) {
            saveAs();
        }else {
            try {
                FileWriter fw = new FileWriter(fileAddress+fileName);
                fw.write(view.textArea.getText());
                view.frame.setTitle(fileName);
                fw.close();
            }catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
    public void saveAs() {
        FileDialog fd = new FileDialog(view.frame, "Save",FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile()!=null) {
            fileName=fd.getFile();
            fileAddress=fd.getDirectory();
            view.frame.setTitle(fileName);
        }
        try {
            FileWriter fw = new FileWriter(fileAddress+fileName);
            fw.write(view.textArea.getText());
            fw.close();
        }catch(Exception e) {
            e.getStackTrace();
        }


    }
    public void exit() {
        System.exit(0);
    }
}

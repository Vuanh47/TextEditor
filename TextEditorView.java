package Homework6;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditorView {
    public JFrame frame;
    public JTextArea textArea;
    public JMenuBar menuBar;
    public TextEditorController controller;

    public TextEditorView() {
        // Tạo cửa sổ
        frame = new JFrame("Text Editor");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo vùng chứa văn bản
        textArea = new JTextArea();
        textArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Tạo thanh menu
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Tạo menu File và các mục trong menu
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        String[] fileMenuItems = {"New", "Open", "Save", "Save As", "Exit"};
        for (String item : fileMenuItems) {
            JMenuItem menuItem = new JMenuItem(item);
            menuItem.addActionListener(e -> menuItemClick(e.getActionCommand()));
            menuFile.add(menuItem);
        }

        // Khởi tạo đối tượng TextEditorController
        controller = new TextEditorController(this);

        // Hiển thị cửa sổ
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void menuItemClick(String command) {
        switch (command) {
            case "New":
                controller.newFile();
                break;
            case "Open":
                controller.open();
                break;
            case "Save":
                controller.save();
                break;
            case "Save As":
                controller.saveAs();
                break;
            case "Exit":
                controller.exit();
                break;
        }
    }

    public static void main(String[] args) {
        new TextEditorView();
    }
}

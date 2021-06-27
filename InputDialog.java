package com.company;

import javax.swing.*;

public class InputDialog {

    public static void inputDialogFileName() {
        String fileName = JOptionPane.showInputDialog("Enter Reminder File Name:");
        ReminderFiles.setFileName(fileName);
        ReminderFiles.openNewReminderFile();
    }
    public static void inputDialogLoadReminderFile (){
        String filePath = JOptionPane.showInputDialog("Enter Reminder File Path:");
        ReminderFiles.RemindersFromTextFile(filePath);
    }
}

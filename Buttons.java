package com.company;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Buttons{
    protected static JButton cmdSaveReminder, cmdUpdateReminder, cmdFindReminder, cmdUploadRemindersFromFile, cmdSaveFileName;

    public Buttons() {

        cmdSaveReminder = new JButton("Save Reminder");
        cmdUpdateReminder = new JButton("Update Reminder");
        cmdFindReminder = new JButton("Find Reminder");
        cmdUploadRemindersFromFile = new JButton("Upload Reminders From File");
        cmdSaveFileName = new JButton("Save Remainder File Name");

        cmdSaveReminder.addActionListener(new ButtonListener());
        cmdUpdateReminder.addActionListener(new ButtonListener());
        cmdFindReminder.addActionListener(new ButtonListener());
        cmdUploadRemindersFromFile.addActionListener(new ButtonListener());
        cmdSaveFileName.addActionListener(new ButtonListener());

    }



    private static class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == cmdSaveReminder) {
                Reminder.setReminderText(JTextFields.getTfReminder().getText());
                Reminder.saveReminder();
                JOptionPane.showMessageDialog(null, "Reminder Saved Successfully" , "Reminder Saved", JOptionPane.INFORMATION_MESSAGE);
                JTextFields.getTfReminder().setText("");
            }
            if(e.getSource() == cmdFindReminder){
                if(Reminder.findReminder(Reminder.reminderDate))
                    JOptionPane.showMessageDialog(null, "Reminder Found", "Reminder Saved", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Reminder Not Found, Try Different Date", "Reminder Saved", JOptionPane.ERROR_MESSAGE);
            }
            if(e.getSource() == cmdUpdateReminder){
                if(Reminder.updateReminder(Reminder.reminderDate)){
                    JOptionPane.showMessageDialog(null, "Reminder Updated Successfully" , "Reminder Saved", JOptionPane.INFORMATION_MESSAGE);
                    JTextFields.getTfReminder().setText("");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Reminder Not Found, Try Different Date", "Reminder Saved", JOptionPane.ERROR_MESSAGE);
                    JTextFields.getTfReminder().setText("");
                }

            }
//            if(e.getSource() == cmdSaveFileName){
//                ReminderFiles.setFileName(JTextFields.getTfFileName().getText());
//                ReminderFiles.openNewReminderFile();
//                JOptionPane.showMessageDialog(null, "File Name Updated Successfully" , "File Name Updated", JOptionPane.INFORMATION_MESSAGE);
//                Buttons.cmdSaveFileName.setEnabled(false);
//            }

            if(e.getSource() == cmdUploadRemindersFromFile){
                InputDialog.inputDialogLoadReminderFile();
            }
        }
    }


}




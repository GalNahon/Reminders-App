package com.company;

import javax.swing.*;
import java.io.IOException;

public class GUI {

    private static JFrame frame;
    private static JPanel pnlDate, pnlReminderText, pnlButtonsOptions;
    protected static JPanel panel;
    protected static String fileName;

    public GUI() throws IOException {

        frame = new JFrame("Reminder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                JOptionPane.showMessageDialog(null, "The Reminders Were Uploaded To Your File" , "Reminders Uploaded To File", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        ReminderFiles.uploadReminderHashtableToFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
            }
        });
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        new JTextFields();
        new Buttons();
        new JComboBoxes();

        pnlDate = new JPanel();
        pnlReminderText = new JPanel();
        pnlButtonsOptions = new JPanel();

        InputDialog.inputDialogFileName();

        pnlDate.add(new JLabel("Select Reminder Date"));
        pnlDate.add(JComboBoxes.cbDay);
        pnlDate.add(JComboBoxes.cbMonth);
        pnlDate.add(JComboBoxes.cbYear);
        panel.add(pnlDate);

        pnlReminderText.add(new JLabel("Enter The Reminder:"));
        pnlReminderText.add(JTextFields.getTfReminder());
        panel.add(pnlReminderText);


        pnlButtonsOptions.add(Buttons.cmdSaveReminder);
        pnlButtonsOptions.add(Buttons.cmdFindReminder);
        pnlButtonsOptions.add(Buttons.cmdUpdateReminder);
        pnlButtonsOptions.add(Buttons.cmdUploadRemindersFromFile);
        panel.add(pnlButtonsOptions);


        frame.add(panel);
        frame.setVisible(true);
    }
}


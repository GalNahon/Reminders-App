package com.company;

import javax.swing.*;
import java.awt.*;

public class JTextFields {
    protected static JTextField tfReminder, tfFileName;

    public JTextFields() {
        tfReminder = new JTextField();
        tfFileName = new JTextField();

        tfReminder.setPreferredSize( new Dimension( 400, 100 ));
        tfFileName.setPreferredSize( new Dimension( 100, 20 ));
    }

    public static JTextField getTfReminder() {
        return tfReminder;
    }

    public static JTextField getTfFileName() {
        return tfFileName;
    }

    public static void setTfReminder(JTextField tfReminder) {
        JTextFields.tfReminder = tfReminder;
    }

    public static void setTfFileName(JTextField tfFileName) {
        JTextFields.tfFileName = tfFileName;
    }
}

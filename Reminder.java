package com.company;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Reminder {
    protected static String reminderText;
    protected static Date reminderDate;
    protected static Hashtable<Date, String> reminderHashtable = new Hashtable<>();

    public static void setReminderText(String reminderText) {
        Reminder.reminderText = reminderText;
    }

    public static void setReminderDate(Date reminderDate) {
        Reminder.reminderDate = reminderDate;
    }

    public static void saveReminder(){
          reminderHashtable.put(reminderDate, reminderText);
    }


    public static Hashtable<Date, String> getReminderHashtable() {
        return reminderHashtable;
    }

    public static boolean updateReminder(Date reminderDateToSearch){
        String findReminderTextByDateKey = Reminder.reminderHashtable.get(Reminder.reminderDate);
        if(findReminderTextByDateKey != null) {
            Reminder.setReminderText(JTextFields.tfReminder.getText());
            reminderHashtable.replace(reminderDate, reminderText);
            return true;
        }
        return false;
    }

    public static boolean findReminder(Date reminderDateToSearch){
        String findReminderTextByDateKey = Reminder.reminderHashtable.get(Reminder.reminderDate);
        if(findReminderTextByDateKey != null) {
            Reminder.setReminderText(findReminderTextByDateKey);
            JTextFields.tfReminder.setText(Reminder.reminderText);
            return true;
        }
        return false;
    }
}

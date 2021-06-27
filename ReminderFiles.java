package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class ReminderFiles {
    protected static ObjectOutputStream out;
    protected static FileOutputStream fos;
    protected static String fileName;

    public static void setFileName(String fileName) {
        ReminderFiles.fileName = fileName;
    }

    public static void openNewReminderFile(){
        fos = null;
        try {
            fos = new FileOutputStream(fileName + ".txt");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        try {
            out = new ObjectOutputStream(fos);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void uploadReminderHashtableToFile() throws IOException {
        Set<Date> keys = Reminder.reminderHashtable.keySet();
        for (Date dateReminder: keys) {
            out.writeObject(Reminder.reminderHashtable.get(dateReminder));
        }

    }

    public static Hashtable<Date, String> RemindersFromTextFile(String filePath) {
        BufferedReader br = null;


        try {
            File file = new File(filePath);
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                String reminderText = parts[1].trim();
                String date = parts[0].trim();
                String[] dateSplit = date.split("\\.");
                String day = dateSplit[0].trim();
                String month = dateSplit[1].trim();
                String year = dateSplit[2].trim();

                Date reminderDate = new Date(day, month, year);

                Reminder.reminderHashtable.put(reminderDate, reminderText);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        return Reminder.reminderHashtable;
    }

}


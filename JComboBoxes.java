package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class JComboBoxes {
    protected static JComboBox cbDay, cbMonth, cbYear;
    private static String day = "1" , month = "1", year = "2021";

    String [] monthArray = {"1","2","3","4","5","6","7","8","9","10","11","12"};

    String [] yearArray = {"2021", "2022", "2023", "2024"};


    public JComboBoxes(){
        cbYear = new JComboBox(yearArray);
        cbMonth = new JComboBox(monthArray);
        cbDay = new JComboBox(days(month,year));

        cbYear.addActionListener(new JComboBoxesListener());
        cbMonth.addActionListener(new JComboBoxesListener());
        cbDay.addActionListener(new JComboBoxesListener());
    }


    private class JComboBoxesListener implements ActionListener, ItemListener{
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == cbDay){
                day = (String) cbDay.getSelectedItem();
            }else {
                if (e.getSource() == cbYear) {
                    year = (String) cbYear.getSelectedItem();

                }
                if (e.getSource() == cbMonth) {
                    month = (String) cbMonth.getSelectedItem();
                }


                Object[] o = days(month, year);
                cbDay.setModel(new DefaultComboBoxModel((String[]) o));
            }
            Reminder.setReminderDate(new Date(day, month, year));

        }


        @Override
        public void itemStateChanged(ItemEvent e) {

        }
    }

    public static String[] days (String stringMonth, String stringYear){
        int month = Integer.parseInt(stringMonth);
        int year = Integer.parseInt(stringYear);
        if (month == Date.FEBRUARY){
            if(Date.isLeap(year)){
                return Date.februaryDaysArrayLeapYear;
            }else return Date.februaryDaysArrayNonLeapYear;
        }
        if(month == Date.APRIL || month == Date.JUNE || month == Date.SEPTEMBER || month == Date.NOVEMBER){
            return Date.thirtyDaysArray;
        }
        return Date.thirtyOneDaysArray;
    }

}



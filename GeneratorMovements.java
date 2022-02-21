import javax.swing.JOptionPane;

import javax.swing.JTextField;

/**
 * 
 * @author Ashiti Patel - Team 28
 *         Date: 11 April 2021
 *         Description: Program to determine the directional tilt/positioning of
 *         the pannels based on the time during the day (the direction of the
 *         sun's rays!)
 */

public class Main {
    public static void main(String[] args) {

        // try and catch for errors
        try {

            // declare variables for input
            int hour = 0;
            int minutes = 0;
            String amORpm = "";
            double degree = 0;
            double percent = 0;
            int actualHour = 0;
            int actualMinutes = 0; // created for understanding purposes only
            String snowingYesNo = "";
            JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();
            JTextField field3 = new JTextField();
            JTextField field4 = new JTextField();
            // array for message
            Object[] message = {
                    "a.m./p.m.:", field1,
                    "Hour:", field2,
                    "Minutes:", field3,
                    "Is it snowing?", field4,
            };

            // prompt
            int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values",
                    JOptionPane.OK_CANCEL_OPTION);

            // read
            if (option == JOptionPane.OK_OPTION) {
                // store data in respective variables
                hour = Integer.parseInt(field2.getText());
                minutes = Integer.parseInt(field3.getText());
                amORpm = field1.getText();
                snowingYesNo = field4.getText();
            }

            // when not snowing
            if (snowingYesNo.equals("no")) {
                // time am
                if (amORpm.equals("am")) {
                    if (hour >= 6 && hour < 12) {
                        actualHour = 60 * (hour - 6);
                        actualMinutes = minutes;
                        degree = (actualHour + actualMinutes) / 4;
                    }

                    else if (hour < 6 && hour >= 0) {
                        degree = 0;
                    }

                    else {
                        degree = -1;
                    }

                }

                // time pm
                else if (amORpm.equals("pm")) {
                    if (hour == 12) {
                        actualHour = 60 * (12 - 6);
                        actualMinutes = minutes;
                        degree = (actualHour + actualMinutes) / 4;
                    }

                    if ((hour >= 1 && hour < 6) || (hour == 6 && minutes == 0)) {
                        actualHour = 60 * (6 + hour);
                        actualMinutes = minutes;
                        degree = (actualHour + actualMinutes) / 4;
                    }

                    if (hour > 6 && hour <= 12) {
                        degree = 0;
                    }

                    if (hour > 12 || hour < 0) {
                        degree = -1;
                    }

                }

                if (degree < 0) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                }

                if (percent >= 0) {
                    JOptionPane.showMessageDialog(null, "Rotate the SolarNano Generator by " + degree + " degrees.");
                }

            }

            if (snowingYesNo.equalsIgnoreCase("yes")) {
                JOptionPane.showMessageDialog(null, "Rotate the SolarNano Generator by 225.0 degrees.");
            }

        }

        // invalid characters entered instead of numbers
        catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(null, "Invalid Input.");
        }

    }

}
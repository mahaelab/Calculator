package org.example;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc extends JFrame {

    JButton button;
    JFrame frame;
    JComboBox<String> operation;

    public Calc() {
        button = new JButton();
        frame = new JFrame();
        operation = new JComboBox<>(new String[]{"Add", "Subtract", "Multiply", "Divide"});
    }

    // This method is needed for the test case in CalcTest.java
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        ProgramRun myCalc = new ProgramRun();
        javax.swing.SwingUtilities.invokeLater(myCalc);
    }

    // Creates GUI and makes it visible
    public static void getSetGUI() {
        Calc frame = new Calc();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addPane(frame.getContentPane());
        frame.setTitle("Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    // Defines and adds features to the pane
    public void addPane(Container pane) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.setPreferredSize(new Dimension(280, 250));

        frame.add(panel, BorderLayout.CENTER);
        pane.add(panel);

        // Sets size of fields and adds to panel
        JLabel txt1 = new JLabel("Number 1: ");
        JLabel txt2 = new JLabel("Number 2: ");
        JLabel blank = new JLabel("");

        JTextField tf1 = new JTextField("");
        JTextField tf2 = new JTextField("");

        panel.add(txt1);
        panel.add(tf1);
        panel.add(txt2);
        panel.add(tf2);
        panel.add(blank);

        // Adds operation menu
        panel.add(operation);

        // Adds calculate button to panel
        JButton calculateButton = new JButton("Calculate");
        panel.add(calculateButton);

        // Answer field
        JLabel resultField = new JLabel("Result: ");
        panel.add(resultField);

        // Action listener determines what action should happen when performing operation
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Clicking calculate without any numbers outputs the following error message
                if (tf1.getText().equals("") || tf2.getText().equals("")) {
                    JOptionPane.showMessageDialog(panel, "Please Enter Two Numbers");
                } else {
                    try {
                        double first = Double.parseDouble(tf1.getText());
                        double second = Double.parseDouble(tf2.getText());

                        // Choose an operation
                        String op = operation.getSelectedItem().toString();
                        double answer = 0;

                        // Switch case for arithmetic operations
                        switch (op) {
                            case "Add":
                                answer = first + second;
                                break;
                            case "Subtract":
                                answer = first - second;
                                break;
                            case "Multiply":
                                answer = first * second;
                                break;
                            case "Divide":
                                answer = first / second;
                                break;
                        }
                        // Outputs answer to resultField
                        resultField.setText("Result: " + answer);

                    } catch (NumberFormatException e) {
                        // If characters other than numbers are used
                        JOptionPane.showMessageDialog(panel, "Enter Valid Numbers");
                    }
                }
            }
        });
    }
}

class ProgramRun implements Runnable {
    public void run() {
        Calc.getSetGUI();
    }
}

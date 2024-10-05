package org.proj;

import javax.swing.*; //For j Frame, panel and GUI
import java.awt.*;
import java.awt.event.*;
import java.util.Random; //For position of The Piranha And the Mole

public class WhackAMole {
    //Defining The height and width of the board UI
    int BoardWidth = 600;
    int BoardHeight = 650;

    JFrame frame = new JFrame("Mario: Whack A Mole");
    JLabel textLable = new JLabel();
    JPanel textPanel = new JPanel();

    //Constructor for calling
    WhackAMole() {
        frame.setVisible(true);
        frame.setSize(BoardWidth, BoardHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X to close the program
        frame.setResizable(false); // Non-resizeable
        frame.setLocationRelativeTo(null); // To display At the Center
        frame.setLayout(new BorderLayout()); // For Layout management

        textLable.setFont(new Font("Arial", Font.PLAIN, 50));
        textLable.setHorizontalAlignment();
    }
}

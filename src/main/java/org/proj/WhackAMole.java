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
    JPanel BoardPanel = new JPanel();

    JButton[] board = new JButton[9];
    ImageIcon mole;
    ImageIcon piranha;

    JButton currMolePos;
    JButton currPiranhaPos;

    Random random = new Random();
    Timer setM0leTimer;
    Timer setPiranhaTimer;
    int Score =0;

    //Constructor for calling
    WhackAMole() {

        frame.setSize(BoardWidth, BoardHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X to close the program
        frame.setResizable(false); // Non-resizeable
        frame.setLocationRelativeTo(null); // To display At the Center
        frame.setLayout(new BorderLayout()); // For Layout management

        //Text Lable
        textLable.setFont(new Font("Arial", Font.PLAIN, 50));
        textLable.setHorizontalAlignment(JLabel.CENTER);
        textLable.setText("Score : 0");
        textLable.setOpaque(true);

        //Text Panel
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLable);
        frame.add(textPanel, BorderLayout.NORTH);

        //Board Panel
        BoardPanel.setLayout(new GridLayout(3,3));

        frame.add(BoardPanel);

        //Image setting of piranha
        Image piranhaicon = new ImageIcon(getClass().getResource("/piranha.png")).getImage();
        piranha = new ImageIcon(piranhaicon.getScaledInstance(150,150, Image.SCALE_SMOOTH));

        //Image setting of Mole
        Image moleicon = new ImageIcon(getClass().getResource("/monty.png")).getImage();
        mole = new ImageIcon(moleicon.getScaledInstance(150,150, Image.SCALE_SMOOTH));



        //Loop to add Buttons to represent grids into the board array
        for (int i = 0; i <9; i++){
            JButton tile = new JButton();
            board[i] = tile;
            BoardPanel.add(tile);
            tile.setFocusable(false); //To remove the rectangles surrounding the img when clicked
            tile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tile = (JButton)e.getSource();
                    if (tile == currMolePos){
                        Score += 10;
                        textLable.setText("Score: "+ Integer.toString(Score));
                    } else if (tile == currPiranhaPos) {
                        textLable.setText("Game Over"+Integer.toString(Score));
                        setM0leTimer.stop();
                        setPiranhaTimer.stop();
                        for (int i = 0; i <9;i++){
                            board[i].setEnabled(false);
                        }
                    }
                }
            });
        }

        setM0leTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currMolePos != null){
                    currMolePos.setIcon(null);
                    currMolePos = null;
                }
                int num = random.nextInt(9);
                JButton pos = board[num];

//                Check if already occupied
                if(currPiranhaPos == pos){
                    return;
                }

                currMolePos =pos;
                currMolePos.setIcon(mole);

            }
        });
        setPiranhaTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currPiranhaPos != null){
                    currPiranhaPos.setIcon(null);
                    currPiranhaPos = null;
                }
                int num = random.nextInt(9);
                JButton pos = board[num];

                if (currMolePos == pos){
                    return;
                }

                currPiranhaPos =pos;
                currPiranhaPos.setIcon(piranha);

            }
        });


    setPiranhaTimer.start();
    setM0leTimer.start();
    frame.setVisible(true); //To ensure all the components are loaded first before making the game visible


    }

}

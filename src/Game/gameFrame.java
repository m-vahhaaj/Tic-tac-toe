package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gameFrame {
    private JFrame gFrame, resultFrame;
    private JPanel turnArea, resultButtons;
    private JMenuBar menuBar;
    private JMenu game;
    private JMenuItem newGame, hideScore, exitResult;
    private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,playAgain,Exit;
    private JLabel p1Turn, p2Turn, p1Score, p2Score, resultLabel;
    private String p1Name, p2Name;
    private char p1Symbol, p2Symbol, currentSymbol;
    private char[] table;
    private int p1Wins, p2Wins;
    private Color smoothRed, smoothGreen;
    private Boolean scoreSwitch;
    public gameFrame(String n1, String n2, char s1, char s2) {
        p1Name = n1;
        p2Name = n2;
        p1Symbol = s1;
        p2Symbol = s2;
        p1Wins = 0;
        p2Wins = 0;
        scoreSwitch = false;
    }
    public void showGFrame() {
        gFrame = new JFrame("Tic Tac Toe");
        gFrame.setLayout(new GridLayout(3,3));
        table = new char[9];
        menuBar = new JMenuBar();
        game = new JMenu("Game Options");
        newGame = new JMenuItem("New Game");
        hideScore = new JMenuItem("Hide Score");
        playAgain = new JButton("Play Again");
        exitResult = new JMenuItem("Exit");
        Exit = new JButton("Exit");
        playAgain.setFont(new Font("Arial", Font.BOLD, 22));
        Exit.setFont(new Font("Arial", Font.BOLD, 22));
        turnArea = new JPanel(new GridBagLayout());
        resultButtons = new JPanel(new GridBagLayout());
        p1Turn = new JLabel(p1Name, SwingConstants.CENTER);
        p2Turn = new JLabel(p2Name, SwingConstants.CENTER);
        p1Score = new JLabel(p1Name+" Score: "+0, SwingConstants.CENTER);
        p2Score = new JLabel(p2Name+" Score: "+0, SwingConstants.CENTER);
        resultLabel = new JLabel("", SwingConstants.CENTER);
        p1Turn.setFont(new Font("Arial", Font.BOLD, 22));
        p2Turn.setFont(new Font("Arial", Font.BOLD, 22));
        p1Score.setFont(new Font("Arial", Font.BOLD, 22));
        p2Score.setFont(new Font("Arial", Font.BOLD, 22));
        resultLabel.setFont(new Font("Arial", Font.BOLD, 22));
        b0 = new JButton(); b0.setFont(new Font("Arial", Font.BOLD, 72));
        b1 = new JButton(); b1.setFont(new Font("Arial", Font.BOLD, 72));
        b2 = new JButton(); b2.setFont(new Font("Arial", Font.BOLD, 72));
        b3 = new JButton(); b3.setFont(new Font("Arial", Font.BOLD, 72));
        b4 = new JButton(); b4.setFont(new Font("Arial", Font.BOLD, 72));
        b5 = new JButton(); b5.setFont(new Font("Arial", Font.BOLD, 72));
        b6 = new JButton(); b6.setFont(new Font("Arial", Font.BOLD, 72));
        b7 = new JButton(); b7.setFont(new Font("Arial", Font.BOLD, 72));
        b8 = new JButton(); b8.setFont(new Font("Arial", Font.BOLD, 72));
        turnArea.add(p1Turn, new GridBagConstraints(0,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        turnArea.add(p2Turn, new GridBagConstraints(0,1,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        gFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gFrame.setSize(800,500);
        gFrame.setLocationRelativeTo(null);
        gFrame.add(b0); gFrame.add(b1); gFrame.add(b2); gFrame.add(turnArea);
        gFrame.add(b3); gFrame.add(b4); gFrame.add(b5); gFrame.add(p1Score);
        gFrame.add(b6); gFrame.add(b7); gFrame.add(b8); gFrame.add(p2Score);
        game.add(newGame); game.add(hideScore); game.add(exitResult); menuBar.add(game);
        gFrame.setJMenuBar(menuBar);
        smoothRed = new Color(243, 129, 160);
        smoothGreen = new Color(156, 240, 132);
        resultFrame = new JFrame("Winnner");
        resultFrame.setLayout(new GridLayout(3,3));
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultFrame.setSize(400, 200);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setResizable(false);
        resultButtons.add(playAgain, new GridBagConstraints(0,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        resultButtons.add(Exit, new GridBagConstraints(1,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        resultFrame.add(resultLabel, new GridBagConstraints(0,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        resultFrame.add(resultButtons, new GridBagConstraints(0,1,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        gFrame.setVisible(true);
        startGame(1);
        b0.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                b0.setText(String.valueOf(currentSymbol));
                table[0] = currentSymbol;
                b0.setEnabled(false);
                changeTurn();
                checkWinCondition();
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                b1.setText(String.valueOf(currentSymbol));
                table[1] = currentSymbol;
                b1.setEnabled(false);
                changeTurn();
                checkWinCondition();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                b2.setText(String.valueOf(currentSymbol));
                table[2] = currentSymbol;
                b2.setEnabled(false);
                changeTurn();
                checkWinCondition();
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                b3.setText(String.valueOf(currentSymbol));
                table[3] = currentSymbol;
                b3.setEnabled(false);
                changeTurn();
                checkWinCondition();
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                b4.setText(String.valueOf(currentSymbol));
                table[4] = currentSymbol;
                b4.setEnabled(false);
                changeTurn();
                checkWinCondition();
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                b5.setText(String.valueOf(currentSymbol));
                table[5] = currentSymbol;
                b5.setEnabled(false);
                changeTurn();
                checkWinCondition();
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                b6.setText(String.valueOf(currentSymbol));
                table[6] = currentSymbol;
                b6.setEnabled(false);
                changeTurn();
                checkWinCondition();
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                b7.setText(String.valueOf(currentSymbol));
                table[7] = currentSymbol;
                b7.setEnabled(false);
                changeTurn();
                checkWinCondition();
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                b8.setText(String.valueOf(currentSymbol));
                table[8] = currentSymbol;
                b8.setEnabled(false);
                changeTurn();
                checkWinCondition();
            }
        });
        playAgain.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                newGame(0);
                gFrame.setEnabled(true);
                resultFrame.setVisible(false);
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitResult.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        newGame.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                newGame(1);
            }
        });
        hideScore.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                if(scoreSwitch == false) {
                    hideScore.setText("Show Score");
                    p1Score.setText(""); p2Score.setText("");
                    scoreSwitch = !scoreSwitch;
                }
                else {
                    hideScore.setText("Hide Score");
                    scoreSwitch = !scoreSwitch;
                    updateScore();
                }
            }
        });
    }
    public void changeTurn() {
        if(currentSymbol == p1Symbol)
        {
            currentSymbol = p2Symbol;
            p1Turn.setText(p1Name);
            p2Turn.setText("<> "+p2Name+" <>");
        }
        else
        {
            currentSymbol = p1Symbol;
            p1Turn.setText("<> "+p1Name+" <>");
            p2Turn.setText(p2Name);
        }
    }
    public void startGame(int stage) {
        switch(stage) {
            case 1 : 
                currentSymbol = p1Symbol;
                p1Turn.setText("<> "+p1Name+" <>");
                break;
            case 2 :
                if(getDifferentTurn() == 1) {
                    currentSymbol = p1Symbol;
                    p1Turn.setText("<> "+p1Name+" <>");
                    p2Turn.setText(p2Name);
                }
                else {
                    currentSymbol = p2Symbol;
                    p1Turn.setText(p1Name);
                    p2Turn.setText("<> "+p2Name+" <>");
                }
        }
    }
    public void newGame(int type) {
        b0.setBackground(null); b0.setText("");
        b1.setBackground(null); b1.setText("");
        b2.setBackground(null); b2.setText("");
        b3.setBackground(null); b3.setText("");
        b4.setBackground(null); b4.setText("");
        b5.setBackground(null); b5.setText("");
        b6.setBackground(null); b6.setText("");
        b7.setBackground(null); b7.setText("");
        b8.setBackground(null); b8.setText("");
        toggleButtons(true);
        for(int i=0;i<=8;i++) table[i] = '\0';
        if(type == 1) {
            p1Wins = 0;
            p2Wins = 0;
        }
        startGame(2);
        updateScore();
    }
    public int getDifferentTurn() {
        int get;
        get = (int)((Math.random() * 2-1) + 1) ;
        return get;
    }
    public void checkWinCondition() {
        /*
        0   1   2
        3   4   5
        6   7   8
        */
        // Check for columns
        if(table[0] == table[3] && table[0] == table[6] && table[0] != '\0') {
            if(table[0] == p1Symbol) {
                resultLabel.setText(p1Name+" (Symbol: "+p1Symbol+") has won!");
                p1Wins++;
            }
            else {
                resultLabel.setText(p2Name+" (Symbol: "+p2Symbol+") has won!");
                p2Wins++;
            }
            b0.setBackground(smoothGreen);
            b3.setBackground(smoothGreen);
            b6.setBackground(smoothGreen);
            updateScore();
            gFrame.setEnabled(false);
            resultFrame.setVisible(true);
        }
        else if(table[1] == table[4] && table[1] == table[7] && table[1] != '\0') {
            if(table[1] == p1Symbol) {
                resultLabel.setText(p1Name+" (Symbol: "+p1Symbol+") has won!");
                p1Wins++;
            }
            else {
                resultLabel.setText(p2Name+" (Symbol: "+p2Symbol+") has won!");
                p2Wins++;
            }
            b1.setBackground(smoothGreen);
            b4.setBackground(smoothGreen);
            b7.setBackground(smoothGreen);
            updateScore();
            gFrame.setEnabled(false);
            resultFrame.setVisible(true);
        }
        else if(table[2] == table[5] && table[2] == table[8] && table[2] != '\0') {
            if(table[2] == p1Symbol) {
                resultLabel.setText(p1Name+" (Symbol: "+p1Symbol+") has won!");
                p1Wins++;
            }
            else {
                resultLabel.setText(p2Name+" (Symbol: "+p2Symbol+") has won!");
                p2Wins++;
            }
            b2.setBackground(smoothGreen);
            b5.setBackground(smoothGreen);
            b8.setBackground(smoothGreen);
            updateScore();
            gFrame.setEnabled(false);
            resultFrame.setVisible(true);
        }
        // Check for rows
        else if(table[0] == table[1] && table[0] == table[2] && table[0] != '\0') {
            if(table[0] == p1Symbol) {
                resultLabel.setText(p1Name+" (Symbol: "+p1Symbol+") has won!");
                p1Wins++;
            }
            else {
                resultLabel.setText(p2Name+" (Symbol: "+p2Symbol+") has won!");
                p2Wins++;
            }
            b0.setBackground(smoothGreen);
            b1.setBackground(smoothGreen);
            b2.setBackground(smoothGreen);
            updateScore();
            gFrame.setEnabled(false);
            resultFrame.setVisible(true);
        }
        else if(table[3] == table[4] && table[3] == table[5] && table[3] != '\0') {
            if(table[3] == p1Symbol) {
                resultLabel.setText(p1Name+" (Symbol: "+p1Symbol+") has won!");
                p1Wins++;
            }
            else {
                resultLabel.setText(p2Name+" (Symbol: "+p2Symbol+") has won!");
                p2Wins++;
            }
            b3.setBackground(smoothGreen);
            b4.setBackground(smoothGreen);
            b5.setBackground(smoothGreen);
            updateScore();
            gFrame.setEnabled(false);
            resultFrame.setVisible(true);
        }
        else if(table[6] == table[7] && table[6] == table[8] && table[6] != '\0') {
            if(table[6] == p1Symbol) {
                resultLabel.setText(p1Name+" (Symbol: "+p1Symbol+") has won!");
                p1Wins++;
            }
            else {
                resultLabel.setText(p2Name+" (Symbol: "+p2Symbol+") has won!");
                p2Wins++;
            }
            b6.setBackground(smoothGreen);
            b7.setBackground(smoothGreen);
            b8.setBackground(smoothGreen);
            updateScore();
            gFrame.setEnabled(false);
            resultFrame.setVisible(true);
        }
        // Check for diagnols
        else if(table[0] == table[4] && table[0] == table[8] && table[0] != '\0') {
            if(table[0] == p1Symbol) {
                resultLabel.setText(p1Name+" (Symbol: "+p1Symbol+") has won!");
                p1Wins++;
            }
            else {
                resultLabel.setText(p2Name+" (Symbol: "+p2Symbol+") has won!");
                p2Wins++;
            }
            b0.setBackground(smoothGreen);
            b4.setBackground(smoothGreen);
            b8.setBackground(smoothGreen);
            updateScore();
            gFrame.setEnabled(false);
            resultFrame.setVisible(true);
        }
        else if(table[2] == table[4] && table[2] == table[6] && table[2] != '\0') {
            if(table[2] == p1Symbol) {
                resultLabel.setText(p1Name+" (Symbol: "+p1Symbol+") has won!");
                p1Wins++;
            }
            else {
                resultLabel.setText(p2Name+" (Symbol: "+p2Symbol+") has won!");
                p2Wins++;
            }
            b2.setBackground(smoothGreen);
            b4.setBackground(smoothGreen);
            b6.setBackground(smoothGreen);
            updateScore();
            gFrame.setEnabled(false);
            resultFrame.setVisible(true);
        }
        // Check for draw
        else if(tableFilled()) {
            resultLabel.setText("It was a draw. Nobody Won!");
            gFrame.setEnabled(false);
            b0.setBackground(smoothRed);
            b1.setBackground(smoothRed);
            b2.setBackground(smoothRed);
            b3.setBackground(smoothRed);
            b4.setBackground(smoothRed);
            b5.setBackground(smoothRed);
            b6.setBackground(smoothRed);
            b7.setBackground(smoothRed);
            b8.setBackground(smoothRed);
            resultFrame.setVisible(true);
        }
    }
    public Boolean tableFilled() {
        Boolean checkTable = false;
        for(int i=0;i<=8;i++) {
            if(table[i] == p1Symbol || table[i] == p2Symbol) checkTable = true;
            else {
                checkTable = false;
                break;
            }
        }
        return checkTable;
    }
    public void toggleButtons(Boolean state) {
        b0.setEnabled(state);
        b1.setEnabled(state);
        b2.setEnabled(state);
        b3.setEnabled(state);
        b4.setEnabled(state);
        b5.setEnabled(state);
        b6.setEnabled(state);
        b7.setEnabled(state);
        b8.setEnabled(state);
    }
    public void updateScore() {
        if(scoreSwitch != true) {
            p1Score.setText(p1Name+" Score: "+p1Wins);
            p2Score.setText(p2Name+" Score: "+p2Wins);
        }
    }
}

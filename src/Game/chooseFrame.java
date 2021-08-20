package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class chooseFrame {
    private JFrame cFrame;
    private JLabel plzChoose, or;
    private JButton X, O;
    private JPanel area, barea;
    private String p1Name, p2Name;
    private char p1Symbol, p2Symbol;
    public chooseFrame(String n1, String n2) {
        p1Name=n1; p2Name=n2;
    }
    public void showCFrame() {
        cFrame = new JFrame("Tic Tac Toe");
        cFrame.setLayout(new GridBagLayout());
        plzChoose = new JLabel(p1Name+" choose your Symbol: ", SwingConstants.CENTER);
        or = new JLabel("    OR    ", SwingConstants.CENTER);
        plzChoose.setFont(new Font("Arial", Font.BOLD, 22));
        or.setFont(new Font("Arial", Font.BOLD, 22));
        X = new JButton("X");
        O = new JButton("O");
        area = new JPanel(); area.setLayout(new GridBagLayout());
        barea = new JPanel(); area.setLayout(new GridBagLayout());
        X.setFont(new Font("Arial", Font.BOLD, 72));
        O.setFont(new Font("Arial", Font.BOLD, 72));
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cFrame.setSize(500,500);
        area.add(plzChoose, new GridBagConstraints(0,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        barea.add(X, new GridBagConstraints(0,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        barea.add(or, new GridBagConstraints(1,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        barea.add(O, new GridBagConstraints(2,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        cFrame.add(area, new GridBagConstraints(0,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        cFrame.add(barea, new GridBagConstraints(0,1,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        cFrame.setLocationRelativeTo(null);
        cFrame.setVisible(true);
        X.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                p1Symbol = 'X';
                p2Symbol = 'O';
                gameFrame f = new gameFrame(p1Name, p2Name, p1Symbol, p2Symbol);
                f.showGFrame();
                cFrame.dispose();
            }
        });
        O.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                p1Symbol = 'O';
                p2Symbol = 'X';
                gameFrame f = new gameFrame(p1Name, p2Name, p1Symbol, p2Symbol);
                f.showGFrame();
                cFrame.dispose();
            }
        });
    }
}

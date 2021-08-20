package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class settingFrame {
    private JFrame sFrame;
    private JPanel area;
    private JLabel enterNames, p1Name, p2Name;
    private JTextField p1text, p2text;
    private JButton done;
    public void showSFrame() {
        sFrame = new JFrame("Tic Tac Toe");
        area = new JPanel(); area.setLayout(new GridBagLayout());
        p1text = new JTextField("Player1",12);
        p2text = new JTextField("Player2",12);
        enterNames = new JLabel("Enter Player Names: ", SwingConstants.CENTER);
        p1Name = new JLabel("Player 1 Name: ");
        p2Name = new JLabel("Player 2 Name: ");
        enterNames.setFont(new Font("Arial", Font.BOLD, 22));
        p1Name.setFont(new Font("Arial", Font.BOLD, 22));
        p2Name.setFont(new Font("Arial", Font.BOLD, 22));
        done = new JButton("Done");
        sFrame.setLayout(new GridBagLayout());
        sFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sFrame.setSize(500,500);
        sFrame.setLocationRelativeTo(null);
        p1text.setFont(new Font("Arial", Font.PLAIN, 22));
        p2text.setFont(new Font("Arial", Font.PLAIN, 22));
        done.setFont(new Font("Arial", Font.BOLD, 22));
        sFrame.add(enterNames, new GridBagConstraints(0,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        area.add(p1Name, new GridBagConstraints(0,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        area.add(p1text, new GridBagConstraints(1,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        area.add(p2Name, new GridBagConstraints(0,1,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        area.add(p2text, new GridBagConstraints(1,1,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        sFrame.add(area, new GridBagConstraints(0,1,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        sFrame.add(done, new GridBagConstraints(0,2,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        sFrame.setVisible(true);
        done.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                String p1n = p1text.getText(), p2n = p2text.getText();
                p1n = p1n.trim(); p2n = p2n.trim();
                p1n = p1n.substring(0, 1).toUpperCase() + p1n.substring(1);
                p2n = p2n.substring(0, 1).toUpperCase() + p2n.substring(1);
                chooseFrame f = new chooseFrame(p1n, p2n);
                f.showCFrame();
                sFrame.dispose();
            }
        });
    }
}

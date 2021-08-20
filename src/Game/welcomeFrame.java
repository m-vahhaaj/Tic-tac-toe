package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class welcomeFrame {
    private JFrame wlcmfrm;
    private JLabel picture, msg;
    private JButton start, exit;
    public void showWlcmFrm() {
        wlcmfrm = new JFrame("Tic Tac Toe");
        picture = new JLabel(new ImageIcon("E:/tictactoe.jpg"));
        msg = new JLabel("Please Select: ", SwingConstants.CENTER);
        start = new JButton("Start");
        exit = new JButton("Exit");
        msg.setFont(new Font("Arial", Font.BOLD, 22));
        start.setFont(new Font("Arial", Font.BOLD, 22));
        exit.setFont(new Font("Arial", Font.BOLD, 22));
        wlcmfrm.setLayout(new GridBagLayout());
        wlcmfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wlcmfrm.setSize(500,500);
        wlcmfrm.setLocationRelativeTo(null);
        // Adding components
        wlcmfrm.add(picture, new GridBagConstraints(0,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        wlcmfrm.add(msg, new GridBagConstraints(0,1,1,1,0.0,0.0,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10,10,10,10),0,0));
        wlcmfrm.add(start, new GridBagConstraints(0,2,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        wlcmfrm.add(exit, new GridBagConstraints(0,3,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(10,10,10,10),0,0));
        // Showing JFrameWelcome
        wlcmfrm.setVisible(true);
        start.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                settingFrame f = new settingFrame();
                f.showSFrame();
                wlcmfrm.dispose();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

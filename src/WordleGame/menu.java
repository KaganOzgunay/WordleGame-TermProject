package WordleGame;
import javax.swing.*;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu implements ActionListener{
    int c = 0;
    JFrame frame123 = new JFrame("MENU");

    JButton btn1 = new JButton("multi");
    JButton btn2 = new JButton("submit");
    public menu() {
        frame123.setVisible(true);

        frame123.setSize(400,400);
        frame123.setLayout(null);

        btn1.setBounds(50,50,50,50);
        btn2.setBounds(50,150,50,50);
        frame123.add(btn1);
        frame123.add(btn2);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn1){
            new runGame();
            System.out.println("selam");
        }
        if(e.getSource() == btn2){
            new runGame2();
            System.out.println("selam");
        }
    }
    public static void main(String[] args){
        new menu();
    }
}

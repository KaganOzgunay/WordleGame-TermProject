package WordleGame;

import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Wordle{
    int counter = 0;
    Algorithm txt = new Algorithm();
    Algorithm field = new Algorithm();

    JTextField textfield;
    static JButton[] buttonArray = new JButton[5];



    KeyBoard keyboard = new KeyBoard();
    JLabel label;


    static JFrame f= new JFrame("Wordle");

    JTextField t11,t12,t13,t14,t15;

    LineBorder border = new LineBorder(Color.BLACK,2);
    LineBorder ifSameBorder = new LineBorder(Color.GREEN,2);
    LineBorder ifNotSameborder = new LineBorder(Color.YELLOW,2);
    Wordle(){
        field.setField(6,5);
        f.getContentPane().setBackground(Color.BLACK);

        keyboard.setKeyboard(f);






        //f.add(t11);f.add(t12);f.add(t13);f.add(t14);f.add(t15);f.add(result);f.add(b1);

        f.setSize(600,800);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {


        new Wordle();

    } }

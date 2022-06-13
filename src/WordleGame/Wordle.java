package WordleGame;

import javax.swing.*;


import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Wordle{


    int counter = 0;
    static Algorithm txt = new Algorithm();
    Algorithm field = new Algorithm();
    static Algorithm score = new Algorithm();


    static JButton[] buttonArray = new JButton[5];
    static String[][] stickerArr = new String[5][5];


    KeyBoard keyboard = new KeyBoard();
    JLabel label;
    public static String titleStr;


    static JFrame f= new JFrame("Wordle");

    static JLabel lbl2 = new JLabel();
    static JLabel lbl3 = new JLabel();








    public Wordle(){

        txt.wordSelector();
        //Stopwatch.start();
        for(int a = 0;a<5;a++){
            for(int b = 0;b<5;b++){
                stickerArr[a][b]="[]";
            }

        }
        
        f.setSize(900,800);
        View page = new View();

        field.setField(5,5);
        
        
        keyboard.setKeyboard(f);
        

        f.setLayout(new BorderLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public static JFrame getframe () {
    	return f;
    }
}
/*
    public static void main(String[] args) {
        SwitchButton switchButton = new SwitchButton();
        f.add(switchButton);


        new Wordle();
        
    } 
}*/




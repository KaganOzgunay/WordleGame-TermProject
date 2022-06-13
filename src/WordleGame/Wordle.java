package WordleGame;

import javax.swing.*;


import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

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
    Algorithm hscore = new Algorithm();

    static JFrame f;

    static JLabel lbl2 = new JLabel();
    static JLabel lbl3 = new JLabel();








    public Wordle(JFrame f){
    	this.f = f;
        txt.wordSelector();
        //Stopwatch.start();
        for(int a = 0;a<5;a++){
            for(int b = 0;b<5;b++){
                stickerArr[a][b]="[]";
            }

        }
        
        f.setSize(900,800);
        View page = new View();
        
        Stopwatch timer =new Stopwatch();
        JLabel timerlabel = timer.timeLabel;
        
        
              

        f.setLayout(new BorderLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        
        JLabel highscore = new JLabel();
        String score = "Top Score: "+hscore.loadHighScore();
        highscore.setText(score);
        //highscore.setIcon(image);
        highscore.setBorder(BorderFactory.createBevelBorder(1));
        highscore.setOpaque(true);
        //highscore.setHorizontalAlignment(JTextField.CENTER);
        //highscore.setHorizontalTextPosition(JLabel.CENTER);
        //highscore.setVerticalTextPosition(JLabel.BOTTOM);
        highscore.setForeground(Color.RED);
        highscore.setFont(new Font("MV Boli",Font.PLAIN,10));
        highscore.setBounds(80,353,100,50);
        highscore.setLayout(null);
        //highscore.setIconTextGap(-35);
        //highscore.setVerticalAlignment(JLabel.RIGHT);
        //highscore.setHorizontalAlignment(JLabel.TOP);
        //f.setLayout(null);
        //f.add(timerStartButton);
        field.setField(5,5);
        f.add(highscore);
        f.add(timerlabel);
        keyboard.setKeyboard(f);
        
        
        
        
        
        
        
    }
    
    /*public Wordle () {
    	f = new JFrame();
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
    }*/
    
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




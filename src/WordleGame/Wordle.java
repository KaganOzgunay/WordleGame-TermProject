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
    
    //static Algorithm txt = new Algorithm(f);
    Algorithm algo;
    JFrame f;
    //static Algorithm score = new Algorithm(f);


    static JButton[] buttonArray = new JButton[5];
    static String[][] stickerArr = new String[5][5];


    
    JLabel label;
    public static String titleStr;


    
    //static JFrame f2= new JFrame("Wordle2");
    static JFrame stickerFrame = new JFrame("STICKER");
    static JLabel lbl2 = new JLabel();


    JTextField t11,t12,t13,t14,t15;





    public Wordle(Algorithm algo,JFrame f){
    	this.algo = algo;
    	this.f = f;
    	//KeyBoard keyboard = new KeyBoard(algo);
        algo.wordSelector();
        Stopwatch.start();
        for(int a = 0;a<5;a++){
            for(int b = 0;b<5;b++){
                stickerArr[a][b]="[]";
            }

        }
        Stopwatch timer =new Stopwatch();
        JLabel timerlabel = timer.timeLabel;
        
        JLabel highscore = new JLabel();
        String score = "Top Score: "+algo.loadHighScore();
        highscore.setText(score);
        //highscore.setIcon(image);
        
        highscore.setBorder(BorderFactory.createBevelBorder(1));
        highscore.setOpaque(true);
        highscore.setHorizontalAlignment(JTextField.CENTER);
        highscore.setHorizontalTextPosition(JLabel.CENTER);
        highscore.setVerticalTextPosition(JLabel.BOTTOM);
        highscore.setForeground(Color.RED);
        highscore.setFont(new Font("MV Boli",Font.PLAIN,10));
        highscore.setBounds(80,353,100,50);
        //highscore.setIconTextGap(-35);
        //highscore.setVerticalAlignment(JLabel.RIGHT);
        //highscore.setHorizontalAlignment(JLabel.TOP);
        //f.setLayout(null);
        //f.add(timerStartButton);
        f.add(highscore);
        f.add(timerlabel);

        
        f.setSize(900,800);
        View page = new View(f);

        algo.setField(5,5);
        
        
        
        

        f.setLayout(new BorderLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public JFrame getframe () {
    	return f;
    }
}




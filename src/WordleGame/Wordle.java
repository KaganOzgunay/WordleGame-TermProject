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




package WordleGame;

import javax.imageio.ImageIO;
import javax.swing.*;


import javax.swing.border.LineBorder;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

    JTextField textfield;
    static JButton[] buttonArray = new JButton[5];
    static String[][] stickerArr = new String[5][5];


    KeyBoard keyboard = new KeyBoard();
    JLabel label;


    static JFrame f= new JFrame("Wordle");
    static JFrame stickerFrame = new JFrame("STICKER");
    static JLabel lbl2 = new JLabel();


    JTextField t11,t12,t13,t14,t15;

    LineBorder border = new LineBorder(Color.BLACK,2);
    LineBorder ifSameBorder = new LineBorder(Color.GREEN,2);
    LineBorder ifNotSameborder = new LineBorder(Color.YELLOW,2);



    Wordle(){

        for(int a = 0;a<5;a++){
            for(int b = 0;b<5;b++){
                stickerArr[a][b]="[]";
            }

        }
        
        f.setSize(600,800);
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

    public static void main(String[] args) {
        SwitchButton switchButton = new SwitchButton();
        f.add(switchButton);
        Stopwatch.start();
        txt.wordSelector();
        new Wordle();
        
    } }




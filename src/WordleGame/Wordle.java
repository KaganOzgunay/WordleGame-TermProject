package WordleGame;
import Confetti.ConfettiFunction;
import javax.swing.*;


import javax.swing.border.LineBorder;

import java.awt.Graphics;

import java.awt.Color;




import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Wordle{

    int counter = 0;
    static Algorithm txt = new Algorithm();
    Algorithm field = new Algorithm();

    JTextField textfield;
    static JButton[] buttonArray = new JButton[5];
    static String[][] stickerArr = new String[5][5];


    KeyBoard keyboard = new KeyBoard();
    JLabel label;


    static JFrame f= new JFrame("Wordle");
    static JFrame stickerFrame = new JFrame("STICKER");



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

        field.setField(5,5);
        f.getContentPane().setBackground(Color.BLACK);

        keyboard.setKeyboard(f);




        f.setSize(600,800);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Stopwatch.start();
        txt.wordSelector();
        new Wordle();
        
        //This starts confetti.
        ConfettiFunction confetti = new ConfettiFunction(100,100);
    } }




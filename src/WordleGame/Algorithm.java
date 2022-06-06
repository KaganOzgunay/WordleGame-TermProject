package WordleGame;

import java.awt.*;
import javax.swing.JLabel;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;


public class Algorithm  {
    public String anw = "ALPAR";
    int RoundCounter = 0;

    JFrame frame = Wordle.f;
    JButton[] buttonArray = Wordle.buttonArray;
    LineBorder border = new LineBorder(Color.BLACK,2);


    static TextField[][] fields = new TextField[6][5];










    public String getResult(int x){
        String result = "";
        for(int i=0;i<5;i++){
            //dönme aniamsyonu buraya eklenecek
            result += fields[x][i].getText().toUpperCase();
        }
        control(result,x);
        return result;
    }


    public void control(String str,int x){
        int GC = 0;
        RoundCounter++;
        String Yanw = anw;
        String Ganw = anw;
        for(int i = 0;i<5;i++){


            if(anw.charAt(i) == str.charAt(i)){
                //animasyon buaraya eklenecek **yeşil

                fields[x][i].setBackground(Color.GREEN);
                buttonArray[i].setBackground(Color.GREEN);
                Ganw = Ganw.substring(0,Ganw.indexOf(str.charAt(i))) + " " + Ganw.substring(Ganw.indexOf(str.charAt(i))+1);
                GC++;
                continue;



            }
            if(Yanw.indexOf(str.charAt(i)) >= 0){
                //animasyon buraya eklenecek **sarı
                //if(Ganw.indexOf(Yanw.charAt(i)) == -1) {
                fields[x][i].setBackground(Color.YELLOW);
                //}

                Yanw = Yanw.substring(0,Yanw.indexOf(str.charAt(i))) + " " + Yanw.substring(Yanw.indexOf(str.charAt(i))+1);

                System.out.println(Ganw.indexOf(str.charAt(i)));

            }
        }
        System.out.println(Yanw);
        System.out.println(Ganw);

        for(int i = 0; i < 5; i++){
            System.out.println(fields[x][i].getText());
            if(Ganw.indexOf(fields[x][i].getText().toUpperCase()) < 0 && fields[x][i].getBackground() == Color.YELLOW){
                fields[x][i].setBackground(Color.BLACK);
            }
            else if( fields[x][i].getBackground() == Color.YELLOW && buttonArray[i].getBackground() != Color.GREEN ){
                buttonArray[i].setBackground(Color.YELLOW);
            }
        }
        if(GC == 5){
            System.out.println("sa");
            JOptionPane.showMessageDialog(null,
                    "You found the word: " + "\"" + anw + "\"",
                    "PopUp Dialog",
                    JOptionPane.INFORMATION_MESSAGE);

        }
        if(RoundCounter==6){

            JOptionPane.showMessageDialog(null,
                    "Game Over" + "\n  " + "The word is: " + "\"" + anw + "\"",
                    "PopUp Dialog",
                    JOptionPane.INFORMATION_MESSAGE);

        }


    }


    void setField(int xLength, int yLength){

        int NUM_FIELDS_X = 0; //x number of textField
        int NUM_FIELDS_Y = 0; // y number of textField
        int tempXL;int tempYL;

        String result = "";


        tempXL = xLength;
        tempYL = yLength;






        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                // your code


                fields[x][y] = new TextField();

                fields[x][y].setColumns(10);
                fields[x][y].setText(" ");
                fields[x][y].setBounds(100 + y*25, x*25, 20, 20);
                fields[x][y].setBackground(Color.BLACK);
                fields[x][y].setForeground(Color.WHITE);



                frame.getContentPane().add(fields[x][y]);
                System.out.println(x+" "+y);


            }
        }










    }





}
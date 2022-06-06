//deneme123
//try
package WordleGame;

import java.awt.*;
import java.security.Key;
import java.util.*;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.io.*;




public class Algorithm  {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    //public static final String ANSI_GRAY = ;
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN


    static public String anw;
    public int point = 0;
    int RoundCounter = 0;
    int min = 1;int max = 12947;
    JFrame frame = Wordle.f;
    JButton[] buttonArray = Wordle.buttonArray;
    String[][] stickerArr = Wordle.stickerArr;

    Random rand = new Random();
    LineBorder border = new LineBorder(Color.BLACK,2);
//12947


    static TextField[][] fields = new TextField[6][5];
    static int dwcounter = 0;
    public void changeTheme(){
        if(dwcounter%2 == 0){

            frame.getContentPane().setBackground(Color.WHITE);
            dwcounter++;
        }
        else if(dwcounter%2==1){

            frame.getContentPane().setBackground(Color.BLACK);
            dwcounter++;
        }
    }


    public int randomNumberGenerator() {
        int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min);
        return randomInt;
    }

    public void wordSelector(){
        int randInt = 1;
        int lineCounter = 0;

        //int randInt = randomNumberGenerator();
        try
        {

            File file=new File("src/WordleGame/words.txt");    //creates a new file instance
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);

            String line;
            while((line=br.readLine()) != null)
            {

                lineCounter++;
                if(lineCounter == randInt) {

                    anw = line.toString();

                    break;
                }


            }
            fr.close();


        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean textControl(int x){
        String result = getResult(x);
        try{
            File file = new File("src/WordleGame/words.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while((line = br.readLine()) != null){


                if(line.contains(result)){

                    control(result,x);
                    return true;
                }
            }



        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }



    public String getResult(int x){
        String result = "";
        for(int i=0;i<5;i++){
            //dönme aniamsyonu buraya eklenecek
            result += fields[x][i].getText().toUpperCase();
        }
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

                point += (5-x)*50;
                buttonArray[i].setBackground(Color.GREEN);
                stickerArr[x][i] = ANSI_GREEN+"[]"+ANSI_RESET;

                Ganw = Ganw.substring(0,Ganw.indexOf(str.charAt(i))) + " " + Ganw.substring(Ganw.indexOf(str.charAt(i))+1);
                GC++;
                continue;



            }
            if(Yanw.indexOf(str.charAt(i)) >= 0){


                stickerArr[x][i] = ANSI_YELLOW+"[]"+ANSI_RESET;
                fields[x][i].setBackground(Color.YELLOW);
                point += (5-x)*25;


                Yanw = Yanw.substring(0,Yanw.indexOf(str.charAt(i))) + " " + Yanw.substring(Yanw.indexOf(str.charAt(i))+1);



            }
        }


        for(int i = 0; i < 5; i++){

            if(Ganw.indexOf(fields[x][i].getText().toUpperCase()) < 0 && fields[x][i].getBackground() == Color.YELLOW){

                stickerArr[x][i] = "[]";
                fields[x][i].setBackground(Color.BLACK);
                point -= (5-x)*25;
            }
            else if( fields[x][i].getBackground() == Color.YELLOW && buttonArray[i].getBackground() != Color.GREEN ){

                buttonArray[i].setBackground(Color.YELLOW);
            }
            else if( buttonArray[i].getBackground() != Color.YELLOW && buttonArray[i].getBackground() != Color.GREEN ){

                buttonArray[i].setBackground(Color.GRAY);
            }


        }
        if(GC == 5){
            for(int i = x+1;i<5;i++){

                point += (5-i)*50*5;
            }
            System.out.println(RoundCounter+ "/5");
            System.out.println(point);
            for(int a = 0;a<5;a++){
                for(int b = 0;b<5;b++){
                    System.out.print(stickerArr[a][b]+" ");
                }
                System.out.println();

            }



            JOptionPane.showMessageDialog(null,
                    "You found the word: " + "\"" + anw + "\"",
                    "PopUp Dialog",
                    JOptionPane.INFORMATION_MESSAGE);

        }
        if(RoundCounter==5){
            System.out.println("X/5");


            for(int a = 0;a<5;a++){
                for(int b = 0;b<5;b++){
                    System.out.print(stickerArr[a][b]+" ");
                }
                System.out.println();

            }


            JOptionPane.showMessageDialog(null,
                    "Game Over" + "\n  " + "The word is: " + "\"" + "\uD83D\uDE00" + "\"",
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



            }
        }










    }





}

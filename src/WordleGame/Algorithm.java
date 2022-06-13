package WordleGame;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.security.Key;
import java.util.*;
import java.io.*;
import javax.swing.*;

import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import static WordleGame.KeyBoard.*;


public class Algorithm  {

    Font font1 = new Font("SansSerif", Font.BOLD, 30);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    //public static final String ANSI_GRAY = ;
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static char cs;
    static boolean movebee = false;
    public String tempResult;
    static public String anw;
    public int point = 0;
    public int RoundCounter = 0;
    int min = 1;int max = 12947;
    JFrame frame;
    
    public Algorithm (JFrame f) {
    	frame = f;
    }
    
    JLabel lblHighscore;

    String[][] stickerArr = Wordle.stickerArr;

    Random rand = new Random();
    LineBorder border = new LineBorder(Color.BLACK,2);
//12947


    static TextField[][] fields = new TextField[6][5];
    // fields.setTransferHandler(new ValueImportTransferHandler()); ?????



    static int dwcounter = 0;
    public void setChar(char ch){
        cs = ch;

    }
    public void changeTheme(){
        if(dwcounter%2 == 0){
            frame.add(Wordle.lbl2);
            frame.getContentPane().setBackground(Color.BLACK);
            changeFieldColor(Color.BLACK,Color.WHITE);
            dwcounter++;
        }
        else if(dwcounter%2==1){
            frame.getContentPane().setBackground(Color.WHITE);
            changeFieldColor(Color.BLACK,Color.WHITE);
            dwcounter++;
            frame.remove(Wordle.lbl2);
        }

    }

    public void changeFieldColor(Color color,Color opColor){
        for(int x = 0;x<5;x++){
            for(int y = 0;y<5;y++){
                if(fields[x][y].getBackground() == color){
                    fields[x][y].setBackground(opColor);
                }
                    fields[x][y].setForeground(color);
            }
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

                    anw =line.toString();

                    break;
                }
            }
            System.out.println("the word is: "+ anw);
            System.out.println(loadHighScore());
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

    int roundcs = 0;
    public void control(String str,int x) throws IOException {
        //cs = 'c';

        if(row%2==0) {

            if (cs == 's') {

                if (str != null) {
                    runGame.myserver.Send(str);
                }
                roundcs++;

            }
            if (cs == 'c') {

                if (tempResult != null) {
                    for (int i = 0; i < 5; i++) {
                        fields[x][i].setText(Character.toString(tempResult.charAt(i)));
                    }


                    //str = runGame2.myclient.Process();
                }
                roundcs++;
            }
        }else {


                if (cs == 's') {

                    if (tempResult != null) {

                            for (int i = 0; i < 5; i++) {
                                fields[x][i].setText(Character.toString(tempResult.charAt(i)));



                            //str = runGame2.myclient.Process();

                        }
                            roundcs++;

                    }


                }
                if (cs == 'c') {

                    if(str != null){

                        runGame2.myclient.Send(str);
                    }
                    roundcs++;
                }
        }
        roundcs++;


        int GC = 0;
        //RoundCounter++;
        String Yanw = anw;
        String Ganw = anw;
        String bosluk = "  ";
        int[] colorsheet = new int[5];
        for(int i = 0;i<5;i++){


            if(anw.charAt(i) == str.charAt(i)){
                //animasyon buaraya eklenecek **yeşil

                //fields[x][i].setBackground(Color.GREEN);
                colorsheet[i] = 2;

                point += (5-x)*50;
                Wordle.buttonArray[i].setBackground(Color.GREEN);


                System.out.println(Wordle.buttonArray[i].getBackground());

                stickerArr[x][i] = ANSI_GREEN+"[]"+ANSI_RESET;

                Ganw = Ganw.substring(0,Ganw.indexOf(str.charAt(i))) + " " + Ganw.substring(Ganw.indexOf(str.charAt(i))+1);
                GC++;
                continue;

            }
            else if(Yanw.indexOf(str.charAt(i)) >= 0){


                stickerArr[x][i] = ANSI_YELLOW+"[]"+ANSI_RESET;
                //fields[x][i].setBackground(Color.YELLOW);
                colorsheet[i] = 1;
                point += (5-x)*25;


                Yanw = Yanw.substring(0,Yanw.indexOf(str.charAt(i))) + " " + Yanw.substring(Yanw.indexOf(str.charAt(i))+1);

            }
            else {
                //fields[x][i].setBackground(Color.GRAY);
            	colorsheet[i] = 0;
            }
        }
        movebee = true;
        View.pushsheet(colorsheet,x,GC);


        for(int i = 0; i < 5; i++){

            if(Ganw.indexOf(fields[x][i].getText().toUpperCase()) < 0 && fields[x][i].getBackground() == Color.YELLOW){

                stickerArr[x][i] = "[]";
                fields[x][i].setBackground(Color.GRAY);
                point -= (5-x)*25;
            }
            else if( fields[x][i].getBackground() == Color.YELLOW && Wordle.buttonArray[i].getBackground() != Color.GREEN ){

                Wordle.buttonArray[i].setBackground(Color.YELLOW);

            }
            else if( Wordle.buttonArray[i].getBackground() != Color.YELLOW && Wordle.buttonArray[i].getBackground() != Color.GREEN ){

                Wordle.buttonArray[i].setBackground(Color.GRAY);
                fields[x][i].setBackground(Color.GRAY);

            }
        }


        if(GC == 5){
            end = true;
            Stopwatch.stop();
            for(int i = x+1;i<5;i++){

                point += (5-i)*50*5;
            }
            System.out.println(row+1+ "/5");
            System.out.println("your point is: "+point);
            for(int a = 0;a<5;a++){
                for(int b = 0;b<5;b++){
                    System.out.print(stickerArr[a][b]+" ");
                }
                System.out.println();

            }


            saveHighScore();

            /*
            JOptionPane.showMessageDialog(null,
                    "You found the word: " + "\"" + anw + "\"",
                    "PopUp Dialog",
                    JOptionPane.INFORMATION_MESSAGE);*/

        }

        if(row+1==5 && end == false){
            end = true;
            Stopwatch.stop();
            System.out.println("X/5");
            point = 0;

            for(int a = 0;a<5;a++){
                for(int b = 0;b<5;b++){
                    System.out.print(stickerArr[a][b]+" ");
                }
                System.out.println();
            }
            saveHighScore();
            JOptionPane.showMessageDialog(null,
                    "Game Over" + "\n  " + "The word is: " + "\"" + "\uD83D\uDE00" + "\"",
                    "PopUp Dialog",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        tempResult = "";
    }

    class TextLimit extends PlainDocument {
    	private int limit;
    	  TextLimit(int limit) {
    	    super();
    	    this.limit = limit;
    	  }

    	  TextLimit(int limit, boolean upper) {
    	    super();
    	    this.limit = limit;
    	  }

    	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    	    if (str == null)
    	      return;

    	    if ((getLength() + str.length()) <= limit) {
    	      super.insertString(offset, str, attr);
    	    }
    	  }
    }

    void setField(int xLength, int yLength){

        int NUM_FIELDS_X = 0; //x number of textField
        int NUM_FIELDS_Y = 0; // y number of textField
        int tempXL;int tempYL;

        String result = "";


        tempXL = xLength;
        tempYL = yLength;



        JLabel label = new JLabel();


        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x < xLength; x++) {
                // your code

                fields[y][x] = new TextField();
                fields[y][x].setFont(font1);
                //fields[x][y].set
                fields[y][x].setColumns(1);
                label.setTransferHandler(new ValueImportTransferHandler());
                fields[y][x].setText(label.getText());
                //fields[y][x].setDocument(new TextLimit(1));
                fields[y][x].setBounds((frame.getWidth()-260)/2 + x*55, (frame.getHeight()-260)/6 + y*55, 50, 50);
                fields[y][x].setBackground(Color.WHITE);
                fields[y][x].setForeground(Color.BLACK);

                frame.getContentPane().add(fields[y][x]);
            }
        }
    }
    
    public static class ValueImportTransferHandler extends TransferHandler {

        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

        public ValueImportTransferHandler() {
        }

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            boolean accept = false;
            if (canImport(support)) {
                try {
                    Transferable t = support.getTransferable();
                    Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
                    if (value instanceof String) {
                        Component component = support.getComponent();
                        if (component instanceof JLabel) {
                            ((JLabel) component).setText(value.toString());
                            accept = true;
                        }
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            return accept;
        }
    }



    
    void saveHighScore(){
	    BufferedWriter bw = null;
	    boolean newscore=false;
	    String score=loadHighScore();
	    int number = 0;
        try{
            number = Integer.parseInt(score);

        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }


	    try {
	    	if(number<point) {
	        bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/WordleGame/highscore.txt", false)); //append - set to fals
	        System.out.println("New highscore!!");
	        bw.write("" + point);
	        bw.flush();
	        bw.close();
	    	}
	    	else {
	    		System.out.println("You could not pass the highscore.");
	    	}
	    }
	    catch (IOException e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "There was an error while saving the score", JOptionPane.ERROR_MESSAGE);
	    }


    }
    String loadHighScore(){
        BufferedReader br = null;
            String line = "";
            try {
                br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/WordleGame/highscore.txt"));
                line = br.readLine();
                br.close();
            } catch (IOException e) {
                line = "0";
            }
            return line;
        }
}
	

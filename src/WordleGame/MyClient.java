package WordleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static java.awt.SystemColor.text;

public class MyClient {
    KeyBoard kb = new KeyBoard();
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    Algorithm algo = new Algorithm();
    private Socket myClient;
    private String srv;
   public void Process() throws IOException {
       processConn();
   }
    public void Send(String result){
       algo.RoundCounter++;
        System.out.println(algo.RoundCounter+" : round");
       send(result);


    }
    public MyClient(String  info){

        srv = info;

    }



    public void runClient() {


        try {

            algo.setChar('c');
            new Wordle();


            connToS();
            streams();
            processConn();

        } catch (EOFException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void connToS() throws IOException{

        myClient = new Socket(InetAddress.getByName(srv),12345);

    }

    private void streams() throws IOException{
        oos = new ObjectOutputStream(myClient.getOutputStream());
        oos.flush();

        ois = new ObjectInputStream(myClient.getInputStream());
        Stopwatch.start();
    }
    boolean tf = true;
    private void processConn() throws IOException {


        String temp = "";
        JButton[] arr = new JButton[5];

        int x = 0;
        do {
            try {

                if((temp = (String)ois.readObject()) != null){
                    algo.tempResult = temp;
                    algo.randInt = (int) ois.readObject();
                    System.out.println(algo.randInt);
                    if(tf){
                        algo.wordSelector();
                        tf = false;
                    }

                    Wordle.buttonArray = (JButton[]) ois.readObject();

                    System.out.println("keyboard color: ");
                    for(int i = 0;i<5;i++){
                        System.out.print(Wordle.buttonArray[i].getText() + " : " + Wordle.buttonArray[i].getBackground() + " - ");
                    }

                    algo.control(algo.tempResult,kb.row);
                    kb.enabledButton = true;
                    kb.row++;

                }


                algo.RoundCounter++;


            } catch (ClassNotFoundException e) {


            }

        } while (!temp.equals("S:ExitTheSystem"));

    }

    private void closeConn(){



        try{
            oos.close();
            ois.close();
            myClient.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void send(String text){
        try{

            oos.writeObject(text);
            oos.writeObject(Wordle.buttonArray);
            oos.flush();
            kb.enabledButton = false;



        }
        catch(IOException e){

        }

    }




}



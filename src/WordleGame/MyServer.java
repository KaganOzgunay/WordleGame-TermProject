package WordleGame;

import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer  {


    Algorithm algo = new Algorithm();
    KeyBoard kb = new KeyBoard();
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    ServerSocket server;
    private Socket conn;
    public void Process() throws IOException {
        processConn();
    }
    public void Send(String result){
        algo.RoundCounter++;
        System.out.println(algo.RoundCounter+" : round");
        send(result);

    }


    public void runServer() {
        try {
            server = new ServerSocket(12345, 100);

            while (true){
                try {
                    algo.setChar('s');
                    if(kb.row == 0){
                        kb.enabledButton = true;
                    }




                    waitConn();
                    new Wordle();
                    streams();
                    processConn();


                } catch (EOFException e) {

                }
                finally{
                    closeConn();
                }



            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void waitConn() throws IOException{

        conn = server.accept();

    }

    private void streams() throws IOException{
        oos = new ObjectOutputStream(conn.getOutputStream());
        oos.flush();

        ois = new ObjectInputStream(conn.getInputStream());
        kb.enabledButton = true;
        Stopwatch.start();

    }

    private void processConn() throws IOException {


        String temp = "";
        JButton[] arr = new JButton[5];

        int x = 0;
        do {
            try {
                if((temp = (String)ois.readObject()) != null){
                    algo.tempResult = temp;
                    Wordle.buttonArray = (JButton[]) ois.readObject();



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
            conn.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void send(String text){
        try{

            oos.writeObject(text);
            System.out.println(algo.randInt);
            oos.writeObject(algo.randInt);
            oos.writeObject(Wordle.buttonArray);
            oos.flush();
            kb.enabledButton = false;

        }
        catch(IOException e){

        }

    }




}



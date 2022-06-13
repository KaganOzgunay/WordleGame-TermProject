package WordleGame;

import javax.swing.JFrame;

public class runGame {
	static JFrame f= new JFrame("Player_1");
	
    static Algorithm algo = new Algorithm(f);
    static Wordle wordle1 = new Wordle(algo,f);
    public static MyServer myserver = new MyServer(algo,f);
    
    

    public runGame () {
        algo.setChar('s');
        myserver.runServer();
    }


    

}

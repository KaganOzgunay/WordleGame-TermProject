package WordleGame;

import javax.swing.JFrame;

public class runGame2 {
	
	static JFrame f2= new JFrame("Player_2");
	
    static Algorithm algo2 = new Algorithm(f2);
    static Wordle wordle2 = new Wordle(algo2,f2);
    public static MyClient myclient = new MyClient("127.0.0.1",algo2,f2);
    
    
    
    public runGame2 () {
        algo2.setChar('c');
        myclient.runClient();
    }
}

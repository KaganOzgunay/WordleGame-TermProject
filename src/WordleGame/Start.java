package WordleGame;

import javax.swing.JFrame;

public class Start {
	static JFrame f= new JFrame("Wordle");
	
	static Algorithm algo = new Algorithm(Start.f);
    static Wordle wordle1 = new Wordle(algo,Start.f);
    
	public static void main(String[] args) {
		
		//runGame gamer1 = new runGame();
	
		runGame2 gamer2 = new runGame2();
		
	}
}

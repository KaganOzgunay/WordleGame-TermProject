package WordleGame;

import javax.swing.JFrame;

public class runGame2 {
	
    public static MyClient myclient = new MyClient("127.0.0.1",Start.algo,Start.f);
    
    
    
    public runGame2 () {
        Start.algo.setChar('c');
        myclient.runClient();
    }
}

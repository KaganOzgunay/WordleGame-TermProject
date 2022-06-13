package WordleGame;

import javax.swing.JFrame;

public class runGame {
	
	
    
    public static MyServer myserver = new MyServer(Start.algo,Start.f);
    
    

    public runGame () {
        Start.algo.setChar('s');
        myserver.runServer();
    }


    

}

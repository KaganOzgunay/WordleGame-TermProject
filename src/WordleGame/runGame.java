package WordleGame;

public class runGame {
    static Algorithm algo = new Algorithm();
    public static MyServer myserver = new MyServer();

    public static void main(String[] args) throws InterruptedException {
        algo.setChar('s');
        myserver.runServer();




    }

}

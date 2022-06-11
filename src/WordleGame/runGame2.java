package WordleGame;

public class runGame2 {
    static Algorithm algo = new Algorithm();
    public static MyClient myclient = new MyClient("127.0.0.1");
    public static void main(String[] args){
        algo.setChar('c');
        myclient.runClient();
    }
}

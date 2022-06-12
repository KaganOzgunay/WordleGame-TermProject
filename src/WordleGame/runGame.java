package WordleGame;

public class runGame {
    static Algorithm algo = new Algorithm();
    public static int tempRandInt;
    public static MyServer myserver = new MyServer();

    public static void main(String[] args) throws InterruptedException {
        algo.randInt = algo.randomNumberGenerator();
        tempRandInt = algo.randInt;
        System.out.println(algo.randInt);
        algo.setChar('s');
        myserver.runServer();


    }

}

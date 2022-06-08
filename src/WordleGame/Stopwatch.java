
package WordleGame;


import javax.swing.Timer;


public class Stopwatch{
    static int elapsedTime = 0;
    static int seconds = 0;
    static int minutes = 0;
    boolean started = false;
    static String seconds_string;
    static String minutes_string;
    static Timer timer;





    public static void start() {
        timer.start();
    }

    public static void stop() {
        timer.stop();
        System.out.println(minutes_string + " : " + seconds_string);
    }

    void reset() {
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);

    }

    static {
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        timer = new Timer(1000, (e) -> {
            elapsedTime += 1000;
            minutes = elapsedTime / '\uea60' % 60;
            seconds = elapsedTime / 1000 % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);

        });
    }
}




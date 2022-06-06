package WordleGame;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

public class stopwatch {

    public static void main(String[] args) {



    }


}
// ***************************************************



class Stopwatch implements ActionListener {

    static JFrame frame = new JFrame();
    static JButton startButton = new JButton("START");
    static JButton resetButton = new JButton("RESET");
    static JLabel timeLabel = new JLabel();
    static int elapsedTime = 0;
    static int seconds =0;
    static int minutes =0;

    boolean started = false;
    static String seconds_string = String.format("%02d", seconds);
    static String minutes_string = String.format("%02d", minutes);


    static Timer timer = new Timer(1000, e -> {

        elapsedTime=elapsedTime+1000;

        minutes = (elapsedTime/60000) % 60;
        seconds = (elapsedTime/1000) % 60;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);

        timeLabel.setText(minutes_string+":"+seconds_string);

    });


    Stopwatch(){

        timeLabel.setText(minutes_string+":"+seconds_string);
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100,200,100,50);
        startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==startButton) {

            if(!started) {
                started=true;
                startButton.setText("STOP");
                start();
            }
            else {
                started=false;
                startButton.setText("START");
                stop();
            }

        }
        if(e.getSource()==resetButton) {
            started=false;
            startButton.setText("START");
            reset();
        }

    }

    static void start() {
        timer.start();
    }

    static void stop() {
        timer.stop();
        System.out.println(minutes_string+" : "+seconds_string);
    }

    void reset() {
        timer.stop();
        elapsedTime=0;
        seconds =0;
        minutes=0;

        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        timeLabel.setText(minutes_string+":"+seconds_string);
    }

}

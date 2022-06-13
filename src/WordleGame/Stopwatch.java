



package WordleGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Stopwatch {
	
	static JLabel timeLabel = new JLabel();
    static int elapsedTime = 0;
    static int seconds = 0;
    static int minutes = 0;
    static int hours = 0;
    boolean started = false;
    //static String seconds_string;
    //static String minutes_string;
    static Timer timer;
    static String seconds_string = String.format("%02d", seconds);
    static String minutes_string = String.format("%02d", minutes);
    static String hours_string = String.format("%02d", hours);
    JButton startButton = new JButton();
    
    
    
    

    Stopwatch(){
    	
    	timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
    	timeLabel.setBounds(3,3,100,50);
    	timeLabel.setFont(new Font("MV Boli",Font.PLAIN,16));
    	//timeLabel.setBorder(BorderFactory.createBevelBorder(1));
    	timeLabel.setOpaque(true);
    	timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setHorizontalTextPosition(JLabel.CENTER);
        timeLabel.setVerticalTextPosition(JLabel.BOTTOM);
        timeLabel.setForeground(Color.RED);
        //timeLabel.setBackground(Color.WHITE);
    	
    	//startButton.setBounds(50, 200, 100, 50);
    	//startButton.setFont(new Font("INK Free",Font.PLAIN,20));
    	//startButton.setFocusable(false);
    	//startButton.addActionListener(this);
    	timer.start();
    	
    }

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
     	    timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);

        });
    }

	
}





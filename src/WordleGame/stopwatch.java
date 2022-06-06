
package WordleGame;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

class Stopwatch implements ActionListener {
    static JFrame frame = new JFrame();
    static JButton startButton = new JButton("START");
    static JButton resetButton = new JButton("RESET");
    static JLabel timeLabel = new JLabel();
    static int elapsedTime = 0;
    static int seconds = 0;
    static int minutes = 0;
    boolean started = false;
    static String seconds_string;
    static String minutes_string;
    static Timer timer;

    public Stopwatch() {
        timeLabel.setText(minutes_string + ":" + seconds_string);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", 0, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(0);
        startButton.setBounds(100, 200, 100, 50);
        startButton.setFont(new Font("Ink Free", 0, 20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Ink Free", 0, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(3);
        frame.setSize(420, 420);
        frame.setLayout((LayoutManager)null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            if (!this.started) {
                this.started = true;
                startButton.setText("STOP");
                start();
            } else {
                this.started = false;
                startButton.setText("START");
                stop();
            }
        }

        if (e.getSource() == resetButton) {
            this.started = false;
            startButton.setText("START");
            this.reset();
        }

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
        timeLabel.setText(minutes_string + ":" + seconds_string);
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
            timeLabel.setText(minutes_string + ":" + seconds_string);
        });
    }
}

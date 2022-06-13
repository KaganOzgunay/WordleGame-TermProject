package Confetti;

import WordleGame.Wordle;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//import WordleGame.Wordle;

public class ConfettiFunction extends JPanel implements ActionListener {
    public int c_rectangles, c_triangles;
    JFrame jf;
    Timer tm = new Timer(20, this);
    static int height = 800, width = 600;
    Dimension size;
    boolean onoff;
    public static ArrayList<Particle> shapes = new ArrayList<Particle>();

    public ConfettiFunction(int c_rectangles, int c_triangles) {
        this.c_rectangles = c_rectangles;
        this.c_triangles = c_triangles;
        jf = Wordle.getframe();
        tm.start();
        //JFrame jf = new JFrame();
        //JPanel jp = new JPanel();
        //jp.setPreferredSize(new Dimension(600,600));
        //jf.getContentPane().add( jp );
        //jf.pack();
        //jf.setResizable(false);
        //jf.setTitle("Confetti");
        //jf.setLayout(new BorderLayout());
        jf.add(this);
        jf.setVisible(true);
        //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        size = jf.getBounds().getSize();
        height = size.height;
        width = size.width;
        onoff = true;
    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setColor(Color.BLACK);
        //g2d.fillRect(0, 0, width, height);


        for (int i = 0; i < shapes.size(); i++) {
            g2d.setColor(shapes.get(i).color);
            if (shapes.get(i) instanceof Triangle) {
                g2d.rotate(Math.toRadians(shapes.get(i).angle), shapes.get(i).x, shapes.get(i).y);
                g2d.fillPolygon(((Triangle) shapes.get(i)).getXarray(), ((Triangle) shapes.get(i)).getYarray(), 3);
                g2d.rotate(Math.toRadians(-shapes.get(i).angle), shapes.get(i).x, shapes.get(i).y);
            } else {
                g2d.rotate(Math.toRadians(shapes.get(i).angle), shapes.get(i).x + ((Rectangle) shapes.get(i)).width / 2, shapes.get(i).y + ((Rectangle) shapes.get(i)).height / 2);
                g2d.fillRect((int) shapes.get(i).x, (int) shapes.get(i).y, (int) ((Rectangle) shapes.get(i)).width, (int) ((Rectangle) shapes.get(i)).height);
                g2d.rotate(Math.toRadians(-shapes.get(i).angle), shapes.get(i).x + ((Rectangle) shapes.get(i)).width / 2, shapes.get(i).y + ((Rectangle) shapes.get(i)).height / 2);
            }
        }
    }


    public void actionPerformed(ActionEvent e) {
        size = jf.getBounds().getSize();
        height = size.height;
        width = size.width;
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) instanceof Rectangle) {
                ((Rectangle) shapes.get(i)).move();
                if (((Rectangle) shapes.get(i)).height <= 0 || ((Rectangle) shapes.get(i)).width <= 0) {
                    shapes.remove(i);
                    i--;
                    continue;
                }
            } else {
                ((Triangle) shapes.get(i)).move();
                if (((Triangle) shapes.get(i)).getXarray()[1] >= ((Triangle) shapes.get(i)).getXarray()[2]) {
                    shapes.remove(i);
                    i--;
                    continue;
                }
            }
        }
        if (onoff) {
            onoff = false;
            Random rand = new Random();
            for (int i = 0; i < 1; i++) {
                shapes.add(new Rectangle(0, height, 30.0, 30.0, rand.nextDouble() * (width / 120 - 0.5 + 1) + 0.5, rand.nextDouble() * (height / 30 - 10 + 1) + 10, -rand.nextInt(10) + 3, height));
                shapes.add(new Rectangle(width - 30, height, 30.0, 30.0, -(rand.nextDouble() * (width / 120 - 0.5 + 1) + 0.5), rand.nextDouble() * (height / 30 - 10 + 1) + 10, rand.nextInt(10) + 3, height));
            }
            for (int i = 0; i < 1; i++) {
                double[] aa = {width, width - 15, width + 15};
                double[] bb = {height, height + 15 * Math.sqrt(3), height + 15 * Math.sqrt(3)};
                shapes.add(new Triangle(aa, bb, -(rand.nextDouble() * (width / 150 - 1 + 1) + 1), rand.nextDouble() * (height / 35 - 10 + 1) + 10, -rand.nextInt(10) + 3, height));
                double[] aa2 = {0, -15, 15};
                double[] bb2 = {height, height + 15 * Math.sqrt(3), height + 15 * Math.sqrt(3)};
                shapes.add(new Triangle(aa2, bb2, rand.nextDouble() * (width / 150 - 1 + 1) + 1, rand.nextDouble() * (height / 35 - 10 + 1) + 10, rand.nextInt(10) + 3, height));
            }
        } else {
            onoff = true;
        }
        repaint();
    }
}

package WordleGame;
import javax.swing.*;


import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu implements ActionListener{
	
	//static JFrame f= new JFrame("Wordle");
    int c = 0;
    static JFrame menuframe = new JFrame("MENU");

    JLabel title = new JLabel("🆆🅾🆁🅳🅻🅴");
    JButton btn1 = new JButton("Single-Player");
    JButton btn2 = new JButton("Multi-Player");
    JButton btn3 = new JButton("Player_1");
    JButton btn4 = new JButton("Player_2");
    public menu() {
        menuframe.setVisible(true);

        menuframe.setSize(900,800);
        menuframe.setLayout(null);
        menuframe.getContentPane().setBackground( Color.DARK_GRAY );
        menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title.setFont(new Font("TimesRoman", Font.PLAIN, 128));
        title.setBounds(50, 0, 800, 200);
        menuframe.add(title);

        btn1.setBounds(50,400,800,100);
        btn2.setBounds(50,550,800,100);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        menuframe.add(btn1);
        menuframe.add(btn2);

        btn3.setBounds(50,550,375,150);
        btn4.setBounds(475,550,375,150);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if(e.getSource() == btn1){
        	menuframe.remove(btn1);
        	menuframe.remove(btn2);
        	menuframe.remove(title);
        	menuframe.getContentPane().setBackground( null );
        	menuframe.getContentPane().repaint();
        	Algorithm.randInt = Algorithm.randomNumberGenerator();
        	KeyBoard.enabledButton = true;
            Wordle singlegame = new Wordle(menuframe);
        }
        else if(e.getSource() == btn2){
        	menuframe.remove(btn1);
        	menuframe.remove(btn2);
        	menuframe.getContentPane().repaint();
        	
        	menuframe.add(btn3);
        	menuframe.add(btn4);
        }
        else if (e.getSource() == btn3) {
        	Algorithm.multitf = true;
        	menuframe.remove(btn3);
        	menuframe.remove(btn4);
        	menuframe.remove(title);
        	menuframe.getContentPane().setBackground( null );
        	menuframe.getContentPane().repaint();
        	runGame gamer_one = new runGame();
			try {
				gamer_one.main(null);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
        }
        else if (e.getSource() == btn4) {
        	Algorithm.multitf = true;
        	System.out.println("wtfaaaa");
        	menuframe.remove(btn3);
        	menuframe.remove(btn4);
        	menuframe.remove(title);
        	menuframe.getContentPane().setBackground( null );
        	menuframe.getContentPane().repaint();
        	runGame2 gamer_two = new runGame2();
        	gamer_two.main(null);
        }
    }
    public static void main(String[] args){
        new menu();
    }
}

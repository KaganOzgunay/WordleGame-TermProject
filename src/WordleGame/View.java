package WordleGame;

//import src/Confetti/ConfettiFunction.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import static WordleGame.Algorithm.fields;

public class View extends JPanel implements ActionListener {
	JFrame jf;
	Timer tm = new Timer(5,this);
	Dimension size;
	int height,width;
	
	BufferedImage background = null;
	BufferedImage bee = null;
	
	static JLabel lbl;
	
	static double locxofbee = 0;
	boolean viewchanged = false;
	
	static int[] colorsheet;
	static int csrow;
	int csrowi = 0;
	
	static boolean wincase = false;
	
	public View () {
		jf = Wordle.getframe();
		tm.start();
		size = jf.getBounds().getSize();
		height = size.height;
		width = size.width;
		
		lbl = new JLabel();

        Wordle.lbl2.setBounds(0, 0, width, height);
        try {
			background = ImageIO.read(this.getClass().getResource("../Images/background.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        Image bg = background.getScaledInstance(Wordle.lbl2.getWidth(), Wordle.lbl2.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon bgimage = new ImageIcon(bg);
        Wordle.lbl2.setIcon(bgimage);

		//Wordle.lbl3.setBounds(0, 0, width, height);
		try {
			background = ImageIO.read(this.getClass().getResource("../Images/background.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image bg = background.getScaledInstance(Wordle.lbl3.getWidth(), Wordle.lbl3.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon bgimage = new ImageIcon(bg);
		Wordle.lbl2.setIcon(bgimage);
        
        
        
        lbl.setBounds((width-260)/2+(int)locxofbee, (height-260)/6 - 50, 50, 50);
        try {
			bee = ImageIO.read(this.getClass().getResource("../Images/bee.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        Image dimg = bee.getScaledInstance(lbl.getWidth(), lbl.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon imgicon = new ImageIcon(dimg);
        lbl.setIcon(imgicon);
        jf.add(lbl);
	}
	
	public void paintbee(int a) {
		if (colorsheet[a] == 2) {
			fields[csrow][a].setBackground(Color.GREEN);
		}
		if (colorsheet[a] == 1) {
			fields[csrow][a].setBackground(Color.YELLOW);
		}
	}
	public static void pushsheet (int[] cs,int x,int gc) {
		locxofbee = -50;
		colorsheet = cs;
		csrow = x;
		if (gc==5) {
			wincase = true;
		}
	}
	

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		size = jf.getBounds().getSize();
		if (size.height < 750 || size.width < 450) {
			jf.setSize(600,800);
		}
		if (height != size.height || width != size.width || viewchanged) {
			viewchanged = false;
			height = size.height;
			width = size.width;
			
			Wordle.lbl2.setBounds(0, 0, width, height);
			Image bg = background.getScaledInstance(Wordle.lbl2.getWidth(), Wordle.lbl2.getHeight(),Image.SCALE_SMOOTH);
	        ImageIcon bgimage = new ImageIcon(bg);
	        Wordle.lbl2.setIcon(bgimage);
	        
	        lbl.setBounds((width-260)/2+(int)locxofbee, (height-260)/6 - 50, 50, 50);
	        Image dimg = bee.getScaledInstance(lbl.getWidth(), lbl.getHeight(),Image.SCALE_SMOOTH);
	        ImageIcon imgicon = new ImageIcon(dimg);
	        lbl.setIcon(imgicon);
			
			for (int y = 0; y < 5; y++) {
	            for (int x = 0; x < 5; x++) {
	            	fields[y][x].setLocation((width-260)/2 + x*55, (height-260)/6 + y*55);
	            }
	        }
			
			int xb = 0;
			KeyBoard.q.setBounds((width-(width/15*10+width/12))/2,height/16*8,width/15,height/16);
			xb++;
			KeyBoard.w.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
			xb++;
			KeyBoard.e.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
			xb++;
			KeyBoard.r.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
			xb++;
			KeyBoard.t.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
			xb++;
			KeyBoard.y.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
			xb++;
			KeyBoard.u.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
			xb++;
			KeyBoard.i.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
			xb++;
			KeyBoard.o.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
			xb++;
			KeyBoard.p.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
			xb++;
			KeyBoard.dw.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/12,height/16);
			xb=0;
			
			
			KeyBoard.a.setBounds((width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
			xb++;
			KeyBoard.s.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
			xb++;
			KeyBoard.d.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
			xb++;
			KeyBoard.f.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
			xb++;
			KeyBoard.g.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
			xb++;
			KeyBoard.h.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
			xb++;
			KeyBoard.j.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
			xb++;
			KeyBoard.k.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
			xb++;
			KeyBoard.l.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
			xb++;
			KeyBoard.backspace.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/60*7,height/16);
			xb=0;
			
			KeyBoard.z.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
			xb++;
			KeyBoard.x.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
			xb++;
			KeyBoard.c.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
			xb++;
			KeyBoard.v.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
			xb++;
			KeyBoard.b.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
			xb++;
			KeyBoard.n.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
			xb++;
			KeyBoard.m.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
			xb++;
			KeyBoard.enter.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/60*7,height/16);
			
		}
		if (Algorithm.movebee) {
			if (locxofbee > 225 && csrowi == 4) {
				paintbee(csrowi);
				csrowi++;
				Algorithm.movebee=false;
				csrowi = 0;
			}
			else if (locxofbee > 170 && csrowi == 3) {
				paintbee(csrowi);
				csrowi++;
			}
			else if (locxofbee > 115 && csrowi == 2) {
				paintbee(csrowi);
				csrowi++;
			}
			else if (locxofbee > 60 && csrowi == 1) {
				paintbee(csrowi);
				csrowi++;
			}
			else if (locxofbee > 5 && csrowi == 0) {
				paintbee(csrowi);
				csrowi++;
			}
			
			viewchanged = true;
			locxofbee += 10;
			if (wincase&&!Algorithm.movebee) {
//				Confetti.ConfettiFunction confetti = new Confetti.ConfettiFunction(100,100);
			}
		}
	}
}

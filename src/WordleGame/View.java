package WordleGame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class View extends JPanel implements ActionListener {
	JFrame jf;
	Timer tm = new Timer(20,this);
	Dimension size;
	int height,width;
	
	public View () {
		jf = Wordle.getframe();
		tm.start();
		size = jf.getBounds().getSize();
		height = size.height;
		width = size.width;
	}
	
	

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		size = jf.getBounds().getSize();
		if (height != size.height || width != size.width) {
			height = size.height;
			width = size.width;
		}
	}
}

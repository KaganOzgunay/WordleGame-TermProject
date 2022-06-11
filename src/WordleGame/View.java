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
	Timer tm = new Timer(5,this);
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
		if (size.height < 750 || size.width < 450) {
			jf.setSize(600,800);
		}
		if (height != size.height || width != size.width) {
			height = size.height;
			width = size.width;
			
			for (int y = 0; y < 5; y++) {
	            for (int x = 0; x < 5; x++) {
	            	Algorithm.fields[y][x].setLocation((width-260)/2 + x*55, (height-260)/6 + y*55);
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
	}
}
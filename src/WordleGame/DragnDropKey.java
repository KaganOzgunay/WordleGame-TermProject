package WordleGame;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.border.Border;

//import WordleGame.KeyBoard.ValueExportTransferHandler;

/*class RoundBtn implements Border
{
    private int r;
    RoundBtn(int r) {
        this.r = r;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.r+1, this.r+1, this.r+2, this.r);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y,
                            int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, r, r);
    }
}*/
public class DragnDropKey extends TransferHandler implements ActionListener {
	
	//static Drag_n_Drop

    JButton[] buttonArray = Wordle.buttonArray;
    public static boolean end = false;
    Algorithm txt = new Algorithm();
    RoundBtn rounded = new RoundBtn(15);
    static JButton q,w,e,r,t,y,u,o,p,a,s,d,f,g,h,j,k,l,i,z,x,c,v,b,n,m,enter,backspace,dw;

    JTextField result;


    public void setKeyboard(JFrame frame){

        int[] arr = new int[1];
        int xa = 30;
        int xb = 0;
        
        int width = frame.getWidth();
        int height = frame.getHeight();

        q = new JButton("Q");
        q.setBounds((width-(width/15*10+width/12))/2,height/16*8,width/15,height/16);
        //q.setBorder(rounded);
        //q.setOpaque(true);
        q.setTransferHandler(new ValueExportTransferHandler("Q"));
        q.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //q.addActionListener(this);
        frame.add(q);
        xb++;
        w = new JButton("W");
        w.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
        //w.setBorder(rounded);
        //w.setOpaque(true);
        w.setTransferHandler(new ValueExportTransferHandler("W"));
        w.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //w.addActionListener(this);
        frame.add(w);
        xb++;
        e = new JButton("E");
        e.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
        //e.setBorder(rounded);
        //e.setOpaque(true);
        e.setTransferHandler(new ValueExportTransferHandler("E"));
        e.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //e.addActionListener(this);
        frame.add(e);
        xb++;
        r = new JButton("R");
        r.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
        //r.setBorder(rounded);
        //r.setOpaque(true);
        r.setTransferHandler(new ValueExportTransferHandler("R"));
        r.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //r.addActionListener(this);
        frame.add(r);
        xb++;
        t = new JButton("T");
        t.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
        //t.setBorder(rounded);
        //t.setOpaque(true);
        t.setTransferHandler(new ValueExportTransferHandler("T"));
        t.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //t.addActionListener(this);
        frame.add(t);
        xb++;
        y = new JButton("Y");
        y.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
        //r.setBorder(rounded);
        //y.setOpaque(true);
        y.setTransferHandler(new ValueExportTransferHandler("Y"));
        y.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //y.addActionListener(this);
        frame.add(y);
        xb++;
        u = new JButton("U");
        u.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
        //r.setBorder(rounded);
        //u.setOpaque(true);
        u.setTransferHandler(new ValueExportTransferHandler("U"));
        u.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //u.addActionListener(this);
        frame.add(u);
        xb++;
        i = new JButton("I");
        i.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
        //r.setBorder(rounded);
        //i.setOpaque(true);
        i.setTransferHandler(new ValueExportTransferHandler("I"));
        i.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //i.addActionListener(this);
        frame.add(i);
        xb++;
        o = new JButton("O");
        o.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
        //r.setBorder(rounded);
        //o.setOpaque(true);
        o.setTransferHandler(new ValueExportTransferHandler("O"));
        o.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //o.addActionListener(this);
        frame.add(o);
        xb++;
        p = new JButton("P");
        p.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/15,height/16);
        //r.setBorder(rounded);
        //p.setOpaque(true);
        p.setTransferHandler(new ValueExportTransferHandler("P"));
        p.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //p.addActionListener(this);
        frame.add(p);
        xb++;
        dw = new JButton("DW");
        dw.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2, height/16*8,width/12,height/16);
        dw.addActionListener(this);
        frame.add(dw);
        xb=0;
        xa=50;
        a = new JButton("A");
        a.setBounds((width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
        //r.setBorder(rounded);
        //a.setOpaque(true);
        a.setTransferHandler(new ValueExportTransferHandler("A"));
        a.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //a.addActionListener(this);
        frame.add(a);
        xb++;
        s = new JButton("S");
        s.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
        //r.setBorder(rounded);
        //s.setOpaque(true);
        s.setTransferHandler(new ValueExportTransferHandler("S"));
        s.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //s.addActionListener(this);
        frame.add(s);
        xb++;
        d = new JButton("D");
        d.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
        //r.setBorder(rounded);
        //d.setOpaque(true);
        d.setTransferHandler(new ValueExportTransferHandler("D"));
        d.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //d.addActionListener(this);
        frame.add(d);
        xb++;
        f = new JButton("F");
        f.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
        //r.setBorder(rounded);
        //f.setOpaque(true);
        f.setTransferHandler(new ValueExportTransferHandler("F"));
        f.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //f.addActionListener(this);
        frame.add(f);
        xb++;
        g = new JButton("G");
        g.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
        //r.setBorder(rounded);
        //g.setOpaque(true);
        g.setTransferHandler(new ValueExportTransferHandler("G"));
        g.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //g.addActionListener(this);
        frame.add(g);
        xb++;
        h = new JButton("H");
        h.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
        //r.setBorder(rounded);
        //h.setOpaque(true);
        h.setTransferHandler(new ValueExportTransferHandler("H"));
        h.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //h.addActionListener(this);
        frame.add(h);
        xb++;
        j = new JButton("J");
        j.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
        //r.setBorder(rounded);
        //j.setOpaque(true);
        j.setTransferHandler(new ValueExportTransferHandler("J"));
        j.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //j.addActionListener(this);
        frame.add(j);
        xb++;
        k = new JButton("K");
        k.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
        //r.setBorder(rounded);
        //k.setOpaque(true);
        k.setTransferHandler(new ValueExportTransferHandler("K"));
        k.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //k.addActionListener(this);
        frame.add(k);
        xb++;
        l = new JButton("L");
        l.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/15,height/16);
        //r.setBorder(rounded);
        //l.setOpaque(true);
        l.setTransferHandler(new ValueExportTransferHandler("L"));
        l.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //l.addActionListener(this);
        frame.add(l);
        xb++;
      //backspace button
        backspace = new JButton("UNDO");
        backspace.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/30, height/16*9,width/60*7,height/16);
        backspace.addActionListener(this);
        frame.add(backspace);
        xb=0;
        xa=90;
        z = new JButton("Z");
        z.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
        //r.setBorder(rounded);
        //z.setOpaque(true);
        z.setTransferHandler(new ValueExportTransferHandler("Z"));
        z.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //z.addActionListener(this);
        frame.add(z);
        xb++;
        x = new JButton("X");
        x.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
        //r.setBorder(rounded);
        //x.setOpaque(true);
        x.setTransferHandler(new ValueExportTransferHandler("X"));
        x.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //x.addActionListener(this);
        frame.add(x);
        xb++;
        c = new JButton("C");
        c.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
        //r.setBorder(rounded);
        //c.setOpaque(true);
        c.setTransferHandler(new ValueExportTransferHandler("C"));
        c.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //c.addActionListener(this);
        frame.add(c);
        xb++;
        v = new JButton("V");
        v.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
        //r.setBorder(rounded);
        //v.setOpaque(true);
        v.setTransferHandler(new ValueExportTransferHandler("V"));
        v.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //v.addActionListener(this);
        frame.add(v);
        xb++;
        b = new JButton("B");
        b.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
        //r.setBorder(rounded);
        //b.setOpaque(true);
        b.setTransferHandler(new ValueExportTransferHandler("B"));
        b.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //b.addActionListener(this);
        frame.add(b);
        xb++;
        n = new JButton("N");
        n.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
        //r.setBorder(rounded);
        //n.setOpaque(true);
        n.setTransferHandler(new ValueExportTransferHandler("N"));
        n.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //n.addActionListener(this);
        frame.add(n);
        xb++;
        m = new JButton("M");
        m.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/15,height/16);
        //r.setBorder(rounded);
        //m.setOpaque(true);
        m.setTransferHandler(new ValueExportTransferHandler("M"));
        m.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent m) {
        		JButton button = (JButton) m.getSource();
        		TransferHandler handle = button.getTransferHandler();
        		handle.exportAsDrag(button, m, TransferHandler.COPY);
        	}
        });
        //m.addActionListener(this);
        frame.add(m);
        xb++;
      //enter button
        enter = new JButton("ENTER");
        enter.setBounds((width/15)*xb+(width-(width/15*10+width/12))/2+width/10, height/16*10,width/60*7,height/16);
        enter.addActionListener(this);
        frame.add(enter);
        
        
    }
    public static class ValueExportTransferHandler extends TransferHandler {

        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
        private String value;

        public ValueExportTransferHandler(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return DnDConstants.ACTION_COPY_OR_MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            Transferable t = new StringSelection(getValue());
            return t;
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            super.exportDone(source, data, action);
            // Bıraktıktan sonra karar verme.
        }

    }

    
    int col = 0;
    int row = 0;
    int counter = 0;
    int buttonCounter = 0;

    public void actionPerformed(ActionEvent ae) {
        if(!(end)){
            if(ae.getSource()==enter && counter <5 && col == 5) {

                if(!(txt.textControl(counter))){

                }else{
                    counter++;
                    row++;
                    col = 0;
                    buttonCounter = 0;
                }
            }
            if(ae.getSource()==dw) {

                txt.changeTheme();
            }
            if(ae.getSource() == backspace && counter>=0){
                if(col != 0){
                    buttonCounter--;
                    col--;
                }
                txt.fields[row][col].setText(" ");
                buttonArray[buttonCounter] = null;
            }
            
            if(ae.getSource() == q){
                if(col<5){
                    txt.fields[row][col].setText(q.getText());

                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = q;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == w){
                if(col<5){
                    txt.fields[row][col].setText(w.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = w;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == e){
                if(col<5){
                    txt.fields[row][col].setText(e.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = e;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == r){
                if(col<5){
                    txt.fields[row][col].setText(r.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = r;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == t){
                if(col<5){
                    txt.fields[row][col].setText(t.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = t;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == y){
                if(col<5){
                    txt.fields[row][col].setText(y.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = y;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == u){
                if(col<5){
                    txt.fields[row][col].setText(u.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = u;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == o){
                if(col<5){
                    txt.fields[row][col].setText(o.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = o;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == p){
                if(col<5){
                    txt.fields[row][col].setText(p.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = p;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == a){
                if(col<5){
                    txt.fields[row][col].setText(a.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = a;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == s){
                if(col<5){
                    txt.fields[row][col].setText(s.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = s;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == d){
                if(col<5){
                    txt.fields[row][col].setText(d.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = d;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == f){
                if(col<5){
                    txt.fields[row][col].setText(f.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = f;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == g){
                if(col<5){
                    txt.fields[row][col].setText(g.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = g;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == h){
                if(col<5){
                    txt.fields[row][col].setText(h.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = h;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == j){
                if(col<5){
                    txt.fields[row][col].setText(j.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = j;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == k){
                if(col<5){
                    txt.fields[row][col].setText(k.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = k;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == l){
                if(col<5){
                    txt.fields[row][col].setText(l.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = l;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == i){
                if(col<5){
                    txt.fields[row][col].setText(i.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = i;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == z){
                if(col<5){
                    txt.fields[row][col].setText(z.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = z;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == x){
                if(col<5){
                    txt.fields[row][col].setText(x.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = x;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == c){
                if(col<5){
                    txt.fields[row][col].setText(c.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = c;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == v){
                if(col<5){
                    txt.fields[row][col].setText(v.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = v;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == b){
                if(col<5){
                    txt.fields[row][col].setText(b.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = b;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == n){
                if(col<5){
                    txt.fields[row][col].setText(n.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = n;
                    buttonCounter++;
                }
            }
            else if(ae.getSource() == m){
                if(col<5){
                    txt.fields[row][col].setText(m.getText());
                    //txt.fields[row][col].set;
                    col++;
                    buttonArray[buttonCounter] = m;
                    buttonCounter++;
                }
            }
            
        }
        
    }
    public static class ValueImportTransferHandler extends TransferHandler {

        public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

        public ValueImportTransferHandler() {
        }

        @Override
        public boolean canImport(TransferHandler.TransferSupport support) {
            return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport support) {
            boolean accept = false;
            if (canImport(support)) {
                try {
                    Transferable t = support.getTransferable();
                    Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
                    if (value instanceof String) {
                        Component component = support.getComponent();
                        if (component instanceof JLabel) {
                            ((JLabel) component).setText(value.toString());
                            accept = true;
                        }
                    }
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
            return accept;
        }
    }
}

package WordleGame;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RoundBtn implements Border
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
}



public class KeyBoard implements ActionListener {

    JButton[] buttonArray = Wordle.buttonArray;
    public static boolean end = false;
    Algorithm txt = new Algorithm();
    RoundBtn rounded = new RoundBtn(15);
    JButton q,w,e,r,t,y,u,o,p,a,s,d,f,g,h,j,k,l,i,z,x,c,v,b,n,m,enter,backspace,dw;

    JTextField result;


    public void setKeyboard(JFrame frame){

        int[] arr = new int[1];
        int xa = 30;
        int xb = 0;

        q = new JButton("Q");
        q.setBounds(30,350,40,50);
        //q.setBorder(rounded);
        //q.setOpaque(true);
        q.addActionListener(this);
        frame.add(q);
        xb++;
        w = new JButton("W");
        w.setBounds(xa+xb*40,350,40,50);
        //w.setBorder(rounded);
        //w.setOpaque(true);
        w.addActionListener(this);
        frame.add(w);
        xb++;
        e = new JButton("E");
        e.setBounds(xa+xb*40,350,40,50);
        //e.setBorder(rounded);
        //e.setOpaque(true);
        e.addActionListener(this);
        frame.add(e);
        xb++;
        r = new JButton("R");
        r.setBounds(xa+xb*40,350,40,50);
        //r.setBorder(rounded);
        //r.setOpaque(true);
        r.addActionListener(this);
        frame.add(r);
        xb++;
        t = new JButton("T");
        t.setBounds(xa+xb*40,350,40,50);
        //t.setBorder(rounded);
        //t.setOpaque(true);
        t.addActionListener(this);
        frame.add(t);
        xb++;
        y = new JButton("Y");
        y.setBounds(xa+xb*40,350,40,50);
        //r.setBorder(rounded);
        //y.setOpaque(true);
        y.addActionListener(this);
        frame.add(y);
        xb++;
        u = new JButton("U");
        u.setBounds(xa+xb*40,350,40,50);
        //r.setBorder(rounded);
        //u.setOpaque(true);
        u.addActionListener(this);
        frame.add(u);
        xb++;
        i = new JButton("I");
        i.setBounds(xa+xb*40,350,40,50);
        //r.setBorder(rounded);
        //i.setOpaque(true);
        i.addActionListener(this);
        frame.add(i);
        xb++;
        o = new JButton("O");
        o.setBounds(xa+xb*40,350,40,50);
        //r.setBorder(rounded);
        //o.setOpaque(true);
        o.addActionListener(this);
        frame.add(o);
        xb++;
        p = new JButton("P");
        p.setBounds(xa+xb*40,350,40,50);
        //r.setBorder(rounded);
        //p.setOpaque(true);
        p.addActionListener(this);
        frame.add(p);
        xb++;
        dw = new JButton("DW");
        dw.setBounds(xa+xb*40,350,50,50);
        dw.addActionListener(this);
        frame.add(dw);
        xb=0;
        xa=50;
        a = new JButton("A");
        a.setBounds(xa+xb*40,400,40,50);
        //r.setBorder(rounded);
        //a.setOpaque(true);
        a.addActionListener(this);
        frame.add(a);
        xb++;
        s = new JButton("S");
        s.setBounds(xa+xb*40,400,40,50);
        //r.setBorder(rounded);
        //s.setOpaque(true);
        s.addActionListener(this);
        frame.add(s);
        xb++;
        d = new JButton("D");
        d.setBounds(xa+xb*40,400,40,50);
        //r.setBorder(rounded);
        //d.setOpaque(true);
        d.addActionListener(this);
        frame.add(d);
        xb++;
        f = new JButton("F");
        f.setBounds(xa+xb*40,400,40,50);
        //r.setBorder(rounded);
        //f.setOpaque(true);
        f.addActionListener(this);
        frame.add(f);
        xb++;
        g = new JButton("G");
        g.setBounds(xa+xb*40,400,40,50);
        //r.setBorder(rounded);
        //g.setOpaque(true);
        g.addActionListener(this);
        frame.add(g);
        xb++;
        h = new JButton("H");
        h.setBounds(xa+xb*40,400,40,50);
        //r.setBorder(rounded);
        //h.setOpaque(true);
        h.addActionListener(this);
        frame.add(h);
        xb++;
        j = new JButton("J");
        j.setBounds(xa+xb*40,400,40,50);
        //r.setBorder(rounded);
        //j.setOpaque(true);
        j.addActionListener(this);
        frame.add(j);
        xb++;
        k = new JButton("K");
        k.setBounds(xa+xb*40,400,40,50);
        //r.setBorder(rounded);
        //k.setOpaque(true);
        k.addActionListener(this);
        frame.add(k);
        xb++;
        l = new JButton("L");
        l.setBounds(xa+xb*40,400,40,50);
        //r.setBorder(rounded);
        //l.setOpaque(true);
        l.addActionListener(this);
        frame.add(l);
        xb++;
      //backspace button
        backspace = new JButton("UNDO");
        backspace.setBounds(xa+xb*40,400,70,50);
        backspace.addActionListener(this);
        frame.add(backspace);
        xb=0;
        xa=90;
        z = new JButton("Z");
        z.setBounds(xa+xb*40,450,40,50);
        //r.setBorder(rounded);
        //z.setOpaque(true);
        z.addActionListener(this);
        frame.add(z);
        xb++;
        x = new JButton("X");
        x.setBounds(xa+xb*40,450,40,50);
        //r.setBorder(rounded);
        //x.setOpaque(true);
        x.addActionListener(this);
        frame.add(x);
        xb++;
        c = new JButton("C");
        c.setBounds(xa+xb*40,450,40,50);
        //r.setBorder(rounded);
        //c.setOpaque(true);
        c.addActionListener(this);
        frame.add(c);
        xb++;
        v = new JButton("V");
        v.setBounds(xa+xb*40,450,40,50);
        //r.setBorder(rounded);
        //v.setOpaque(true);
        v.addActionListener(this);
        frame.add(v);
        xb++;
        b = new JButton("B");
        b.setBounds(xa+xb*40,450,40,50);
        //r.setBorder(rounded);
        //b.setOpaque(true);
        b.addActionListener(this);
        frame.add(b);
        xb++;
        n = new JButton("N");
        n.setBounds(xa+xb*40,450,40,50);
        //r.setBorder(rounded);
        //n.setOpaque(true);
        n.addActionListener(this);
        frame.add(n);
        xb++;
        m = new JButton("M");
        m.setBounds(xa+xb*40,450,40,50);
        //r.setBorder(rounded);
        //m.setOpaque(true);
        m.addActionListener(this);
        frame.add(m);
        xb++;
      //enter button
        enter = new JButton("ENTER");
        enter.setBounds(xa+xb*40,450,70,50);
        enter.addActionListener(this);
        frame.add(enter);
      
        


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



}

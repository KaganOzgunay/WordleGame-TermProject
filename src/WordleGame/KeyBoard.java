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

    Algorithm txt = new Algorithm();
    RoundBtn rounded = new RoundBtn(15);
    JButton q,w,e,r,t,y,u,o,p,a,s,d,f,g,h,j,k,l,i,z,x,c,v,b,n,m,enter,backspace,dw;

    JTextField result;


    public void setKeyboard(JFrame frame){

        int[] arr = new int[1];
        int xa = 30;
        int xb = 0;

        dw = new JButton("DW");
        dw.setBounds(300,20,50,50);
        dw.addActionListener(this);
        frame.add(dw);

        //enter button
        enter = new JButton("ENTER");
        enter.setBounds(30,200,50,50);
        enter.addActionListener(this);
        frame.add(enter);

        //backspace button
        backspace = new JButton();
        backspace.setBounds(130,200,100,50);
        backspace.addActionListener(this);
        frame.add(backspace);


        q = new JButton("Q");

        q.setBounds(xa+xb*5+xb*50,350,40,50);
        //q.setBorder(rounded);
        q.addActionListener(this);
        frame.add(q);
        xb++;
        w = new JButton("W");
        w.setBounds(xa+xb*5+xb*50,350,20,30);
        //w.setBorder(rounded);
        w.addActionListener(this);
        frame.add(w);
        xb++;
        e = new JButton("E");
        e.setBounds(xa+xb*5+xb*50,350,40,50);
        //e.setBorder(rounded);
        e.addActionListener(this);
        frame.add(e);
        xb++;
        r = new JButton("R");
        r.setBounds(xa+xb*5+xb*50,350,40,50);
        //r.setBorder(rounded);
        r.addActionListener(this);
        frame.add(r);
        xb++;
        t = new JButton("T");
        t.setBounds(xa+xb*5+xb*50,350,40,50);
        //t.setBorder(rounded);
        t.addActionListener(this);
        frame.add(t);



    }
    int col = 0;
    int row = 0;
    int counter = 0;
    int buttonCounter = 0;
    public void actionPerformed(ActionEvent ae) {

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


    }



}

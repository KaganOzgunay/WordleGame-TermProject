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
    JButton q,w,e,r,t,y,u,o,p,a,s,d,f,g,h,j,k,l,i,z,x,c,v,b,n,m,enter;

    JTextField result;


    public void setKeyboard(JFrame frame){
int[] arr = new int[1];

        result = new JTextField();
        result.setBounds(50, 250, 120, 20);
        frame.add(result);

        q = new JButton("Q");

        //q.setText();
        q.setBounds(30,350,24,48);
        q.setBorder(rounded);
        q.addActionListener(this);
        frame.add(q);

        a = new JButton("A");
        a.setBounds(60,350,24,48);
        a.setBorder(rounded);
        a.addActionListener(this);
        frame.add(a);

        //enter button
        enter = new JButton("ENTER");
        enter.setBounds(50,200,50,50);
        enter.addActionListener(this);
        frame.add(enter);

    }
    int col = 0;
    int row = 0;
    int counter = 0;
    int buttonCounter = 0;
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==enter && counter <6 && col == 5) {


            result.setText(txt.getResult(counter));

            counter++;
            row++;
            col = 0;
            buttonCounter = 0;


        }

        if(e.getSource() == q){
            if(col<5){
                txt.fields[row][col].setText(q.getText());
                //txt.fields[row][col].set;
                col++;
                buttonArray[buttonCounter] = q;
                buttonCounter++;

            }

        }
        else if(e.getSource() == a){
            if(col<5){
                txt.fields[row][col].setText(a.getText());
                //txt.fields[row][col].set;
                col++;
                buttonArray[buttonCounter] = a;
                buttonCounter++;

            }

        }


    }



}
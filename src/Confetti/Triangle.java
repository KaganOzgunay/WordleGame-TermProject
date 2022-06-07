package Confetti;

import java.awt.Color;

public class Triangle extends Particle {
	private double[] x,y;
	public Triangle (double[] x,double[]y,double velX,double velY,double rotate_vel,int screen_height) {
		super.x = (x[0] + x[1] + x[2])/3;
		super.y = (y[0] + y[1] + y[2])/3;
		this.x = x;
		this.y = y;
		super.velX = velX;
		super.velY = velY;
		super.c_red = 128;
		super.c_green = 255;
		super.c_blue = 0;
		super.color = new Color(c_red,c_green,c_blue);
		super.fadedir = true;
		super.angle = 0; 
		super.rotate_vel = rotate_vel;
		super.screen_height = screen_height;
	}
	public void move() {
		melt();
		if (super.y >= super.screen_height && super.velY < 0) {
			super.velY = -3*super.velY/4;
			super.velX = 5*super.velX/6; 
			for (int i = 0 ; i<3 ; i++) {
				this.y[i] -= super.y-super.screen_height;
			}
			super.y = super.screen_height;
		}
		super.x += super.velX;
		super.y -= super.velY;
		for (int i = 0 ; i<3 ; i++) {
			this.x[i] += super.velX;
			this.y[i] -= super.velY;
		}
		super.velY -= 0.4;
		super.rotate();
		super.fadecolor();
	}
	private void melt() {
		if (x[1] < x[2]) {
			this.x[1] += 0.1;
			this.y[1] -= 0.1*Math.sqrt(3)/2; 
			this.x[2] -= 0.1;
			this.y[2] -= 0.1*Math.sqrt(3)/2; 
			this.y[0] += 0.1*Math.sqrt(3)/2;
		}
	}
	public int[] getXarray () {
		int[] xcopy = new int[3];
		for (int i = 0;i<3;i++) {
			xcopy[i] = (int)this.x[i];
		}
		return xcopy;
	}
	public int[] getYarray () {
		int[] ycopy = new int[3];
		for (int i = 0;i<3;i++) {
			ycopy[i] = (int)this.y[i];
		}
		return ycopy;
	}
}


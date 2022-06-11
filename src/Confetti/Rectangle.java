package Confetti;

import java.awt.Color;

public class Rectangle extends Particle {
	public double height,width;
	static double gravity = 0.4; 
	
	public Rectangle (int x,int y,double height,double width,double velX,double velY,double rotate_vel,int screen_height) {
		super.x = x;
		super.y = y;
		super.velX = velX;
		super.velY = velY;
		this.height = height;
		this.width = width;
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
		if (super.y >= screen_height-height && super.velY < 0) {
			super.velY = -3*super.velY/4;
			super.velX = 5*super.velX/6;
			super.y = screen_height-height;
		}
		if (super.y < 0 && super.velY > 0) {
			super.velY = -super.velY;
			super.y = 0;
		}
		super.x += super.velX;
		super.y -= super.velY;
		super.velY -= gravity;
		super.rotate();
		super.fadecolor();
	}
	private void melt() {
		height -= 0.2;
		width -= 0.2;
		if (height > 0 && width > 0) {
			super.x += 0.1;
			super.y += 0.1;
		}
	}
}


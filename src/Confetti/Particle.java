package Confetti;

import java.awt.Color;

abstract public class Particle {
	
	public double x,y,velX,velY;
	public Color color;
	public int c_red,c_green,c_blue;
	public boolean fadedir;
	public double angle,rotate_vel;
	public int screen_height;
	
	public void fadecolor () {
		if (fadedir) {
			c_red += 3;
			c_green -= 3;
		}
		else {
			c_red -= 3;
			c_green += 3;
		}
		color = new Color(c_red,c_green,Math.abs((int)y%256));
		
		if (c_red == 254) {
			fadedir = false;
		} 
		else if (c_red == 128) {
			fadedir = true;
		}
	}
	
	public void rotate() {
		angle += rotate_vel;
	}

}


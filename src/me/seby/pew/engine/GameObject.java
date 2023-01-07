package me.seby.pew.engine;

import java.awt.Rectangle;

public class GameObject {
	
	public double x1, y1;
	
	public GameObject(double x, double y){
		x1=x;
		y1=y;
	}
	
	public Rectangle getArie(int latime,int inaltime){
		return new Rectangle((int)x1,(int)y1,latime,inaltime);
	}

}

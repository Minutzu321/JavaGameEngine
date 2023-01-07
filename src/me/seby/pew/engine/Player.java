package me.seby.pew.engine;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Rectangle;

import me.seby.pew.entitati.EntityA;
import me.seby.pew.util.Animation;
import me.seby.pew.util.Location;
import me.seby.pew.util.Texturi;

public class Player extends GameObject implements EntityA{
	
	
	
	Animation anim;
	private Location loc;
	
	public Player(double x, double y,Texturi tex){
		super(x,y);	
		anim = new Animation(5, tex.player[0],tex.player[1],tex.player[2]);
		loc=new Location((int)x1,(int)y1);
	}
	
	public void tick(){
		x1=MouseInfo.getPointerInfo().getLocation().getX()-424;
		y1=MouseInfo.getPointerInfo().getLocation().getY()-230;
		
		if(x1 <= 0){
			x1=0;
		}
		if(x1 >=640-17){
			x1=640-17-5;
		}
		
		if(y1 <= 0){
			y1=0;
		}
		if(y1 >=480-32){
			y1=480-32-5;
		}
		
		anim.runAnimation();
		loc.setX((int)x1);
		loc.setY((int)y1);
	}
	
	public void render(Graphics g){
		anim.drawAnimation(g, x1, y1, 0);
	}

	public Rectangle getArie(){
		return new Rectangle((int)x1,(int)y1,32,32);
	}
	
	public Location getLoc() {
		return loc;
	}

}

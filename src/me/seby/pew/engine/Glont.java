package me.seby.pew.engine;

import java.awt.Graphics;
import java.awt.Rectangle;

import me.seby.pew.Game;
import me.seby.pew.entitati.EntityA;
import me.seby.pew.util.Animation;
import me.seby.pew.util.Location;
import me.seby.pew.util.Texturi;

public class Glont extends GameObject implements EntityA{
	

	private Game gam;
	Animation anim;
	private Location loc;
	
	public Glont(double x, double y,Game g,Texturi tex){
		super(x,y);
		gam=g;
		anim = new Animation(1, tex.glont[0],tex.glont[1],tex.glont[2]);
		loc=new Location((int)x1,(int)y1);
	}
	
	public void tick(){
		y1 -= 10;
		
		
		if(y1 <= 0){
			gam.getControl().remEntity(this);
		}
		
		anim.runAnimation();
		loc.setX((int)x1);
		loc.setY((int)y1);
	}
	
	public void render(Graphics g){
		anim.drawAnimation(g, x1, y1, 0);
	}

	public Location getLoc() {
		return loc;
	}

	public Rectangle getArie(){
		return new Rectangle((int)x1,(int)y1,32,32);
	}


}

package me.seby.pew.engine;

import java.awt.Graphics;

import me.seby.pew.Game;
import me.seby.pew.util.Animation;
import me.seby.pew.util.Texturi;

public class Explozie {
	
	private Animation anim;
	private Game ga;
	
	private double x1;
	private double y1;
	private int ipl=0;
	private int viteza=15;
	private int count=0;
	
	
	public Explozie(double x, double y,Texturi tex,Game g){
		x1=x;
		y1=y;
		anim = new Animation(4, tex.explozie[0],tex.explozie[1],tex.explozie[2]);
		viteza=15;
		count=0;
		ipl=0;
		ga=g;
	}
	
	public void tick(){

		if(!(count==3)){
		anim.runAnimation();
		ipl = ipl +1;
		if(ipl > viteza){
			count = count+1;
		}
		}else{
			ga.getControl().remExpl(this);
		}
	
	}
	
	
	public void render(Graphics g){
		anim.drawAnimation(g, x1, y1, 0);
		
	}

}

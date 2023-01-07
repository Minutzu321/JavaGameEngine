package me.seby.pew.engine;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import me.seby.pew.Game;
import me.seby.pew.entitati.EntityB;
import me.seby.pew.util.Animation;
import me.seby.pew.util.Location;
import me.seby.pew.util.Texturi;

public class Inamic extends GameObject implements EntityB{
	
	
	Random r = new Random();
	private int viteza = r.nextInt(3)+1;

	Animation anim;
	private Game gam;
	private BufferedImage[] ina;
	private Location loc;
	
	public Inamic(double x, double y,Texturi tex,Game g){
		super(x,y);
		gam=g;
		ina=tex.getInam();
		anim = new Animation(10, ina[0],ina[1],ina[2]);
		loc=new Location((int)x1,(int)y1);
	}
	
	public void tick(){

		y1+=viteza;
		
		if(y1 > Game.INALTIME*Game.SCALA){
		gam.getControl().remEntity(this);
			Game.VIATA=Game.VIATA-10;
			gam.setKinamici(gam.getKinamici() + 1);
		}
		
		if(Fizici.colid(this, gam.ea)){
			gam.getControl().createExpl(x1, y1);
			gam.getControl().remEntity(this);
			gam.setKinamici(gam.getKinamici()+1);

	}
		
		anim.runAnimation();
		loc.setX((int)x1);
		loc.setY((int)y1);
	}
	
	public Rectangle getArie(){
		return new Rectangle((int)x1,(int)y1,32,32);
	}
	
	public void render(Graphics g){
		anim.drawAnimation(g, x1, y1, 0);
	}
	
	
	public Location getLoc() {
		return loc;
	}


}

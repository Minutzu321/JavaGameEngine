package me.minutz.vreme;

import java.awt.Color;
import java.awt.Graphics;

import eng.Game;
import eng.obj.Obiect;
import eng.obj.ObjT;

public class EfectLuminos extends Obiect{
	
	int r=255,g=255,b=255,m=10,i;
	private Color culoare;

	public EfectLuminos(Color c, int i) {
		super(0, 0, "EfectLuminos", ObjT.EFECT);
		culoare = c;
		this.i=i;
		if(i==1) {
			m=15;
		}
		if(i==2) {
			m=14;
		}
	}

	@Override
	public void tick() {
		if(r>culoare.getRed()) {
			r-=m;
		}
		if(r<culoare.getRed()) {
			r=culoare.getRed();
		}
		
		if(g>culoare.getGreen()) {
			g-=m;
		}
		if(g<culoare.getGreen()) {
			g=culoare.getGreen();
		}
		
		if(b>culoare.getBlue()) {
			b-=m;
		}
		if(b<culoare.getBlue()) {
			b=culoare.getBlue();
		}
		if(i==0) {
			Game.bgc=new Color(r,g,b);
		}else if(i==1) {
			Maine.nori1c=new Color(r,g,b);
		}else if(i==2) {
			Maine.nori2c=new Color(r,g,b);
		}
		if(r == culoare.getRed() && g == culoare.getGreen() && b == culoare.getBlue()) {
			Game.getHndl().remObj(this);
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		
	}

}

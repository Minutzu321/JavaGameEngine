package me.minutz.vreme;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import eng.Game;
import eng.etc.MathUtils;
import eng.obj.Obiect;
import eng.obj.ObjT;

public class Fulger extends Obiect{

	float stroke = 6;
	
	private List<Linie> linii = new ArrayList<Linie>();
	
	public Fulger(int x, int y) {
		super(x, y, "FULGER", ObjT.FULGER);
		fulger(x,y,0);
		Game.getHndl().addObj(new EfectLuminos(Game.bgc,0));
		Game.getHndl().addObj(new EfectLuminos(Maine.nori1c,1));
		Game.getHndl().addObj(new EfectLuminos(Maine.nori2c,2));
	}

	@Override
	public void tick() {
		Linie l = linii.get(linii.size()-1);
		fulger(l.x2,l.y2,0);
		if(l.y2>Game.INALTIME+2000) {
			Game.getHndl().remObj(this);
			Game.getHndl().addObj(new Fulger(MathUtils.random(100, Game.LATIME-100),y));
		}
	}
	
	public void fulger(int x, int y, int n) {
		if(n>1) {
			return;
		}
		int a = MathUtils.random(-30, 30);
		int tx=x+a,ty=y+40;
		linii.add(new Linie(x, y, tx, ty));
		fulger(tx,ty,n+1);
	}

	@Override
	public void render(Graphics g) {
		Color cl = new Color(255,255,150);
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(stroke));
		g2.setColor(cl);
		for(Linie l : linii) {
			g2.drawLine(l.x1, l.y1, l.x2, l.y2);
		}
	}
	
	
	class Linie {
		public int x1,y1,x2,y2;
		public Linie(int x1,int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
	}
}

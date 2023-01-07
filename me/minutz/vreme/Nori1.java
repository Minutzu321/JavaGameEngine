package me.minutz.vreme;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import eng.Game;
import eng.obj.Obiect;
import eng.obj.ObjT;

public class Nori1 extends Obiect{
	
	int w=400,h=150;
	List<Point> pcte = new ArrayList<Point>();
	
	public Nori1() {
		super(0, 0, "NORI1", ObjT.NORI);
		pcte.add(new Point(-300,-100));
		pcte.add(new Point(-50,-100));
		pcte.add(new Point(200,-100));
		pcte.add(new Point(450,-100));
		pcte.add(new Point(700,-100));
	}
	
	@Override
	public void tick() {
		for(Point p : pcte) {
			p.x += 1;
			if(p.x>Game.LATIME) {
				p.x=-550;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Maine.nori1c);
		for(Point p : pcte) {
			g.fillOval(p.x, p.y, w, h);
		}
	}

}

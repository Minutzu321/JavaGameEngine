package me.minutz.vreme;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import eng.Game;
import eng.etc.MathUtils;
import eng.obj.Obiect;
import eng.obj.ObjT;

public class Picatura extends Obiect{
	
	private int current_size = 2;

	public Picatura(int x, int y) {
		super(x, y, "Pic", ObjT.PICATURA);
	}


	@Override
	public void tick() {
		y+=current_size+7;
		if(y>Game.INALTIME) {
			x=MathUtils.random(0, Game.LATIME);
			y=MathUtils.random(-200, 0);
		}
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke());
//		g.setColor(new Color(Maine.ploae.getRed(),Maine.ploae.getGreen(),Maine.ploae.getBlue(),50));
//		g.fillOval(x, y-2, current_size-2, current_size-10+20);
		g.setColor(new Color(Maine.ploae.getRed(),Maine.ploae.getGreen(),Maine.ploae.getBlue(),100));
		g.fillOval(x, y-1, current_size-1, current_size-5+20);
		g.setColor(new Color(Maine.ploae.getRed(),Maine.ploae.getGreen(),Maine.ploae.getBlue(),200));
		g.fillOval(x, y, current_size, current_size+15);
	}

}

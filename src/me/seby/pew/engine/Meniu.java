package me.seby.pew.engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import me.seby.pew.Game;

public class Meniu {
	
	public Rectangle joaca = new Rectangle(Game.LATIME/2+100,140,120,50);
	public Rectangle iesi = new Rectangle(Game.LATIME/2+110,250,100,50);
	
	public void render(Graphics g){
		Font font = new Font("arial",Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.WHITE);
		
		String s = "SPACE GAME";
	    FontMetrics fm = g.getFontMetrics();
	    int sw = fm.stringWidth(s);
		g.drawString(s, (Game.LATIME*Game.SCALA - sw) / 2, 100);
		par(g);
	}
	
	public void par(Graphics g){
		Font font = new Font("arial",Font.BOLD,20);
		g.setFont(font);
		g.setColor(Color.CYAN);
		
	    FontMetrics fm = g.getFontMetrics();
	    int psw = fm.stringWidth("CODED BY MINA");
		g.drawString("CODED BY MINA", (Game.LATIME*Game.SCALA - psw) / 2, 120);

		Font font1 = new Font("arial",Font.BOLD,30);
		g.setFont(font1);
		g.setColor(Color.white);
		g.drawString("JOACA", joaca.x+6, joaca.y+35);
		g.drawString("IESI", iesi.x+25,iesi.y+36);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.draw(joaca);
	    g2d.draw(iesi);
	}
	


}

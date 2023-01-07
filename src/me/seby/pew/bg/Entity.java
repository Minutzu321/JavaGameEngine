package me.seby.pew.bg;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface Entity {

	public void tick();
	public void render(Graphics g);
	public Rectangle getArie();
	
	public double getX();
	public double getY();
}

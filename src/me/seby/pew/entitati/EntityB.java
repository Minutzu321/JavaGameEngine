package me.seby.pew.entitati;

import java.awt.Graphics;
import java.awt.Rectangle;

import me.seby.pew.util.Location;

public interface EntityB {

	public void tick();
	public void render(Graphics g);
	public Rectangle getArie();
	
	public Location getLoc();
}

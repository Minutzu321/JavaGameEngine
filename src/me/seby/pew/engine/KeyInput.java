package me.seby.pew.engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import me.seby.pew.Game;

public class KeyInput extends KeyAdapter{
	
	Game game;
	
	public KeyInput(Game g){
		game=g;
	}

	public void keyPressed(KeyEvent e){
		game.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){
		game.keyReleased(e);
	}
	
}

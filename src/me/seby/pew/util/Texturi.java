package me.seby.pew.util;

import java.awt.image.BufferedImage;
import java.util.Random;

import me.seby.pew.Game;

public class Texturi {
	
	public BufferedImage[] player = new BufferedImage[3];
	public BufferedImage[] glont = new BufferedImage[3];
	public BufferedImage[] inamic = new BufferedImage[3];
	public BufferedImage[] explozie = new BufferedImage[3];
	public BufferedImage[] inamic2 = new BufferedImage[3];
	
	private SpriteSheet sps;
	
	public Texturi(Game game){
		SpriteSheet ss = new SpriteSheet(game.getSpriteSheet());
		sps=ss;
		
		loadtexturi();
	}
	
	public BufferedImage[] getInam(){
		Random r = new Random();
		int s = r.nextInt(2);
		if(s==0){
			return inamic;
		}
		if(s==1){
			return inamic2;
		}
		return inamic2;
	}
	
	public void loadtexturi(){
		player[0] = sps.getImg(1, 1, 32, 32);
		player[1] = sps.getImg(1, 2, 32, 32);
		player[2] = sps.getImg(1, 3, 32, 32);
		
		glont[0] = sps.getImg(2, 1, 32, 32);
		glont[1] = sps.getImg(2, 2, 32, 32);
		glont[2] = sps.getImg(2, 3, 32, 32);
		
		inamic[0] = sps.getImg(3, 1, 32, 32);
		inamic[1] = sps.getImg(3, 2, 32, 32);
		inamic[2] = sps.getImg(3, 3, 32, 32);
		
		explozie[0] = sps.getImg(4, 1, 32, 32);
		explozie[1] = sps.getImg(4, 2, 32, 32);
		explozie[2] = sps.getImg(4, 3, 32, 32);
		
		inamic2[0] = sps.getImg(5, 1, 32, 32);
		inamic2[1] = sps.getImg(5, 2, 32, 32);
		inamic2[2] = sps.getImg(5, 3, 32, 32);
		
	}

}

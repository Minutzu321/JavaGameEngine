package me.seby.pew.util;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage imag;
	
	public SpriteSheet(BufferedImage img){
		imag=img;
	}
	
	public BufferedImage getImg(int col,int rand,int w, int h){
		BufferedImage img = imag.getSubimage((col*32)-32, (rand * 32)-32, w, h);
		return img;
	}

}

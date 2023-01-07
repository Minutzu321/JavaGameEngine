package me.minutz.vreme;

import java.awt.Color;

import eng.Game;
import eng.HWindow;
import eng.etc.MathUtils;

public class Maine {
	
	public static Color nori1c = new Color(67, 67, 77),
						nori2c = new Color(76, 77, 87),
						ploae = new Color(100,100,150);
	public static HWindow window;

	public static void main(String[] args) throws InterruptedException {
		window = new HWindow(750 ,670,"Vreme",new Game());
		
		Thread.sleep(120);
		
		Game.getHndl().addObj(new Nori1());
		for(int i=0;i<100;i++) {
			Game.getHndl().addObj(new Picatura(MathUtils.random(0, Game.LATIME), MathUtils.random(-200, Game.INALTIME)));
		}
		Game.getHndl().addObj(new Fulger(200,0));
		Game.getHndl().addObj(new Nori2());
		
		
	}
	
}

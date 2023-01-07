package me.seby.pew.engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import me.seby.pew.Game;

public class MouseInput implements MouseListener{


	public void mouseClicked(MouseEvent arg0) {

		
	}


	public void mouseEntered(MouseEvent arg0) {

		
	}


	public void mouseExited(MouseEvent arg0) {

		
	}


	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mx >= Game.LATIME/2 +100 && mx <= Game.LATIME/2 + 220){
			if(my >=140 &&  my<=190){
				Game.stat=Game.State.JOC;
			}
		}
		
		if(mx >= Game.LATIME/2 +110 && mx <= Game.LATIME/2 + 210){
			if(my >=250 &&  my<=300){
				System.exit(1);
			}
		}
		
	}


	public void mouseReleased(MouseEvent arg0) {

		
	}

}

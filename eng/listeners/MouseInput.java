package eng.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import eng.Game;
import eng.handler.Handler;
import eng.obj.Obiect;

public class MouseInput implements MouseListener{
	
	private Handler h;
	
	public static boolean pressing = false;
	
	public MouseInput(Handler ha){
		System.out.println("MOUSELISTENER LOADED!");
		h=ha;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getButton() == 1) {
			if(pressing) {
				pressing=false;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(arg0.getButton() == 1) {
			if(pressing) {
				pressing=true;
			}
		}
		for(Obiect o:Game.getHndl().onbj){
//			if(o.getTip()==ObjT.Buton){
//				Buton b = (Buton) o;
//				if(b.buton.contains(arg0.getPoint())){
//					b.click();
//				}
//			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if(arg0.getButton() == 1) {
			if(pressing) {
				pressing=false;
			}
		}
	}
}

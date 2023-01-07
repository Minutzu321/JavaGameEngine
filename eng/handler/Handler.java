package eng.handler;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import eng.obj.Obiect;

public class Handler {
	
	public List<Obiect> onbj = new ArrayList<Obiect>();
	
	public Handler(){
		System.out.println("HANDLER LOADED!");
	}
	
	public void tick(){
		for(int i =onbj.size()-1; i>=0;i--){
			Obiect gbj;
			gbj = onbj.get(i);
			gbj.tick();
		}
	}
	
	public void render(Graphics g){
		for(int i =onbj.size()-1; i>=0;i--){
			Obiect gbj;
			gbj = onbj.get(i);
			gbj.render(g);
		}
	}

	public void addObj(Obiect o){
		onbj.add(o);
	}
	
	public void remObj(Obiect o){
		onbj.remove(o);
	}

	

	
}

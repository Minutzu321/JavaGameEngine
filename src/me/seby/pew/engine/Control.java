package me.seby.pew.engine;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import me.seby.pew.Game;
import me.seby.pew.entitati.EntityA;
import me.seby.pew.entitati.EntityB;
import me.seby.pew.util.Texturi;

public class Control {
	
	static LinkedList<EntityA> ena = new LinkedList<EntityA>();
	static LinkedList<EntityB> enb = new LinkedList<EntityB>();
	static LinkedList<Explozie> explozie = new LinkedList<Explozie>();
	EntityA enta;
	EntityB entb;
	Explozie exp;
	private Texturi t;
	Random r = new Random();
	private Game g;
	
	public Control(Texturi tex,Game ga){
		t=tex;
		g=ga;
	}
	
	public void createInamic(int cinamici){
		for(int i = 0; i < cinamici;i++){
			addEntity(new Inamic(r.nextInt(Game.LATIME*Game.SCALA),-150-r.nextInt(80),t, g));
		}
	}
	
	public void createExpl(double x, double y){
		addExpl(new Explozie(x,y,t,g));
	}
	
	public void tick(){
		//A
		for(int i = 0; i<ena.size();i++){
			enta = ena.get(i);
			
			enta.tick();
		}
		
		//B
		for(int i = 0; i<enb.size();i++){
			entb = enb.get(i);
			
			entb.tick();
		}
		
		for(int i = 0; i<explozie.size();i++){
			exp = explozie.get(i);
			
			exp.tick();
		}

	}
	
	public void render(Graphics g){
		//A
		for(int i = 0; i<ena.size();i++){
			enta = ena.get(i);
			
			enta.render(g);
		}
		
		//B
		for(int i = 0; i<enb.size();i++){
			entb = enb.get(i);
			
			entb.render(g);
		}
		
		for(int i = 0; i<explozie.size();i++){
			exp = explozie.get(i);
			
			exp.render(g);
		}
		
	}
	//A
	public void addEntity(EntityA e){
		ena.add(e);
		
	}
	
	public void remEntity(EntityA e){
		ena.remove(e);
		
	}
	//B
	public void addEntity(EntityB e){
		enb.add(e);
		
	}
	
	public void remEntity(EntityB e){
		enb.remove(e);
		
	}
	
	public void addExpl(Explozie e){
		explozie.add(e);
		
	}
	
	public void remExpl(Explozie e){
		explozie.remove(e);
		
	}
	
	public LinkedList<EntityA> getEntA(){
		return ena;
	}
	
	public LinkedList<EntityB> getEntB(){
		return enb;
	}


}

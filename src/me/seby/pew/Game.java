package me.seby.pew;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JFrame;

import me.seby.pew.engine.Control;
import me.seby.pew.engine.Glont;
import me.seby.pew.engine.KeyInput;
import me.seby.pew.engine.Meniu;
import me.seby.pew.engine.MouseInput;
import me.seby.pew.engine.Player;
import me.seby.pew.entitati.EntityA;
import me.seby.pew.entitati.EntityB;
import me.seby.pew.util.Texturi;

public class Game extends Canvas implements Runnable{
	

	private static final long serialVersionUID = 1L;
	public static final int LATIME = 320;
	public static final int INALTIME = LATIME/12 * 9;
	public static final int SCALA = 2;
	public final String TITLU = "Pew";
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage imagine = new BufferedImage(LATIME,INALTIME,BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage bg = null;
	private BufferedImage failimg = null;
	
	private boolean traje = false;
	
	private int cinamici = 1;
	private int kinamici = 0;
	
	private Player p;
	private Control c;
	private Texturi t;
	
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	
	public static int VIATA = 100 *2;
	
	public boolean fail=false;
	
	public int level = 1;
	
	public static enum State{
		MENIU,
		JOC
	};
	public static State stat = State.MENIU;
	private Meniu meniu;
	
	public void init(){
		requestFocus();
		BufferedImageLoader loader = new BufferedImageLoader();
		spriteSheet=loader.loadImage("sheet");
		bg = loader.loadImage("bg");
		failimg = loader.loadImage("faimg");
	    addKeyListener(new KeyInput(this));
	    addMouseListener(new MouseInput());
	    
	    t=new Texturi(this);
		p=new Player(200,200,t);
		c = new Control(t,this);
		meniu = new Meniu();
	
		ea=c.getEntA();
		eb=c.getEntB();
		
		c.createInamic(cinamici);
	}

	private synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		init();
		long utimp = System.nanoTime();
		final double amTick = 60.0;
		double ns = 1000000000 / amTick;
		double delta = 0;
		int update = 0;
		int frame = 0;
		long timer = System.currentTimeMillis();
		while(running){
			long acm = System.nanoTime();
			delta += (acm-utimp) / ns;
			utimp=acm;
			if(delta >=1){
				tick();
				update++;
				delta--;
			}
			render();
			frame++;
			
			if(System.currentTimeMillis()-timer > 1000){
				timer += 1000;
				System.out.println("Tickuri: "+update+" , FPS:"+frame);
				update=0;
				frame=0;
			}
		}
		stop();
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(stat == State.JOC){
		if(key == KeyEvent.VK_SPACE && !traje){
			traje=true;
			c.addEntity(new Glont(p.getLoc().getX(),p.getLoc().getY(),this,t));
		}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if(stat == State.JOC){
		if(key == KeyEvent.VK_SPACE){
			traje=false;
		}
		}
	}
	
	private void tick(){
		if(running){
		if(stat == State.JOC){
			if(!fail){
		p.tick();
		c.tick();
			}
		}	
		
		if(kinamici >= cinamici){
			cinamici = cinamici+1;
			kinamici=0;
			c.createInamic(cinamici);
			level = level+1;
		}
		
		if(VIATA <= 0){
			fail = true;
		}
		}
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();

		
		g.drawImage(imagine, 0, 0, getWidth(),getHeight(),this);
		
		g.drawImage(bg,0,0,null);
		if(!fail){
		if(stat == State.JOC){
			
		p.render(g);
		c.render(g);
		
		g.setColor(Color.GRAY);
		g.fillRect(5, 5, 200, 50);
		
		g.setColor(Color.GREEN);
		g.fillRect(5, 5, VIATA, 50);
		
		g.setColor(Color.WHITE);
		g.drawRect(5, 5, 200, 50);
		
		Font f = new Font("arial",Font.BOLD,25);
		g.setFont(f);
		g.drawString("Level: "+level, 210, 35);
		}else{
			meniu.render(g);
		}
		}else{
			g.drawImage(failimg,0,0,getWidth(),getHeight(),this);
			
		}
		
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String args[]){
		Game game = new Game();
		game.setPreferredSize(new Dimension(LATIME * SCALA,INALTIME * SCALA));
		game.setMaximumSize(new Dimension(LATIME * SCALA,INALTIME * SCALA));
		game.setMinimumSize(new Dimension(LATIME * SCALA,INALTIME * SCALA));
		
		JFrame frame = new JFrame(game.TITLU);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}
	
	public BufferedImage getSpriteSheet(){
		return spriteSheet;
	}
	public Control getControl(){
		return c;
	}
	
	public int getCinamici() {
		return cinamici;
	}

	public void setCinamici(int cinamici) {
		this.cinamici = cinamici;
	}

	public int getKinamici() {
		return kinamici;
	}

	public void setKinamici(int kinamici) {
		this.kinamici = kinamici;
	}



}

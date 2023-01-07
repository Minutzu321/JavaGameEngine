package eng;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import eng.handler.Handler;
import eng.handler.TextHandler;
import eng.listeners.KeyInput;
import eng.listeners.MouseInput;
import me.minutz.vreme.Fonturi;

public class Game extends Canvas implements Runnable{

	private boolean mere = false;
	private Thread thread;
	static Handler hndl;
	static TextHandler thndl;
	public static int LATIME,INALTIME;
	public static Color bgc = new Color(35, 36, 42);
	public static BufferedImage bgimg;
	public static int tick,fps;
	
	
	public void init(){
		LATIME=getWidth();
		INALTIME=getHeight();
		hndl = new Handler();
		thndl = new TextHandler();
//		BufferedImageLoader l = new BufferedImageLoader();
		addKeyListener(new KeyInput(hndl));
		addMouseListener(new MouseInput(hndl));
		requestFocusInWindow();
		
//		  Toolkit toolkit = Toolkit.getDefaultToolkit();
//		    Point hotSpot = new Point(0,0);
//		    BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT); 
//		    Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "NUSEVEDE");        
//		    setCursor(invisibleCursor);
//		    
//	    bgimg = l.loadImage("masa.jpg");
	}
	
	

	public synchronized void start(){
		if(mere){
			return;
		}
		mere = true;
		thread = new Thread(this);
		thread.start();
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
		while(mere){
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
					tick=update;
					fps=frame;
					update=0;
					frame=0;
				}
		}

	}
	
	public void tick(){
		if(mere){
			hndl.tick();
			thndl.tick();
//			cam.tick(xx,yy);
			if(KeyInput.sfps){
				thndl.addText("FPS:"+fps, 0, 10, 1, Color.YELLOW, Font.BOLD, 10);
			}
		}
	}
	
	public void render(){
			BufferStrategy bs = getBufferStrategy();
			
			if(bs == null){
				createBufferStrategy(3);
				return;
			}
			
			Graphics g = bs.getDrawGraphics();
			Graphics2D g2 = (Graphics2D) g;
			g.setColor(bgc);
			g.fillRect(0, 0, getWidth(), getHeight());

	//		g.drawImage(bgimg, 0, 0, null);
			
			
			
	//		g2.translate(cam.getX(), cam.getY());
			hndl.render(g);
			thndl.render(g);	
	//		g2.translate(-cam.getX(), -cam.getY());
			g.dispose();
			bs.show();
	}
	
	public static Handler getHndl(){
		return hndl;
	}
	
	public static TextHandler getTHndl(){
		return thndl;
	}
	
	public static int getLatime(){
		return LATIME;
	}
	
	public static int getInaltime(){
		return INALTIME;
	}
}

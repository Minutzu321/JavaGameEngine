package eng;

import java.awt.Dimension;

import javax.swing.JFrame;

public class HWindow {
	
	
	private Game game;
	private int width,height;
	private String TTL;
	
	public HWindow(int w, int h ,String titlu ,Game g){
		game=g;
		width=w;
		height=h;
		TTL=titlu;
		g.setPreferredSize(new Dimension(w,h));
		g.setMaximumSize(new Dimension(w,h));
		g.setMinimumSize(new Dimension(w,h));
		
		JFrame frame = new JFrame(titlu);
		frame.add(g);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		g.start();
	}

	public Game getGame() {
		return game;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getTitlu() {
		return TTL;
	}

}

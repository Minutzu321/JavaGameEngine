package eng.etc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	public List<lola> loaded = new ArrayList<lola>();
	public BufferedImage loadImage(String str){
		BufferedImage image = null;
		for(lola l:loaded){
			if(l.getPath().equals(str)){
				return l.getImg();
			}
		}
		try {
			image = ImageIO.read(new File(str));
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		loaded.add(new lola(image,str));
		return image;
	}
	
	public class lola {
		private BufferedImage img;
		private String path;
		public lola(BufferedImage img, String path) {
			this.img = img;
			this.path = path;
		}
		public BufferedImage getImg() {
			return img;
		}
		public String getPath() {
			return path;
		}
		
	}
}

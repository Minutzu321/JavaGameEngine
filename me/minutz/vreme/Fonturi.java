package me.minutz.vreme;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Fonturi {
	
	public static Font getFont(){
		URL fontUrl = null;
		try {
			fontUrl = new URL("https://fonts.gstatic.com/s/dosis/v7/HhyXU5sn9vOmLzGnKuCLMItyTA.woff2");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	        Font font=null;
			try {
				font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
			} catch (FontFormatException | IOException e) {
				e.printStackTrace();
			}
	        return font;
	}

}

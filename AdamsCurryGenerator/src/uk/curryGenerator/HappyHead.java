package uk.curryGenerator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HappyHead {

	public HappyHead(){
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("Adams-heads/adamsFury.jpg"));
		} catch (IOException e) {
		}
	}
}

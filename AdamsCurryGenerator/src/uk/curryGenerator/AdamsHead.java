package uk.curryGenerator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class AdamsHead {
	
	private ArrayList<File> heads;
	private File happyHead;
	private File veryHappyHead;
	private File confusedHead;
	private File rageHead;
	
	
	public AdamsHead(){
		veryHappyHead = new File("Adams heads/HappyAdam");
		rageHead = new File("Adams heads/adamsFury");
		happyHead = new File("Adams heads/ModeratelyHappyAdam");
		confusedHead = new File("Adams heads/whenYouFinallyGettheSuccAdam");
		
		heads = new ArrayList<File>();
		heads.add(veryHappyHead);
		heads.add(rageHead);
		heads.add(confusedHead);
		heads.add(happyHead);
		
		BufferedImage head = null;
			
		try{
			head = new BufferedImage(200, 600, BufferedImage.TYPE_INT_ARGB);
			for (File i : heads){
			head = ImageIO.read(i);
		}
						
		}catch(IOException e){
			System.out.println("Error: "+e);
		}
	}
	
	
}

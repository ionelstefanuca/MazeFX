package maze;

import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

public class Map
{
	private Scanner m;
	private String Map[] = new String[14];
	private Image grass,
				  wall,
				  finis;
	
	public Map()
	{
		ImageIcon img = new ImageIcon("wall.png");
		this.wall=img.getImage();
		
		img = new ImageIcon("grass.png");
		this.grass = img.getImage();
		
		img = new ImageIcon("doors.png");
		this.finis=img.getImage();
		
		openFile();
		readFile();
		closeFile();
	}
	
	public Image getGrass()
	{
		return this.grass;
	}
	
	public Image getWall()
	{
		return this.wall;
	}
	
	public Image getFinish()
	{
		return this.finis;
	}
	
	
	public String getMap(int x, int y)
	{
		String index = this.Map[y].substring(x, x+1);
		return index;
	}
	
	public void openFile()
	{
		try {
			this.m= new Scanner(new File("labirint.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readFile()
	{
		while(this.m.hasNext())
		{
			for(int i=0;i<14;i++)
			{
				this.Map[i]= this.m.next();
			}
		}
	}
	
	public void closeFile()
	{
		this.m.close();
	}
}
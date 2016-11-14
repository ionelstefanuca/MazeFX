package maze;

import java.awt.*;

import javax.swing.*;

public class Player {
	private int tileX, tileY;
	
	private Image player;
	
	Player()
	{
		ImageIcon img = new ImageIcon("player.png");
		player = img.getImage();
		
		tileX=1;
		tileY=1;
	}
	
	public Image getPlayer()
	{
		return player;
	}
	
	
	public int getTileX()
	{
		return tileX;
	}
	
	public int getTileY()
	{
		return tileY;
	}
	
	
	public void move(int tx,int ty)
	{
		tileX +=tx;
		tileY +=ty;
	}
}

package laborator6;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ViewLabirint extends JPanel {
	private Model model ;
	
	ViewLabirint ( Model model)
	{
		this.model= model;	
	}
	
	public void paint(Graphics g)
	{
		System.out.println("am aplicat metoda");
		
		
		for(int x=0; x<this.model.getLength();x++)
		{
			for(int y=0;y<this.model.getLength();y++)
			{
				if(this.model.getMatricea()[x][y]==0)
					g.drawImage(getImgBorder(), x*32, y*32, this);
				
				if(this.model.getMatricea()[x][y]==-1)
					g.drawImage(getPozActual(), x*32, y*32, this);
				
				if(this.model.getMatricea()[x][y]==-2)
					g.drawImage(getFinal(), x*32, y*32, this);
				
				if(this.model.getMatricea()[x][y]==2)
					g.drawImage(getWall(), x*32, y*32, this);
				
				if(this.model.getMatricea()[x][y]==3)
					g.drawImage(getGrass(), x*32, y*32, this);
				
				if(this.model.getMatricea()[x][y]==4)
					g.drawImage(getTrap(), x*32, y*32, this);
				
				if(this.model.getMatricea()[x][y]==-3)
					g.drawImage(getBordura(), x*32, y*32, this);
				
				if(this.model.getMatricea()[x][y]==5)
				{
					g.drawImage(getRoad(), x*32, y*32, this);
				}
			}
		}		
	}
	
	static Image getImgBorder()
	{
		ImageIcon img = new ImageIcon ("border.png");
		return img.getImage();
	}
	
	static Image getFinal()
	{
		ImageIcon img = new ImageIcon ("doors.png");
		return img.getImage();
	}
	
	static Image getBordura()
	{
		ImageIcon img = new ImageIcon ("wall1.png");
		return img.getImage();
	}
	
	static Image getPozActual()
	{
		ImageIcon img = new ImageIcon ("player.png");
		return img.getImage();
	}
	
	static Image getWall()
	{
		ImageIcon img = new ImageIcon ("wall.png");
		return img.getImage();
	}	
	
	static Image getGrass()
	{
		ImageIcon img = new ImageIcon ("grass.png");
		return img.getImage();
	}	
	
	static Image getTrap()
	{
		ImageIcon img = new ImageIcon ("trap.png");
		return img.getImage();
	}	
	
	static Image getRoad()
	{
		ImageIcon img = new ImageIcon ("drum.jpg");
		return img.getImage();
	}
}





















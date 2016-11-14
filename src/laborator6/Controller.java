package laborator6;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controller implements MouseListener, MouseMotionListener {
		
	private View view;
	private Model model;
	private static int valoare =0;
	
	Controller(Model model,View view)
	{
		this.view= view;
		this.model=model;
		
		this.view.getviewLabirint().addMouseListener(this);
		this.view.getviewLabirint().addMouseMotionListener(this);
	}
	
    public void mouseDragged(MouseEvent evt) {
			int coordX =  evt.getX()/32;
			int coordY = evt.getY()/32;
			
			modificaCoordonate(coordX,coordY,this.valoare);
    }

    public void mousePressed(MouseEvent evt) {
   	 int coordX =  evt.getX()/32;
		 int coordY = evt.getY()/32;
   	 modificaCoordonate(coordX,coordY,this.valoare);   	 
    }
    
    
	public void modificaCoordonate(int x,int y,int val)
	{
		if( x!=0 && y>0 && x!=model.getLength()-1  &&y <= model.getLength()-2 && x <model.getLength()-1 )
			if(this.model.getMatricea()[x][y]==0)
				{
					if(valoare==-2)  //stergem valoarea din matrice si actualizam cu noua pozitie
					{
						this.model.setNewCoordFinale(x, y);
					}
					else 
						if(valoare==-1)
						{
							this.model.setNewCoordActuale(x, y);
						}
						else
							model.updateMatrice(x, y, val);
				}
			else
				if(this.model.getMatricea()[x][y]==-2 &&valoare==-1 )
				{
					System.out.println("Ai castigat");
				}
		
		
		this.view.repaint();
	}
    
	
	static void setValoare(int i)
	{
		valoare = i;
	}
    
    public void mouseReleased(MouseEvent evt) { }
    public void mouseEntered(MouseEvent evt) { }
    public void mouseExited(MouseEvent evt) { }
    public void mouseMoved(MouseEvent evt) { }
    public void mouseClicked(MouseEvent evt) { } 
    
}

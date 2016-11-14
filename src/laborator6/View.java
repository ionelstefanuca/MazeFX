package laborator6;

import java.awt.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class View extends JFrame {

	private Model model ;
	private ViewLabirintManager viewManagerLab;
	private ViewLabirint labView;
	
	View (Model model)
	{
		this.model= model;
		this.setLayout(null);
		//this.setVisible(true);
		this.setSize(model.getMatricea().length*32+16+280, model.getMatricea().length*32+30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Labirint 2D");	
		
	    labView = new ViewLabirint( model);
		labView.setBounds(0, 0, model.getMatricea().length*32, model.getMatricea().length*32);
		this.add(labView);
		
		
	    viewManagerLab = new ViewLabirintManager(model,this);
	    viewManagerLab.setBounds(model.getMatricea().length*32+16, 0, 275, model.getMatricea().length*32+40);
		this.add(viewManagerLab);
		
		
		this.setResizable(false);
	}
	
	ViewLabirintManager getViewManager()
	{
		return this.viewManagerLab;
	}
	
	ViewLabirint getviewLabirint()
	{
		return this.labView;
	}
	
	
	
}

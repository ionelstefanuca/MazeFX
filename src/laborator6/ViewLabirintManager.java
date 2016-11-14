package laborator6;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;


@SuppressWarnings("serial")
public class ViewLabirintManager extends JPanel{
	
		private Vector<Coordonate> drumLabirint = new Vector<>();
		private Model model;
		private View view;		
		
		private JButton rezAutomata;
		
	
	ViewLabirintManager(final Model model , final View view)
	{
		this.model=model;
		this.view=view;
		
		this.setSize(250, this.model.getLength()*32+40);
		this.setVisible(true);
		this.setLayout(null);

		
		///////////////////////////////////////////////////////////////////
		JButton savePNG = new JButton("Save .png");
		JButton saveJPG = new JButton("Save .jpg");
					
					JPanel butoaneSaveImagini = new JPanel();
					butoaneSaveImagini.setLayout(new GridLayout(1,2));
					butoaneSaveImagini.add(savePNG);
					butoaneSaveImagini.add(saveJPG);
					
					saveJPG.setIcon(new ImageIcon("save.png"));
					savePNG.setIcon(new ImageIcon("save.png"));
					
					saveJPG.addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent arg0) {
								
								String numeimagine = JOptionPane.showInputDialog(new JPanel(), "Nume imagine:");
									makePanelImage(view.getviewLabirint(),"jpeg",numeimagine);
								
									String deschideImaginea = JOptionPane.showInputDialog(new JPanel(), "Deschizi "+numeimagine+".jpeg? da / nu");
									
									if(deschideImaginea.equals("da")||deschideImaginea.equals("DA"))
										try {
											Desktop.getDesktop().open(new File(numeimagine+".jpeg"));
										} catch (IOException e) {
											e.printStackTrace();
										}
							}
					});
					
					savePNG.addMouseListener(new MouseAdapter() {
						public void mousePressed(MouseEvent arg0) {
							String numeimagine = JOptionPane.showInputDialog(new JPanel(), "Nume imagine:");
							makePanelImage(view.getviewLabirint(),"png",numeimagine);
						
							String deschideImaginea = JOptionPane.showInputDialog(new JPanel(), "Deschizi "+numeimagine+".png? da / nu");
							
							if(deschideImaginea.equals("da")||deschideImaginea.equals("DA"))
								try {
									Desktop.getDesktop().open(new File(numeimagine+".png"));
								} catch (IOException e) {
									e.printStackTrace();
								}
						}
					});
					
					butoaneSaveImagini.setBounds(0, 0, 275, 50);
					this.add(butoaneSaveImagini);		
					
					
					
					
		///////////////////////////////////////////////////////////////////
					
					JPanel editareLabirint = new JPanel();
					editareLabirint.setLayout(new GridLayout(3,2));
					editareLabirint.setBounds(0, 130, 273, 120);
						JButton wall = new JButton("Wall");
						JButton grass = new JButton("Grass");
						JButton start = new JButton("Start");
						JButton sfarsit = new JButton("Sfarsit");
						JButton trap = new JButton("Trap");
						JButton reset = new JButton("Reset");
						
						
						editareLabirint.add(wall);
						editareLabirint.add(grass);
						editareLabirint.add(start);
						editareLabirint.add(sfarsit);
						editareLabirint.add(trap);
						editareLabirint.add(reset);
						
						wall.setIcon(new ImageIcon("wall.png"));
						grass.setIcon(new ImageIcon("grass.png"));
						start.setIcon(new ImageIcon("player.png"));
						sfarsit.setIcon(new ImageIcon("doors.png"));
						trap.setIcon(new ImageIcon("trap.png"));
						reset.setIcon(new ImageIcon("reset.png"));
					
					this.add(editareLabirint);
					
					
					wall.addMouseListener(new MouseAdapter() {
						public void mousePressed(MouseEvent arg0) {
							Controller.setValoare(2);
						}
						});
					
					grass.addMouseListener(new MouseAdapter() {
						public void mousePressed(MouseEvent arg0) {
							Controller.setValoare(3);
						}
						});
					
					trap.addMouseListener(new MouseAdapter() {
						public void mousePressed(MouseEvent arg0) {
							Controller.setValoare(4);
						}
						});
					
					start.addMouseListener(new MouseAdapter() {
						public void mousePressed(MouseEvent arg0) {
							Controller.setValoare(-1);
						}
						});
					
					sfarsit.addMouseListener(new MouseAdapter() {
						public void mousePressed(MouseEvent arg0) {
							Controller.setValoare(-2);
						}
						});
					
					
					reset.addMouseListener(new MouseAdapter() {
						public void mousePressed(MouseEvent arg0) {
							resetVectorModel();
							
						}
						});
					
					
					
			///////////////////////////////////
						JLabel lEditare = new JLabel("Editare Labirint");
						lEditare.setBounds(70, 90, 273, 50);
						lEditare.setFont(new Font("Serif", Font.BOLD, 20));
						this.add(lEditare);
			
			///////////////
						
						
						
						/*
						 * Rezolvarea labirintului
						 */
						{
							JPanel rezLabirint = new JPanel();
							
							 rezAutomata = new JButton("Rezolvare");
							 JButton genereazaLab = new JButton("Genereaza");
							
							rezAutomata.setIcon(new ImageIcon("mazeIcon.png"));
							genereazaLab.setIcon(new ImageIcon("mazeIcon2.gif"));
							
							
							rezLabirint.setLayout(new GridLayout(1,2));
							rezLabirint.add(rezAutomata);
							rezLabirint.add(genereazaLab);
							
							
							rezLabirint.setBounds(0, 320, 273, 40);							
							this.add(rezLabirint);
							
							
							JLabel lRezolvare = new JLabel("Rezolvare Labirint");
							lRezolvare.setBounds(70, 285, 273, 40);
							lRezolvare.setFont(new Font("Serif", Font.BOLD, 20));
							this.add(lRezolvare);
							
	
							
							rezAutomata.addMouseListener(new MouseAdapter() {
								public void mousePressed(MouseEvent arg0) {
									System.out.println("Rezolvare labirint automata");
									
									rezolvareLabirintAutomata();
								}
								});
							
							genereazaLab.addMouseListener(new MouseAdapter() {
								public void mousePressed(MouseEvent arg0) {							
									int labLen20 [][] = {
											{-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3},
											{-3,-1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-3},
											{-3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,-3},
											{-3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-3},
											{-3,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,-3},
											{-3,0,2,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,-3},
											{-3,0,2,0,0,2,0,2,0,2,2,2,2,2,2,2,2,2,2,2,0,-3},
											{-3,0,2,0,2,0,0,2,0,2,0,0,0,0,0,0,0,0,0,0,0,-3},
											{-3,0,2,0,2,0,2,0,0,2,0,2,2,2,2,2,2,2,2,2,2,-3},
											{-3,0,2,0,2,0,2,0,2,0,0,2,0,0,0,0,0,0,0,0,0,-3},
											{-3,0,2,0,2,0,2,0,2,0,2,2,0,0,2,2,2,2,2,2,0,-3},
											{-3,0,2,0,2,0,2,0,2,0,2,0,0,2,0,0,0,0,0,2,0,-3},
											{-3,0,2,0,2,0,2,0,2,0,2,0,2,2,0,0,2,2,0,2,0,-3},
											{-3,0,2,0,2,0,2,0,2,0,2,0,2,0,0,2,2,2,0,2,0,-3},
											{-3,0,2,0,2,0,2,0,2,0,2,0,2,0,2,2,0,2,0,2,0,-3},
											{-3,0,2,0,2,0,2,0,2,0,2,0,2,0,2,2,0,2,0,2,0,-3},
											{-3,0,2,0,2,0,2,0,2,0,2,0,2,0,2,2,0,2,0,2,0,-3},
											{-3,0,2,0,2,0,2,0,2,0,2,0,2,0,2,2,0,2,2,2,0,-3},
											{-3,0,2,0,2,0,0,0,2,0,0,0,2,0,2,0,0,0,0,0,0,-3},
											{-3,0,2,0,2,0,2,2,2,2,2,2,2,0,2,0,2,2,2,2,2,-3},
											{-3,0,0,0,2,0,2,0,0,0,0,0,0,0,2,0,0,0,0,0,-2,-3},
											{-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3}
											};
									
									int labLen19 [][] = {
											{-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3},
											{-3,-1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-3},
											{-3,0,2,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,-3},
											{-3,0,2,0,0,0,0,0,0,0,0,0,0,2,4,4,4,4,2,0,-3},
											{-3,0,2,2,2,2,2,2,2,2,2,2,0,2,4,4,4,4,2,0,-3},
											{-3,0,2,3,3,3,3,3,3,3,4,2,0,2,2,2,2,2,2,0,-3},
											{-3,0,2,3,3,3,3,3,3,3,3,2,0,2,0,0,0,0,2,0,-3},
											{-3,0,2,3,4,2,3,3,3,3,3,2,0,2,0,2,2,0,2,0,-3},
											{-3,0,2,2,2,2,2,3,3,3,2,2,0,2,0,2,2,0,2,0,-3},
											{-3,0,2,0,0,0,2,3,3,3,2,2,0,2,0,2,2,0,2,0,-3},
											{-3,0,2,0,2,0,2,3,3,3,2,2,0,2,0,2,2,0,2,0,-3},
											{-3,0,2,0,2,0,2,3,3,3,2,2,0,2,0,2,2,0,2,0,-3},
											{-3,0,2,0,2,0,2,3,3,3,2,2,0,2,0,2,2,0,2,0,-3},
											{-3,0,2,0,2,0,2,3,3,4,2,2,0,2,0,2,2,0,2,0,-3},
											{-3,0,2,0,2,0,2,2,2,2,2,2,0,2,0,2,2,0,2,0,-3},
											{-3,0,2,0,2,0,0,0,0,0,0,0,0,2,0,2,2,0,2,0,-3},
											{-3,0,2,0,2,2,2,2,2,2,2,2,2,2,0,2,2,0,2,0,-3},
											{-3,0,2,0,0,0,0,0,0,0,0,0,0,0,0,2,2,0,2,0,-3},
											{-3,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2,0,-3},
											{-3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,-2,-3},
											{-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3}
											};
									
									int labLen18 [][] = {{-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3},
											{-3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,-3},
											{-3,0,2,2,2,2,2,2,2,2,2,2,2,2,2,0,2,0,0,-3},
											{-3,0,2,2,2,2,2,0,0,0,0,0,0,0,2,0,2,2,2,-3},
											{-3,0,2,0,0,0,0,0,0,2,0,2,0,0,2,0,0,0,0,-3},
											{-3,0,2,0,0,0,2,2,2,2,2,2,2,0,2,2,2,0,2,-3},
											{-3,0,2,2,2,2,2,0,0,0,0,0,2,0,2,0,0,0,0,-3},
											{-3,0,0,0,0,0,0,0,2,2,2,0,2,0,2,0,2,2,2,-3},
											{-3,2,2,2,2,2,2,2,-1,2,2,0,2,2,2,0,2,0,0,-3},
											{-3,0,0,0,0,0,0,0,0,2,2,0,2,0,2,0,2,0,0,-3},
											{-3,0,2,2,2,2,2,2,2,2,2,0,2,0,2,0,2,0,0,-3},
											{-3,0,2,3,3,3,3,3,3,4,2,0,2,0,2,0,2,2,2,-3},
											{-3,0,2,4,3,3,3,3,3,3,2,0,2,0,2,0,0,0,0,-3},
											{-3,0,2,2,2,2,2,2,2,2,2,0,2,0,2,0,2,2,0,-3},
											{-3,0,0,0,0,0,0,0,0,0,0,0,2,0,2,0,2,0,0,-3},
											{-3,2,2,2,2,2,2,2,2,2,2,2,2,0,2,0,2,0,0,-3},
											{-3,0,0,0,0,0,0,0,0,0,2,2,0,0,2,0,2,0,0,-3},
											{-3,2,2,2,0,2,2,2,2,2,2,0,2,0,2,0,2,2,0,-3},
											{-3,0,0,2,2,2,0,0,0,0,0,0,2,2,2,0,0,2,-2,-3},
											{-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3}};
									
									int labLen17 [][]= {{-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3},
											{-3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,-3},
											{-3,0,2,2,2,2,2,0,2,0,2,2,2,2,2,2,2,0,-3},
											{-3,0,2,3,3,3,2,0,2,0,2,0,0,0,2,2,0,0,-3},
											{-3,0,2,3,3,3,2,0,0,0,2,0,2,0,2,2,0,2,-3},
											{-3,0,2,3,3,3,2,2,2,2,2,0,2,0,2,2,0,2,-3},
											{-3,0,2,4,3,3,3,3,3,4,2,0,2,0,0,2,0,2,-3},
											{-3,0,2,2,2,2,2,2,3,3,2,0,0,2,0,2,0,2,-3},
											{-3,0,2,0,0,0,0,2,3,3,2,0,0,2,0,2,0,2,-3},
											{-3,0,2,0,2,0,2,2,3,3,2,2,0,2,0,2,0,2,-3},
											{-3,0,2,0,2,0,2,3,3,3,3,2,0,2,0,2,0,2,-3},
											{-3,0,2,0,2,0,2,4,3,3,3,2,0,2,0,2,0,2,-3},
											{-3,0,2,0,2,0,2,2,2,2,2,2,0,2,0,2,0,-1,-3},
											{-3,0,2,0,2,0,0,0,0,0,2,2,0,2,0,2,2,2,-3},
											{-3,0,2,0,2,2,2,2,2,0,2,2,0,2,0,0,0,0,-3},
											{-3,0,2,0,0,0,0,0,2,0,2,2,0,2,2,2,2,0,-3},
											{-3,0,2,2,2,2,2,0,2,0,2,2,0,2,4,3,2,0,-3},
											{-3,0,0,0,0,0,0,0,2,0,0,0,0,2,3,3,2,-2,-3},
											{-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3}};


									
									
									switch(model.getLength())
									{
										case 22: model.setMatrice(labLen20); break;
										case 21: model.setMatrice(labLen19); break;
										case 20: model.setMatrice(labLen18); break;
										case 19: model.setMatrice(labLen17); break;
									}
										view.repaint();

									
									
									System.out.println("{");
									
										for(int i=0; i<model.getLength();i++)
										{
											for(int j=0;j<model.getLength();j++)
											{
												System.out.print(model.getMatricea()[i][j]+" , ");
											}
										}
									System.out.println("}");
									
									
								}
								});

						}
					
	}
	
	
	void resetVectorModel()
	{
		this.model.changeVector();
		this.view.repaint();
	}
	
	void makePanelImage(Component panel,String extensie,String numeImagine)
    {
        Dimension size = panel.getSize();
        BufferedImage image = new BufferedImage(
                    size.width, size.height 
                              , BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        panel.paint(g2);
        try
        {
            ImageIO.write(image, extensie, new File(numeImagine+"."+extensie));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
	
	
	void rezolvareLabirintAutomata()
	{
		Vector<Coordonate> coordonate = new Vector<>();
		
		coordonate.add(this.model.getCoordActuale());
		boolean esteAdaugat;
		
		while(coordonate.size()>0)
		{
			
			Coordonate pop = new Coordonate();
			 pop = coordonate.get(0);
			coordonate.remove(0);
			
			this.drumLabirint.add(pop);
			
			esteAdaugat=false;
			
			this.model.setNewCoordActuale(pop.getX(), pop.getY());
			
			//verificam din sus
				Coordonate coordSus = new Coordonate (pop.getX(),pop.getY()-1);
				if(!this.model.isFinal(coordSus))
				{
					for(int i=0;i<coordonate.size();i++)
					{
						if(coordonate.get(i).getX()==coordSus.getX() && (coordonate.get(i).getY()==coordSus.getY()))
							esteAdaugat=true;
					}
					
				if(!esteAdaugat)
					if(this.model.isGrass(coordSus)||this.model.isFree(coordSus))
					{
						this.model.setNewCoordActuale(coordSus.getX(), coordSus.getY());
						coordonate.add(coordSus);
						this.model.updateMatrice(pop.getX(), pop.getY(), 5);
					}
				}
				else
				{
					System.out.println("AM ajuns la final");
					break;
				}
				
				
			Coordonate coordJos = new Coordonate (pop.getX(),pop.getY()+1);
				if(!this.model.isFinal(coordJos))
				{
					for(int i=0;i<coordonate.size();i++)
					{
						if(coordonate.get(i).getX()==coordJos.getX() && (coordonate.get(i).getY()==coordJos.getY()))
							esteAdaugat=true;
					}
					
				if(!esteAdaugat)
					if(this.model.isGrass(coordJos)||this.model.isFree(coordJos))
					{
						this.model.setNewCoordActuale(coordJos.getX(), coordJos.getY());
						coordonate.add(coordJos);
						this.model.updateMatrice(pop.getX(), pop.getY(), 5);
					}
				}
				else
				{
					System.out.println("AM ajuns la final");
					break;
				}


				Coordonate coordStanga = new Coordonate (pop.getX()-1,pop.getY());
				if(!this.model.isFinal(coordStanga))
				{
					for(int i=0;i<coordonate.size();i++)
					{
						if(coordonate.get(i).getX()==coordStanga.getX() && (coordonate.get(i).getY()==coordStanga.getY()))
							esteAdaugat=true;
					}
					
				if(!esteAdaugat)
					if(this.model.isGrass(coordStanga)||this.model.isFree(coordStanga))
					{
						this.model.setNewCoordActuale(coordStanga.getX(), coordStanga.getY());
						coordonate.add(coordStanga);
						this.model.updateMatrice(pop.getX(), pop.getY(), 5);
					}				
				}
				else
				{
					System.out.println("AM ajuns la final");
					break;
				}
				
				
				Coordonate coordDreapta = new Coordonate (pop.getX()+1,pop.getY());
				if(!this.model.isFinal(coordDreapta))
				{
					for(int i=0;i<coordonate.size();i++)
					{
						if(coordonate.get(i).getX()==coordDreapta.getX() && (coordonate.get(i).getY()==coordDreapta.getY()))
							esteAdaugat=true;
					}
					
				if(!esteAdaugat)
					if(this.model.isGrass(coordDreapta)||this.model.isFree(coordDreapta))
					{
						this.model.setNewCoordActuale(coordDreapta.getX(), coordDreapta.getY());
						coordonate.add(coordDreapta);
						this.model.updateMatrice(pop.getX(), pop.getY(), 5);
					}
				}
				else
				{
					System.out.println("AM ajuns la final");
					break;
				}
				
				System.out.println(coordonate);
				System.out.println(pop);
		}
		
		this.view.repaint();
		
		System.out.println("Drumul parcurs este "+this.drumLabirint.size());
	}
	
}

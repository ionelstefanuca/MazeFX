package maze;

import javax.swing.*;

public class Maze {
	public static void main(String [] args)
	{
		new Maze();
	}
	
	public Maze()
	{
		JFrame f = new JFrame();
		f.setTitle("Labirint 2D");
		f.add(new Board());
		f.setSize(465, 485);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

package laborator6;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LabirintMain extends JFrame {
	private JTextField textField;
	private static int numarLiniiColoaneLabirint;
	
	public static void main(String [] args)
	{		
		 new LabirintMain();		
	}
	
	
	LabirintMain()
	{
		this.setTitle("Introdu numarul de linii si coloane pentru labirint");
		
		JLabel label = new JLabel("10<=Nr linii si coloane:<=20");
		this.add(label);
		
		textField = new JTextField("", 5);
        add(textField);
        
    	JButton btn = new JButton("Incepe");
		this.add(btn);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				numarLiniiColoaneLabirint = Integer.parseInt(text);
				
				
				if(numarLiniiColoaneLabirint>=10 && numarLiniiColoaneLabirint<=20)
				{
					Model model = new Model(numarLiniiColoaneLabirint);
					View  view = new View(model);
					view.setVisible(true);
					
					Controller controller = new Controller(model,view);
					setVisibleFalse();
				}
				
				else
				{
					System.out.println("Numarul trebuie sa fie cel putin 10 si cel mult 20");
					textField.setText("");
				}
			}
		});	
	}
	
	void setVisibleFalse()
	{
		this.setVisible(false);
	}
}

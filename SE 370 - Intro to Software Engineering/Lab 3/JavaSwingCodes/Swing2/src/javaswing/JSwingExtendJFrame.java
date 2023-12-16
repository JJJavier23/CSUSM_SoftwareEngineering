package javaswing;

import javax.swing.*;

public class JSwingExtendJFrame extends JFrame{
	
	JFrame f;
	
	JSwingExtendJFrame(){
		
		JButton b = new JButton("submit");
		b.setBounds(130,100,90,30);
		
		add(b);
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JSwingExtendJFrame();

	}

}

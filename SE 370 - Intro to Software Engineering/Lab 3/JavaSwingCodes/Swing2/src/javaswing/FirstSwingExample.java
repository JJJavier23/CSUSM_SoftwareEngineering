package javaswing;

import javax.swing.*;

public class FirstSwingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame();
		
		JButton b = new JButton("submit");
		b.setBounds(100,130,90,30);
		
		f.add(b);
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);

	}

}

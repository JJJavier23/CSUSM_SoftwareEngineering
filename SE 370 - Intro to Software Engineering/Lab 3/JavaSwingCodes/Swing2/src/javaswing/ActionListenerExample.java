package javaswing;

import javax.swing.*;
import java.awt.event.*;

public class ActionListenerExample implements ActionListener{
	
	JTextField t1,t2;
	JButton b;
	
	ActionListenerExample(){
		JFrame f= new JFrame();
		
		t1 = new JTextField();
		t1.setBounds(100,130,90,30);
		
		t2 = new JTextField();
		t2.setBounds(100,160,90,30);
		
		b = new JButton("check");
		b.setBounds(130,200,90,30);
		
		b.addActionListener(this);
		
		f.add(t1);
		f.add(t2);
		f.add(b);
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String s1 = t1.getText();
		String s2 = t2.getText();
		
		int a = Integer.parseInt(s1);
		int b = Integer.parseInt(s2);
		
		System.out.printf("The numbers are: %d, %d", a, b);
		
	}
	
	public static void main(String args[]) {
		new ActionListenerExample();
	}

}

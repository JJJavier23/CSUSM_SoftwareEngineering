package javaswing;

import javax.swing.*;

public class JSwingtextField {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame("Frame for text fields");
		
		JTextField t1,t2;
		
		t1 = new JTextField();
		t1.setBounds(100,140,90,30);
		t2 = new JTextField();
		t2.setBounds(100,190,90,30);		
		
		f.add(t1);
		f.add(t2);
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		

	}

}

package com.anjava;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class SignUpPanel extends JPanel implements ActionListener{
	
	String[] categories = {"Name", "ID", "Password", "Password Check", "Student ID", "Email"};
	JTextField[] fields = new JTextField[categories.length];
	
	SignUpPanel(){

		for(int i = 0; i < categories.length; i++) {
			fields[i] = new JTextField(15);
			fields[i].setToolTipText(categories[i]);
			this.add(fields[i]);
		}
		this.setBorder(new LineBorder(Color.black));
		this.setLayout(new GridLayout(6,0,10,10));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
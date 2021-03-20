package com.anjava;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class LoggedInPanel extends JPanel implements ActionListener{
	JButton[] reserveBtn = new JButton[12];
	JScrollPane scroll;
	LoggedInPanel(){

		
		
		//Buttons
		for(int i = 0; i < 12; i++) {
			reserveBtn[i] = new JButton();
			reserveBtn[i].setBackground(Color.gray.brighter());
			reserveBtn[i].setBorder(null);
			reserveBtn[i].addActionListener(this);
			this.add(reserveBtn[i]);
		}
		
		//Scroll
		if(reserveBtn.length > 12)
		scroll = new JScrollPane();
		
		//PanelSetting
		this.setBounds(6,54,600,400);
		this.setLayout(new GridLayout(3,4,5,5));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//호실 눌렀을 때
		for(int i=0; i <12; i++) {
			reserveBtn[i].setVisible(false);
		}
		
	}

}

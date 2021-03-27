package com.anjava;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class LoggedInPanel extends JPanel implements ActionListener{
	JButton[] reserveBtn = new JButton[12];
	JPanel labelPanel;
	
	LoggedInPanel(){

		
		
		//Buttons
		for(int i = 0; i < 12; i++) {
			reserveBtn[i] = new JButton("<HTML>본관 202호실<br>예약 현황20/40<br>좌석초기화:2021/03/09<br>앞으로 27일 5시간 39분<HTML>");
			reserveBtn[i].setBackground(Color.gray.brighter());
			reserveBtn[i].setBorder(null);
			reserveBtn[i].addActionListener(this);
			this.add(reserveBtn[i]);
		}
		
		
		
		
		
		
		//PanelSetting
		this.setBounds(6,54,600,400);
		this.setLayout(new GridLayout(3,4,5,5));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//예약버튼설정
		for(int i=0; i <12; i++) {
			reserveBtn[i].setVisible(false);
		}
		
	}

}

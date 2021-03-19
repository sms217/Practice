package com.anjava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;


public class MainLogin extends JFrame implements ActionListener{
	JPanel logInPanel, loggedInPanel;
	JLabel mainTitle, subTitle, idLabel, pwdLabel;
	JTextField ID;
	JPasswordField pwdArea;
	JButton logInBtn, signUpBtn;
	JDialog logInPopUp, signUpPopUp;
	
	FakeDB fake = new FakeDB();
	
	MainLogin(){
		
		//LogInPanel
		logInPanel = new JPanel();
		
		
		//TitleLabel
		 //Main Title
		mainTitle = new JLabel("영진 2WDJ 좌석 예약");
		mainTitle.setBounds(155,-160,500,500);
		mainTitle.setFont(new Font(null,Font.CENTER_BASELINE,50));
		
		 //Sub Title
		subTitle = new JLabel("Anjava");
		subTitle.setBounds(365,-110,500,500);
		subTitle.setFont(new Font(null,Font.BOLD,22));
		
		
		//TextField
		 //ID
		ID = new JTextField(15);
		ID.setBounds(64,20,135,20);
		
		  //ID Label
		idLabel = new JLabel("ID");
		idLabel.setBounds(47,20,135,20);
		
		 //Password
		pwdArea = new JPasswordField(15);
		pwdArea.setBounds(64,45,135,20);
		
		  //Password Label
		pwdLabel = new JLabel("PW");
		pwdLabel.setBounds(38,45,135,20);
		
		
		//Button
		 //LogIn Button
		logInBtn = new JButton("로그인");
		logInBtn.setBounds(85, 75, 80, 25);
		logInBtn.addActionListener(this);
		
		 //SignUp Button
		signUpBtn = new JButton("회원가입");
		signUpBtn.setBounds(80, 110, 90, 25);
		signUpBtn.addActionListener(this);
		
		
		
		
		
		//Panel Setting
		logInPanel.setBorder(new LineBorder(Color.blue));
		logInPanel.setLayout(null);
		logInPanel.setBounds(275, 190, 250, 150);
		logInPanel.add(ID);
		logInPanel.add(pwdArea);
		logInPanel.add(idLabel);
		logInPanel.add(pwdLabel);
		logInPanel.add(logInBtn);
		logInPanel.add(signUpBtn);
		
		//Frame Setting
		this.setLayout(null);
		this.add(mainTitle);
		this.add(subTitle);
		this.add(logInPanel);
		this.setTitle("Anjava(앉아봐)");
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		MainLogin lg = new MainLogin();
		
		
		//로그인버튼을 눌렀을 때
		if(e.getSource()==logInBtn) {
			lg.ID.setText(lg.ID.getText());
			System.out.println(lg.ID.getText());
			if(lg.ID.getText().equals(fake.fakeID)) {
				lg.logInPanel.setVisible(false);
				lg.mainTitle.setVisible(false);
				lg.subTitle.setVisible(false);
				
				loggedInPanel = new JPanel();
				loggedInPanel.setBounds(0,0,800,500);
				loggedInPanel.setBorder(new LineBorder(Color.pink));
				lg.add(loggedInPanel);
			}else {
				JOptionPane.showInternalMessageDialog(null, "로그인 정보가 일치하지 않습니다.", "정보 불일치",0 );
			}
		}
		
		//회원가입버튼을 눌렀을 때
		if(e.getSource()==signUpBtn) {
			
		}
		
	}
	public static void main(String[] args) {
		new MainLogin();
	}
}

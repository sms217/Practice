package com.anjava;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;


public class MainLogin extends JFrame implements ActionListener{
	JPanel logInPanel;
	JLabel mainTitle, subTitle, idLabel, pwdLabel, welcome;
	JTextField ID;
	JPasswordField PASSWORD;;
	JButton logInBtn, signUpBtn;
	JDialog logInPopUp, signUpPopUp;
	
	LoggedInPanel loggedInPanel = new LoggedInPanel();
	FakeDB fake = new FakeDB();
	
	MainLogin(){
		
		//Panel
		 //LogInPanel
		logInPanel = new JPanel();
		
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		
		//Label
		
		 //Main Title Label
		mainTitle = new JLabel("영진 2WDJ 좌석 예약");
		mainTitle.setBounds(155,-160,500,500);
		mainTitle.setFont(new Font(null,Font.CENTER_BASELINE,50));
		
		 //Sub Title Label
		subTitle = new JLabel("Anjava");
		subTitle.setBounds(365,-110,500,500);
		subTitle.setFont(new Font(null,Font.BOLD,22));
		
		 //ID Label
		idLabel = new JLabel("ID");
		idLabel.setBounds(47,20,135,20);
		
		 //Password Label
		pwdLabel = new JLabel("PW");
		pwdLabel.setBounds(38,45,135,20);
		
		 //welcome Label
		welcome = new JLabel("안녕하세요. " + fake.fakeName + "님");
		welcome.setBounds(5,-123,300,300);
		welcome.setFont(new Font(null,Font.CENTER_BASELINE,30));
		welcome.setVisible(false);
		
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		
		//TextField
		 //ID
		ID = new JTextField(15);
		ID.setBounds(64,20,135,20);
	
		 //Password
		PASSWORD = new JPasswordField(15);
		PASSWORD.setBounds(64,45,135,20);
		
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		
		//Button
		 //LogIn Button
		logInBtn = new JButton("로그인");
		logInBtn.setBounds(85, 75, 80, 25);
		logInBtn.addActionListener(this);
		
		 //SignUp Button
		signUpBtn = new JButton("회원가입");
		signUpBtn.setBounds(80, 110, 90, 25);
		signUpBtn.addActionListener(this);
		
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		
		
		//Panel Setting
		logInPanel.setBorder(new LineBorder(Color.blue));
		logInPanel.setLayout(null);
		logInPanel.setBounds(275, 190, 250, 150);
		logInPanel.add(ID);
		logInPanel.add(PASSWORD);
		logInPanel.add(idLabel);
		logInPanel.add(pwdLabel);
		logInPanel.add(logInBtn);
		logInPanel.add(signUpBtn);
		
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		
		
		//Frame Setting
		this.setLayout(null);
		this.add(mainTitle);
		this.add(subTitle);
		this.add(logInPanel);
		this.setTitle("Anjava(앉아봐)");
		this.add(welcome);
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
			
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		MainLogin logInfo = new MainLogin();
		//아이디, 비밀번호 설정
		String userID = fake.fakeID;
		String userPwd = fake.fakePW;
		logInfo.ID.setText(userID);
		logInfo.PASSWORD.setText(userPwd);
		
		//로그인버튼을 눌렀을 때
		if(e.getSource()==logInBtn) {			
			if(logInfo.ID.getText().equals(userID) && logInfo.PASSWORD.getText().equals(userPwd)) {
				logInfo.logInPanel.setVisible(false);
				logInfo.mainTitle.setVisible(false);
				logInfo.subTitle.setVisible(false);
				logInfo.add(welcome);
				logInfo.add(loggedInPanel);
				welcome.setVisible(true);
			}else {
				JOptionPane.showInternalMessageDialog(null, "로그인 정보가 일치하지 않습니다.", "정보 불일치",0 );
			}
		}
		
		//회원가입버튼을 눌렀을 때
		if(e.getSource()==signUpBtn) {
			SignUpPanel signUpPanel = new SignUpPanel();
			logInfo.logInPanel.setVisible(false);
			logInfo.mainTitle.setVisible(false);
			logInfo.subTitle.setVisible(false);
			logInfo.setLayout(new FlowLayout());
			welcome.setVisible(false);
			logInfo.add(signUpPanel);
			
		}
		
	}
	public static void main(String[] args) {
		new MainLogin();
	}
}

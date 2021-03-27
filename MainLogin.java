package com.anjava;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;


public class MainLogin extends JFrame implements ActionListener{
	JPanel logInPanel, signUpBtnPanel, logInLabelPanel;
	JLabel[] logInLabels;
	JLabel mainTitle, subTitle, idLabel, pwdLabel, welcome;
	JTextField ID;
	JPasswordField PASSWORD;;
	JButton logInBtn, signUpBtn, signUpBtn2;
	LoggedInPanel loggedInPanel = new LoggedInPanel();
	FakeDB fake = new FakeDB();
	
	MainLogin(){
		
		//Panel
		 //LogInPanel
		logInPanel = new JPanel();
		
		
		//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
		
		
		//Label
		
		 //Main Title Label
		mainTitle = new JLabel("���� 2WDJ �¼� ����");
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
		welcome = new JLabel("�ȳ��ϼ���. " + fake.fakeName + "��");
		welcome.setBounds(5,-123,300,300);
		welcome.setFont(new Font(null,Font.CENTER_BASELINE,30));
		welcome.setVisible(false);
		
		
		//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
		
		
		//TextField
		
		 //ID
		ID = new JTextField(15);
		ID.setBounds(64,20,135,20);
	
		 //Password
		PASSWORD = new JPasswordField(15);
		PASSWORD.setBounds(64,45,135,20);
		
		
		//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
		
		
		//Button
		 //LogIn Button
		logInBtn = new JButton("�α���");
		logInBtn.setBounds(85, 75, 80, 25);
		logInBtn.addActionListener(this);
		
		 //SignUp Button
		signUpBtn = new JButton("ȸ������");
		signUpBtn.setBounds(80, 110, 90, 25);
		signUpBtn.addActionListener(this);
		
		
		//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
		
		
		
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
		
		
		//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
		
		
		//Frame Setting
		this.setLayout(null);
		this.add(mainTitle);
		this.add(subTitle);
		this.add(logInPanel);
		this.setTitle("Anjava(�ɾƺ�)");
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
		
		//���̵�, ��й�ȣ ����
		String userID = fake.fakeID;
		String userPwd = fake.fakePW;
		
		
		//�α��ι�ư�� ������ ��
		if(e.getSource()==logInBtn) {			
			if(ID.getText().equals(userID)&&PASSWORD.getText().equals(fake.fakePW)) {
				logInfo.logInPanel.setVisible(false);
				logInfo.mainTitle.setVisible(false);
				logInfo.subTitle.setVisible(false);
				logInfo.add(welcome);
				logInfo.add(loggedInPanel);
				welcome.setVisible(true);
			}else {
				JOptionPane.showInternalMessageDialog(null, "�α��� ������ ��ġ���� �ʽ��ϴ�.", "���� ����ġ",0 );
			}
		}
		
		
		
		//ȸ�����Թ�ư�� ������ ��
		if(e.getSource()==signUpBtn) {
			
			SignUpPanel signUpPanel = new SignUpPanel();
			signUpBtnPanel = new JPanel();
			
			logInLabelPanel = new JPanel();
			logInLabels = new JLabel[signUpPanel.categories.length];
			for(int i = 0; i < signUpPanel.categories.length; i++) {
				logInLabels[i] = new JLabel(signUpPanel.categories[i]);
				logInLabels[i].setHorizontalAlignment(JLabel.RIGHT);
				logInLabelPanel.add(logInLabels[i]);
			}
			
			
			logInLabelPanel.setLayout(new GridLayout(6,0,10,10));
			logInLabelPanel.setBounds(90,100,200,200);
			
			
			
			signUpBtn2 = new JButton("ȸ������");
			signUpBtnPanel.add(signUpBtn2);
			signUpBtnPanel.setBounds(347,310,100,40);
			
			signUpBtn2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//ȸ�������� DB�� �ø��� �ڵ�
					
					logInfo.remove(signUpPanel);
					//�ٽ� �α���ȭ������
					logInfo.logInPanel.setVisible(true);
					logInfo.mainTitle.setVisible(true);
					logInfo.subTitle.setVisible(true);
					for(int i = 0; i < signUpPanel.categories.length; i++) {
						logInLabels[i].setVisible(false);
					}
					signUpBtn2.setVisible(false);
					
					JOptionPane.showInternalMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.\n�ٽ� �α����Ͻʽÿ�.","ȸ�����ԿϷ�",1);
				}				
			});
			
			
			
			
			
			logInfo.logInPanel.setVisible(false);
			logInfo.mainTitle.setVisible(false);
			logInfo.subTitle.setVisible(false);
			welcome.setVisible(false);
			
			
			logInfo.add(logInLabelPanel);
			logInfo.add(signUpBtnPanel);
			logInfo.add(signUpPanel);
		}
		
	}
	public static void main(String[] args) {
		new MainLogin();
	}
}

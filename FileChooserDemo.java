package practicegui;

import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class FileChooserDemo extends JFrame implements ActionListener{
	
	JButton openBtn, saveBtn;
	JFileChooser fc;
	FileChooserDemo(){
		setTitle("���� ���ñ� �׽�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		
		fc = new JFileChooser();
		
		JLabel label = new JLabel("���� ���ñ� ������Ʈ �׽�Ʈ�Դϴ�.");
		openBtn = new JButton("OPEN");
		openBtn.addActionListener(this);
		
		saveBtn = new JButton("SAVE");
		saveBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(openBtn);
		panel.add(saveBtn);
		
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args) {
		new FileChooserDemo();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openBtn) {
			int returnVal = fc.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
			}else {
				
			}
		}else if(e.getSource() == saveBtn) {
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
			}else {
			
			}
		}
		
	}

}

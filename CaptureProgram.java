package practicegui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CaptureProgram extends JFrame implements ActionListener{
	private JTextField width, height;
	
	CaptureProgram(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1000,1000);
		JButton button = new JButton("Capture Screen");
		button.addActionListener(this);
		
		JPanel panel = new JPanel();
		
		JLabel wLabel = new JLabel("set width : ");
		panel.add(wLabel);
		
		width = new JTextField(7);	
		panel.add(width);
		
		JLabel hLabel = new JLabel("set height : ");
		panel.add(hLabel);
		
		height = new JTextField(7);		
		panel.add(height);
		panel.add(button);
		
		add(panel);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CaptureProgram();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Dimension d;
		setSize(d = new Dimension(Integer.parseInt(width.getText()),Integer.parseInt(height.getText())));
		Rectangle rect = new Rectangle(Integer.parseInt(width.getText()),Integer.parseInt(height.getText()));
		try {
			Robot robot = new Robot();
			final BufferedImage img = robot.createScreenCapture(rect);
			img.flush();
			JPanel panel = new JPanel() {
				public void paintComponent(Graphics g) {
					g.drawImage(img, 0, 0, d.width, d.height, this);
				}
			};
			panel.setOpaque(false);
			panel.prepareImage(img, panel);
			panel.repaint();
			getContentPane().add(panel);
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

}

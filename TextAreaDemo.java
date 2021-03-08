package practicegui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaDemo extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextArea textArea;
	
	TextAreaDemo(){
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		
		textField = new JTextField(30);
		panel.add(textField);
		textField.addActionListener(this);
		
		textArea = new JTextArea(10, 30);
		panel.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(scrollPane);
		add(panel);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = textField.getText();
		textArea.append(text + "\n");
		textField.selectAll();
		textArea.setCaretPosition(textArea.getDocument().getLength());
		
	}
	public static void main(String[] args) {
		new TextAreaDemo();
	}
}

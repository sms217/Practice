package gui;

import javax.swing.*;
import java.awt.event.*;

public class TextAreaDemo extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextArea textArea;

    TextAreaDemo(){
        JPanel panel = new JPanel();
        textField = new JTextField(30);
        panel.add(textField);
        textField.addActionListener(this);


        textArea = new JTextArea(10,30);
        panel.add(textArea);

        
        setSize(400,500);
        setResizable(false);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        textArea.append(textField.getText() + "\n");
        textField.selectAll();
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    public static void main(String[] args) {
        new TextAreaDemo();
    }
    
}

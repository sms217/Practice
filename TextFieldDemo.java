package gui;

import javax.swing.*;
import java.awt.event.*;

public class TextFieldDemo extends JFrame implements ActionListener {

    private JTextField input, squared;
    private JButton button;

    public TextFieldDemo(){
        setSize(300,200);
        setTitle("Square");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("숫자 입력 : "));
        input = new JTextField(15);
        panel.add(input);
        
        panel.add(new JLabel("제곱한 값 : "));
        squared = new JTextField(15);
        panel.add(squared);
        
        squared.setEditable(false);

        button = new JButton("제곱");
        button.addActionListener(this);
        panel.add(button);


        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        squared.setText(Integer.toString(Integer.parseInt(input.getText())*Integer.parseInt(input.getText())));        


    }
    public static void main(String[] args) {
        new TextFieldDemo();
    }
}

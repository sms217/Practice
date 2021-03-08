package gui;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.border.*;

public class RadioButtonDemo extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JPanel topPanel, sizePanel, resultPanel;
    private JRadioButton small, medium, large;
    private JLabel textLabel;

    public RadioButtonDemo(){
        topPanel = new JPanel();
        JLabel label = new JLabel("어떤 크기의 커피를 주문하시겠습니까?");
        topPanel.add(label);

        this.add(topPanel, BorderLayout.NORTH);


        sizePanel = new JPanel();
        small = new JRadioButton("Small Size");
        small.addActionListener(this);
        medium = new JRadioButton("Medium Size");
        medium.addActionListener(this);
        large = new JRadioButton("Large Size");
        large.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(small);
        group.add(medium);
        group.add(large);

        sizePanel.add(small);
        sizePanel.add(medium);
        sizePanel.add(large);
        Border border = BorderFactory.createTitledBorder("크기");
        sizePanel.setBorder(border);

        this.add(sizePanel, BorderLayout.CENTER);

        resultPanel = new JPanel();
        textLabel = new JLabel("크기가 선택되지 않았습니다.");
        textLabel.setForeground(Color.red);
        resultPanel.add(textLabel);

        this.add(resultPanel, BorderLayout.SOUTH);

        this.setSize(400,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == small){
            textLabel.setText("Small 크기가 선택되었습니다.");
        }else if(e.getSource() == medium){
            textLabel.setText("Medium 크기가 선택되었습니다.");
        }else{
            textLabel.setText("Large 크기가 선택되었습니다.");
        }

    }
    public static void main(String[] args) {
        new RadioButtonDemo();
    }
    
}

package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TextConverter extends JFrame implements ActionListener {

    JButton converter, canceler;
    JTextArea textIn, textOut;

    public TextConverter(){
        // super("Papago 영어사전");


        //텍스트 영역
        textIn = new JTextArea(10,14);
        textOut = new JTextArea(10,14);
        textIn.setLineWrap(true);
        textOut.setLineWrap(true);
        textOut.setEnabled(false); 

        //텍스트 영역을 관리할 패널
        JPanel textPanel = new JPanel(new GridLayout(1,2,20,20));
        textPanel.add(textIn);
        textPanel.add(textOut);

        //버튼
        converter = new JButton("변환");
        canceler = new JButton("취소");
        converter.addActionListener(this);
        canceler.addActionListener(this);

        //버튼패널
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(converter);
        buttonPanel.add(canceler);

        //메인패널
        JPanel mainPanel = new JPanel(new BorderLayout(10,10));
        mainPanel.add(BorderLayout.CENTER, textPanel);
        mainPanel.add(BorderLayout.SOUTH, buttonPanel);

        //프레임설정
        setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        add(mainPanel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("파파고 영어사전");
        setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == converter){
            textOut.setText("");
            String result = toEnglish(textIn.getText());
            textOut.append(result);
        }
        if(e.getSource()==canceler){
            textOut.setText("");
        }

    }
    private String toEnglish(String Korean){
        String result = Korean;
        result = result.replace("텍스트", "Text");
        result = result.replace("영어", "English");
        return result;
    }
    public static void main(String[] args) {
        new TextConverter();
    }
    
}

package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComboBox extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField add;
    private JButton btn;
    private JComboBox<String> animalList;

    public ComboBox(){
        setTitle("COMBO BOX");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,300);

        
        JPanel panel = new JPanel();
        add = new JTextField(10);
        add.addActionListener(this);
        // add.replaceSelection("grape");
        
        String[] animals = {"dog", "orange", "apple"};
        animalList = new JComboBox<>(animals);
        animalList.setEditable(true);
        animalList.setSelectedIndex(0);
        animalList.addActionListener(this);
        
        
        btn = new JButton("항목추가");
        btn.addActionListener(new BtnListener());

        
        
        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        changePicture(animals[animalList.getSelectedIndex()]);
        
        add(animalList, BorderLayout.PAGE_START);
        add(panel);
        panel.add(add);
        panel.add(btn);
        add(label, BorderLayout.PAGE_END);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String name = (String)cb.getSelectedItem();
        changePicture(name); 
    }
    
    protected void changePicture(String name) {
        ImageIcon icon = new ImageIcon("gui\\"+name + ".gif");
        label.setIcon(icon);
        
        if(icon != null){
            label.setText(null);
        } else {
            label.setText("이미지가 발견되지 않았습니다.");
        }
    }
    
    
    
    public static void main(String[] args) {
        new ComboBox();
    }
    class BtnListener implements ActionListener{
    
        @Override
        public void actionPerformed(ActionEvent e) {
            animalList.addItem(add.getText());
        }
    
    }
}
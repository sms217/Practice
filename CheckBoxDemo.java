package gui;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
public class CheckBoxDemo extends JPanel implements ItemListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JCheckBox[] checkBoxes = new JCheckBox[3];
    private String[] fruits = {"apple", "grape", "orange"};
    private JLabel[] labels = new JLabel[3];
    private ImageIcon[] icons = new ImageIcon[3];


    public CheckBoxDemo(){
        this.setLayout(new GridLayout(0,4));
        
        for(int i = 0; i < checkBoxes.length; i++){
            checkBoxes[i] = new JCheckBox(fruits[i]);
            checkBoxes[i].addItemListener(this);
            labels[i] = new JLabel("gui\\" + fruits[i] + ".gif");
            icons[i] = new ImageIcon("gui\\" + fruits[i] + ".gif");
        }

        JPanel checkBoxPanel = new JPanel(new GridLayout(0,1));
        for(int i = 0; i < checkBoxes.length; i++){
            checkBoxPanel.add(checkBoxes[i]);
        }
        this.add(checkBoxPanel);
        for(int i = 0; i < labels.length; i++){
            this.add(labels[i]);
        }

    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        e.getItemSelectable(); //checkbox의 value,source를 object타입으로 리턴해줌
        Object source = e.getItemSelectable();
        for(int i = 0; i < checkBoxes.length; i++){
            if(source == checkBoxes[i]){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    labels[i].setIcon(icons[i]);
                    labels[i].setText(" ");
                }
                else {
                    labels[i].setIcon(null);
                    labels[i].setText("gui\\" + fruits[i] + ".gif");
                }
            }
        }


    }
    
    public static void main(String[] args) {
        JFrame frame= new JFrame("CheckBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CheckBoxDemo());
        frame.setSize(500,200);
        frame.setVisible(true);

    }
}

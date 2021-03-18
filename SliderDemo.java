package practicegui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderDemo extends JFrame implements ChangeListener{
	static final int INIT_VALUE = 15;
	private JButton button1; 
	private JSlider slider;
	
	public SliderDemo(){
		setSize(300,300);
		JPanel panel = new JPanel();
		setTitle("Slider Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		slider = new JSlider(0, 30, INIT_VALUE);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(0);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(this);
		panel.add(slider);
		
		JLabel label = new JLabel("슬라이더를 움직여 보세요.");
		panel.add(label);
		
		button1 = new JButton();
		ImageIcon icon = new ImageIcon("car.jpg");
		button1.setIcon(icon);
		button1.setSize(INIT_VALUE * 10, INIT_VALUE*10);
		panel.add(button1);
		
		add(panel);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new SliderDemo();
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if(!source.getValueIsAdjusting()) {
			int value = (int)source.getValue();
			button1.setSize(value*10,value*10);
		}
		
	}
}

package gui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class OrderPizzaFrame extends JFrame implements ActionListener {

    private int sum,temp1,temp2,temp3;
    private JButton orderBtn, cancleBtn;
    private JTextField text;
    private JPanel welcomePanel, downPanel;
    private JLabel message;

    typePanel typePanel = new typePanel();
    toppingPanel toppingPanel = new toppingPanel();
    sizePanel sizePanel = new sizePanel();


    public OrderPizzaFrame(){
        this.setSize(500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("피자주문");
        this.orderBtn = new JButton("주문");
        this.orderBtn.addActionListener(this);
        orderBtn.setBackground(Color.pink);
        this.cancleBtn = new JButton("취소");
        cancleBtn.setBackground(Color.pink);
        this.cancleBtn.addActionListener(this);
        this.text = new JTextField();
        text.setEditable(false);
        text.setColumns(6);

        this.downPanel = new JPanel();
        downPanel.add(orderBtn);
        downPanel.add(cancleBtn);
        downPanel.add(text);

        this.welcomePanel = new JPanel();
        message = new JLabel("피자가게에 오신 것을 환영합니다.");
        welcomePanel.add(message);

        this.setLayout(new BorderLayout());
        this.add(welcomePanel,BorderLayout.NORTH);
        this.add(downPanel,BorderLayout.SOUTH);
        this.add(toppingPanel,BorderLayout.CENTER);
        this.add(sizePanel,BorderLayout.EAST);
        this.add(typePanel,BorderLayout.WEST);
        
        
        
        
        
        this.setVisible(true);
    }
    class typePanel extends JPanel{
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private JRadioButton combo, potato, bulgogi;
        private ButtonGroup bg;

        public typePanel() {
            setLayout(new GridLayout(3,1));
            combo = new JRadioButton("콤보",true);
            potato = new JRadioButton("포테이토");
            bulgogi = new JRadioButton("불고기");

            bg = new ButtonGroup();
            bg.add(combo);
            bg.add(potato);
            bg.add(bulgogi);
            setBorder(BorderFactory.createTitledBorder("종류"));

            add(combo);
            add(potato);
            add(bulgogi);
        }
    }

    class toppingPanel extends JPanel{
        private JRadioButton pepper, cheese, peperoni, bacon;
        private ButtonGroup bg;
        
        public toppingPanel(){
            setLayout(new GridLayout(4,1));

            pepper = new JRadioButton("피망",true);
            cheese = new JRadioButton("치즈");
            peperoni = new JRadioButton("페퍼로니");
            bacon = new JRadioButton("베이컨");

            bg = new ButtonGroup();
            bg.add(pepper);
            bg.add(cheese);
            bg.add(peperoni);
            bg.add(bacon);

            setBorder(BorderFactory.createTitledBorder("추가토핑"));
            add(pepper);
            add(cheese);
            add(peperoni);
            add(bacon);
            
        }
    }

    class sizePanel extends JPanel{
        private JRadioButton small, medium, large;
        private ButtonGroup bg;
        public sizePanel(){
            setLayout(new GridLayout(3,1));

            small = new JRadioButton("SMALL", true);
            medium = new JRadioButton("MEDIUM");
            large = new JRadioButton("LARGE");

            bg = new ButtonGroup();
            bg.add(small);
            bg.add(medium);
            bg.add(large);

            setBorder(BorderFactory.createTitledBorder("사이즈"));
            add(small);
            add(medium);
            add(large);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==orderBtn){
            text.setText("" + 20000);
        }
        if(e.getSource()==cancleBtn){
            temp1 = 0;
            temp2 = 0;
            temp3 = 0;
            sum = 0;
            text.setText(""+sum);
        }

    }
    public static void main(String[] args) {
        new OrderPizzaFrame();
    }
    
}

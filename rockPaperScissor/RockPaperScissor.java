package rockPaperScissor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RockPaperScissor extends JFrame{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    RockPaperScissor() {
        //제일 큰 패널
        JPanel basePanel = new RPSPanel();
        
        this.setTitle("RPS");
        this.add(basePanel);
        this.setSize(400,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new RockPaperScissor();
    }
    
}

class RPSPanel extends JPanel implements ActionListener {
   
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton[][] btns = new JButton[2][3];
    private int count = 0;
    private JLabel result = new JLabel("DRAW");
    private int selectedBtn = 0;
    private boolean isRandBtn = false;
    private boolean isBtnPressed = false;
    private JButton startBtn = new JButton("START");
    private JButton exitBtn = new JButton("EXIT");
    private JLabel computerWin = new JLabel();
    private JLabel userWin = new JLabel();
    private int com = 0;
    private int user = 0;
   
   public RPSPanel() {
        String[] arr = {"ROCK","PAPER","SCISSOR"};
        
        startBtn.setFocusable(false);
        startBtn.setBackground(Color.white);
        
        //종료버튼
        exitBtn.setVisible(false);
        exitBtn.setFocusable(false);
        exitBtn.setBackground(Color.white);
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        //게임 시작 전 닉네임 설정
        JTextField setUser = new JTextField(10);

        //게임 안 문구들
        JLabel mainLabel = new JLabel("Set your nickname.");
        JLabel userNickname = new JLabel();
        JLabel computer = new JLabel("Computer");
        JLabel ftg = new JLabel("from the game.");
        result.setFont(new Font("Serif",Font.BOLD|Font.ITALIC, 45));
        result.setVisible(false);
        ftg.setVisible(false);
        this.setLayout(new GridLayout(3,0));
        this.setBackground(Color.ORANGE);
        
        //Top
        JPanel topPanel = new JPanel();
        this.add(topPanel);
        topPanel.setBackground(Color.CYAN);
        topPanel.setVisible(false);
        topPanel.add(userNickname);
        
        //Center
        JPanel centerPanel = new JPanel();
        this.add(centerPanel);
        centerPanel.setBackground(Color.GREEN);
        centerPanel.add(mainLabel);
        centerPanel.add(setUser);
        centerPanel.add(startBtn);
        centerPanel.add(exitBtn);
        centerPanel.add(ftg);
        centerPanel.add(result);
        
        //Bottom
        JPanel bottomPanel = new JPanel();
        this.add(bottomPanel);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.add(computer);
        bottomPanel.setVisible(false);

        //시작버튼 눌렀을 때
        startBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(setUser.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "You need to set your nickname, before you start the game.");
                }else{
                    topPanel.setVisible(true);
                    bottomPanel.setVisible(true);
                    exitBtn.setVisible(true);
                    ftg.setVisible(true);
                    startBtn.setVisible(false);
                    mainLabel.setText("You can");
                    setUser.setVisible(false);
                    userNickname.setText(setUser.getText());
                    setBackground(Color.white);
                    computerWin.setVisible(true);
                    userWin.setVisible(true);
                }
            }
        });
        
        //버튼 디자인
        for(int i = 0; i < btns.length; i++){
            for(int j = 0; j < btns[0].length; j++){
                btns[i][j] = new JButton(arr[j]);
                btns[i][j].setBackground(Color.white);
                btns[i][j].setFocusable(false);
                if(i==0) {
                    topPanel.add(btns[i][j]);
                    //가위 바위 보 버튼 중에서 하나를 눌렀을 때 발생하는 이벤트
                    btns[i][j].addActionListener(this);
                }
                else if(i==1) bottomPanel.add(btns[i][j]);
            }
        }
        topPanel.add(userWin);
        bottomPanel.add(computerWin);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //가위 바위 보 중 하나를 클릭했을 때 bottomPanel에서 버튼이 색이바뀌다가 멈춘 것이 컴퓨터의 결과.
        if(isBtnPressed) {         
                for(int i=0; i<btns[1].length; i++) {
                    btns[1][i].setBackground(Color.white);
                }
                
                btns[1][count++].setBackground(Color.pink);
                
                if(count>1) {
                    try {
                    Thread.sleep(500);
                    }catch(InterruptedException e) {
                    }
                }
                
                if(count == 3){
                    isRandBtn = true;
                    isBtnPressed = false;
                    count = 0;
                }
                
                repaint();
                
            } else if(isRandBtn) {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                
                for(int i=0; i<btns[0].length; i++) {
                    btns[0][i].setEnabled(true);
                }
                exitBtn.setEnabled(true);
                
                int computersResult = (int)(Math.random()*3);

                for(int i=0; i<btns[1].length; i++) {
                    btns[1][i].setBackground(Color.white);
                }
                btns[1][computersResult].setBackground(Color.pink);
                result.setText(winner(computersResult));
                computerWin.setText("win : " + Integer.toString(com));
                userWin.setText("win : " + Integer.toString(user));
                result.setVisible(true);
        }
    }
    

   //가위 바위 보 버튼 중에서 하나를 눌렀을 때 누른 버튼 색이 바뀜.
   @Override
   public void actionPerformed(ActionEvent e) {
      for(int i = 0; i < btns[0].length; i++){
         if(e.getSource() == btns[0][i]) {
               for(int j=0; j<btns[0].length; j++) {
                  btns[0][j].setForeground(Color.black);
                  btns[0][j].setBackground(Color.white);
                  btns[0][j].setEnabled(false);
               }
                btns[0][i].setBackground(Color.blue);
                btns[0][i].setForeground(Color.white);
                
                isBtnPressed = true;
                exitBtn.setEnabled(false);
                selectedBtn = i;
                result.setVisible(false);

                repaint();
            }
       }
   }

   public String winner(int computersResult){
       String str = "";

       switch(selectedBtn){
           case 0:
           if(computersResult == 0) str = "DRAW. Play Again!";
           else if(computersResult == 1){
               str = "Computer Win!";
               com++;
           }
           else{
               str = "You Win!";
               user++;
            }
           break;

           case 1:
           if(computersResult == 0){
               str = "You Win!";
               user++;
           }
           else if(computersResult == 1) str = "DRAW. Play Again!";
           else {
               str = "Computer Win!";
               com++;
            }
           break;

           case 2:
           if(computersResult == 0){
              str = "Computer Win!";
              com++;
           }   
           else if(computersResult == 1){
               str = "You Win!";
               user++;
           }
           else str =  "DRAW. Play Again!";
           break;
       }
       return str;
   }
}
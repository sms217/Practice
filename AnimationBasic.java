package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class AnimationBasic extends JPanel implements ActionListener {

    /**
     *
     */
    // private final int WIDTH = 500, HEIGHT = 300;
    private static final long serialVersionUID = 1L;
    private BufferedImage image;
    private Timer timer;
    private int x, y;
    private final int START_X = 250, START_Y = 150;
    private int dirX = 1;
    private int dirY = -1;

    public AnimationBasic() {
        // 이미지 파일을 읽어서 image 객체로 생성
        // 10ms 마다 이벤트를 발생시키는 timer객체를 생성하고 timer를 start시킴

        File file = new File("gui\\spaceship.jpg");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        x = START_X;
        y = START_Y;
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //x, y좌표에 이미지를 그린다
        g.drawImage(image, x, y, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // x, y 좌표 변경
        //왼쪽 밑으로 가려면 x-, y+ 
        //오른쪽 밑으로 가려면 x+, y+
        //왼쪽 위로 가려면 x-, y-
        
        if(y < 0 || y+image.getHeight()+33 > 300){ // 위 충돌
            dirY *= -1;
        }
        else if(x < 0 || x+image.getWidth()+ 12 > 500){ //아래 충돌
            dirX *= -1;
        }
   
        x += 1*dirX;
        y += 1*dirY;

        repaint();

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new AnimationBasic());
        frame.setTitle("애니메이션 테스트");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500,300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
    
    
}

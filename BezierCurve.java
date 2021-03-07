package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class BezierCurve extends JFrame implements MouseListener, MouseMotionListener{

    /**
     *
     */
    private int[] xs = {50,150,400,450};
    private int[] ys = {200,50,300,200};
    private int dragIndex = -1;

    private BezierPanel drawPanel;

    class BezierPanel extends JPanel{
        /**
		 *
		 */
		private static final long serialVersionUID = 418723408846527234L;

		@Override
        public void paintComponent(Graphics g){
            //xs배열, ys배열의 좌표를 이용해서 베지어 곡선을 그린다
            g.setColor(Color.blue);
            g.fillRect(xs[0], ys[0], 16, 16);
            g.fillRect(xs[2], ys[2], 16, 16);
            g.setColor(Color.red);
            g.fillRect(xs[1], ys[1], 16, 16);
            g.fillRect(xs[3], ys[3], 16, 16);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.black);
            GeneralPath path = new GeneralPath();
            path.moveTo(xs[0], ys[0]);
            path.curveTo(xs[1], ys[1], xs[2],ys[2],xs[3],ys[3]);
            g2d.draw(path);
        }
    } 

    public BezierCurve() {
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bezier Curve Demo");
        drawPanel = new BezierPanel();
        drawPanel.addMouseListener(this);
        drawPanel.addMouseMotionListener(this);
        add(drawPanel, BorderLayout.CENTER);
    }
    private static final long serialVersionUID = 1L;

    @Override
    public void mouseDragged(MouseEvent e) {
        // 선택된 점이 있는지 보고 즉 dragIndex가 -1이 아닌지 보고
        // 아니라면 선택된 점의 x,y 좌표를 변경한다.
        if(dragIndex != -1){
            xs[dragIndex] = e.getX();
            ys[dragIndex] = e.getY();
        }
        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 네 개의 점 중에서 어떤 점이 눌려졌는지를 체크
        dragIndex = -1;
        for(int i = 0; i < 4; i++){
            Rectangle r = new Rectangle(xs[i] - 4, ys[i] - 4, 20, 20);
            if(r.contains(e.getX(), e.getY())){
                dragIndex = i;
            }
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // 
        dragIndex = -1;
        repaint();

    }
    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}


    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new BezierCurve();
    }
}

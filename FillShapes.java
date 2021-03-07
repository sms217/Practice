package gui;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;



public class MoreShapes extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MoreShapes() {
        setSize(600,130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Java 2D Shapes");
        JPanel panel = new MyPanel();
        add(panel);
        setVisible(true);

    }
    public static void main(String[] args) {
        new MoreShapes();
    }
}
class MyPanel extends JPanel{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    ArrayList<Shape> shapeArray = new ArrayList<Shape>();

    public MyPanel() {

        Shape s;

        
        s = new Rectangle2D.Float(10,10,70,80);
        shapeArray.add(s);

        s = new RoundRectangle2D.Float(110,10,70,80,20,20);
        shapeArray.add(s);

        s = new Ellipse2D.Float(210,10,80,80);
        shapeArray.add(s);

        s = new Arc2D.Float(310,10,80,80,90,90,Arc2D.OPEN);
        shapeArray.add(s);
        
        s = new Arc2D.Float(410,10,80,80,0,180,Arc2D.CHORD);
        shapeArray.add(s);

        s = new Arc2D.Float(510,10,80,80,45,90,Arc2D.PIE);
        shapeArray.add(s);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        

        GradientPaint gp = new GradientPaint(0,10,Color.WHITE,0,70,Color.RED);

        g2.setPaint(Color.RED);
        g2.fill(new Rectangle2D.Float(10,0,70,80));

        g2.setPaint(gp);
        g2.fill(new RoundRectangle2D.Float(110,10,70,80,20,20));

        g2.setPaint(gp);
        g2.fill(new Ellipse2D.Float(210,10,80,80));

        g2.setPaint(gp);
        g2.fill(new Arc2D.Float(310,10,80,80,90,90,Arc2D.OPEN));

        g2.setPaint(gp);
        g2.fill(new Arc2D.Float(410,10,80,80,0,180,Arc2D.CHORD));

        g2.setPaint(gp);
        g2.fill(new Arc2D.Float(510,10,80,80,45,90,Arc2D.PIE));

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for(Shape s : shapeArray)
        g2.draw(s);
    }
}
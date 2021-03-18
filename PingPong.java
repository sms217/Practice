package practicegui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Float;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PingPong extends JPanel implements KeyListener{
	JLabel p1, p2, winner;
	Ball ball;
	Racket racket1;
	Racket racket2;
	int p1Count = 0;
	int p2Count = 0;
	int p1SetCount = 0;
	int p2SetCount = 0;
	int setD = 20;
	private Float p1Set, p2Set;
	static JFrame frame;
	private JPanel overPnl;

	
	
	public PingPong() {
		setLayout(null);
		this.setVisible(true);
		ball = new Ball(this, Color.white);
		this.setBackground(Color.black);
		racket1 = new Racket(this, 0, 180, Color.BLUE);
		racket2 = new Racket(this, 815, 180, Color.yellow);
		setFocusable(true);
		addKeyListener(this);
		
		
		p1 = new JLabel("0");
		p1.setForeground(Color.white);
		p1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		p1.setBounds(500, 200, 200, 800);
		p1.setLocation(355, -365);  // button.setBounds(50,50,100,40);
		add(p1);
		
		p2 = new JLabel("0");
		p2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
		p2.setBounds(500, 200, 200, 800);
		p2.setLocation(429, -365);
		p2.setForeground(Color.white);
		
		add(p2);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.red);
		
		for(int i = 1; i < 4; i++) {
			if(p1SetCount >= i) {
				p1Set = new Ellipse2D.Float(320-i*30,20,20,20);
				g2.draw(p1Set);
				g2.fill(p1Set);
			}
			else if(p2SetCount >= i) {
				p2Set = new Ellipse2D.Float(470+i*30,20,20,20);
				g2.fill(p2Set);
				g2.draw(p2Set);
			}
			
		}
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		racket1.keyPressed(e);
		racket2.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		racket1.keyReleased(e);
		racket2.keyReleased(e);
	}
	
	public void move() {
		ball.move();
		racket1.move();
		racket2.move();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.draw(g2d);
		racket1.draw(g2d);
		racket2.draw(g2d);
	}
	
	class Ball{
		private static final int RADIUS = 10;
		int x = 0;
		int y = 0;
		int xspeed = 1;
		int yspeed = 1;
		private PingPong game;
		Color color;
		
		public Ball(PingPong game, Color color) {
			this.game = game;
			this.color = color;

		}
		

		void move() {
			
			winner = new JLabel("");
			
			
			if(x + xspeed < 0) {
				p2Count++;
				xspeed = 1;
				p2.setText(Integer.toString(p2Count));
				if(p2Count > 9)p2.setLocation(422, -365);
				
					if(p2Count > p1Count && p2Count > 20) {
						p2SetCount++;
						p2Count = 0;
						if(p2SetCount == 3) {
							winner.setText("Player2 win!");
							gameover over = new gameover();
						}
					}
			}
			else if(x + xspeed > game.getWidth() - 2 * RADIUS) {
				p1Count++;
				xspeed = -1;
				p1.setText(Integer.toString(p1Count));
				
				if(p1Count > 9)p1.setLocation(335, -365);
				
					if(p1Count > p2Count && p1Count > 20) {
						p1SetCount++;
						p1Count = 0;
						if(p1SetCount == 3) {
							winner.setText("Player1 win!");
							gameover over = new gameover();
						}
					}
			}
			if(y + yspeed < 0)
				yspeed = 1;
			if(y + yspeed > game.getHeight() - 2 * RADIUS)
				yspeed = -1;
			if(collision()) {
				xspeed = -xspeed;
			}
			x = x + xspeed;
			y = y + yspeed;
		}
		
		public class gameover{
			gameover(){
				try {
					Thread.sleep(1000);
					game.setVisible(false);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				overPnl = new JPanel();
				winner.setFont(new Font(Font.SERIF, Font.BOLD, 60));
				overPnl.add(winner);				
				frame.add(overPnl);
			}
		}
		
		private boolean collision() {
			return game.racket1.getBounds().intersects(getBounds()) || game.racket2.getBounds().intersects(getBounds());
		}
		
		public void draw(Graphics2D g) {
			g.setColor(color);
			g.fillOval(x, y, 2*RADIUS,2*RADIUS);
			g.drawLine(405, 800, 405, 0);
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x,y,2*RADIUS,2*RADIUS);
		}
	}
	
	class Racket{
		private static final int WIDTH = 10;
		private static final int HEIGHT = 80;
		int x = 0;
		int y = 0;
		Color color;
		int xspeed = 0;
		int yspeed1 = 0;
		private PingPong game;
		
		public Racket(PingPong game, int x, int y, Color color) {
			this.game = game;
			this.x = x;
			this.y = y;
			this.color = color;
		}
		public void move() {
			if(y + yspeed1 > 0 && y + yspeed1 < game.getHeight() - HEIGHT) y = y + yspeed1;
		}
		
		public void draw(Graphics2D g) {
			g.setColor(color);
			g.fillRect(x,y, WIDTH, HEIGHT);
		}
		
		public void keyPressed(KeyEvent e) {
			if(x > 100) {	
				if(e.getKeyCode() == KeyEvent.VK_UP) yspeed1 = -5;
				if(e.getKeyCode() == KeyEvent.VK_DOWN) yspeed1 = 5;
			}
				
			else if(x <100) {
				if(e.getKeyCode() == KeyEvent.VK_W) yspeed1 = -5;
				else if(e.getKeyCode() == KeyEvent.VK_S) yspeed1 = 5;
			}
			
		}

		public void keyReleased(KeyEvent e) {
			yspeed1 = 0;
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x,y,WIDTH,HEIGHT);
		}
	}
	public static void main(String[] args) {
		PingPong game = new PingPong();
		frame = new JFrame("TableTennisGame");
		frame.setSize(840,500);
		frame.add(game);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		while(true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(2);
			}catch(InterruptedException g) {
				g.printStackTrace();
			}
		}
	}
	
}

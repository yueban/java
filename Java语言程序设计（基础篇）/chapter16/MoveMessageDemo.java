import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveMessageDemo extends JFrame{
	public static void main(String[] args){
		MoveMessageDemo frame = new MoveMessageDemo();
		frame.setTitle("MoveMessageDemo");
		frame.setSize(200,100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public MoveMessageDemo(){
		MovableMessagePanel panel = new MovableMessagePanel("Welcome to Java");
		setLayout(new BorderLayout());
		add(panel);
	}

	static class MovableMessagePanel extends JPanel{
		private String message = "Welcome to Java";
		private int x = 20;
		private int y = 20;

		public MovableMessagePanel(String s){
			message = s;
			addMouseMotionListener(new MouseMotionAdapter(){
				public void mouseDragged(MouseEvent e){
					x = e.getX();
					y = e.getY();
					repaint();
				}
			});
		}

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawString(message,x,y);
		}
	}
}
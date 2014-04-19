import javax.swing.*;
import java.awt.Graphics;

public class TestPaintComponent extends JFrame{
	public static void main(String[] args){
		TestPaintComponent frame = new TestPaintComponent();
		frame.setTitle("TestPaintComponent");
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public TestPaintComponent(){
		add(new NewPanel());
	}
}

class NewPanel extends JPanel{
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(0,0,50,50);
		g.drawString("Banner",0,40);
		g.drawRoundRect(400, 200, 100, 80, 50, 10);
		g.draw3DRect(100, 100, 120, 60, false);
		g.drawOval(200, 200, 60, 60);
	}
}